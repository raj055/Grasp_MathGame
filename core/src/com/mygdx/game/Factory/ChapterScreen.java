package com.mygdx.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Enum.Steps;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Levels.ReadConfiguration;
import com.mygdx.game.MyGame;
import com.mygdx.game.Tools.Assets;
import com.mygdx.game.Tools.Settings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.mygdx.game.Enum.Chapters.CHAPTER_1;
import static com.mygdx.game.Enum.Chapters.CHAPTER_2;
import static com.mygdx.game.Enum.Chapters.CHAPTER_3;
import static com.mygdx.game.Enum.Chapters.CHAPTER_4;
import static com.mygdx.game.Enum.Chapters.CHAPTER_5;
import static com.mygdx.game.Enum.Chapters.CHAPTER_6;
import static com.mygdx.game.Enum.Chapters.CHAPTER_7;
import static com.mygdx.game.Enum.Chapters.CHAPTER_8;

public abstract class ChapterScreen {

  protected Stage stage;
  Map displaysTotal;
  ArrayList<Image> displayImages;
  ArrayList<Image> displayBallList;
  ArrayList<Image> buttonsList;
  ArrayList<Image> draggable;
  ArrayList<Label> updatables;
  ArrayList<Label> textLabels;
  ArrayList<Image> displayImagesNext;
  ArrayList<Image> scrollingPara;
  ArrayList<Image> draggableNext;
  ArrayList<Label> updatablesNext;
  ArrayList<Label> textLabelsNext;
  ArrayList<Image> scrollingParaNext;
  ArrayList<Image> displayImagesLast;
  ArrayList<Image> draggableLast;
  ArrayList<Label> updatablesLast;
  ArrayList<Label> textLabelsLast;
  ArrayList<Image> scrollingParaLast;
  ArrayList<String> draggableNames;

  protected int currentLevelNumber = 0;
  protected OrthographicCamera cam;
  GlobalsCommonCount gblVar;
  Image bg;

  protected int xPosAdditionFactor = 0;
  static int stepNumber = 0;


  ChapterScreen(){

    //Declare the chapter names and level names.
    String chapterName, levelName;

    //Read the configuration of the array list.
    List result = new ArrayList();
    Map allParameters = new LinkedHashMap();
    ReadConfiguration readConfiguration =  new ReadConfiguration(allParameters);
    readConfiguration.readLayoutArray();
    result.addAll(readConfiguration.layoutArray);

    //Assign the map to the related result
    Map classArray = (Map)result.get(0);
    Map screenMap = null;


    //Initiate stage
    MoveToAction action = new MoveToAction();
    action.setPosition(-400, 0);         // somewhere off screen
    action.setDuration(0.5f);

    bg = new Image(new Texture("data/desertBackground.jpg"));
    bg.addAction(action);
    cam = new OrthographicCamera();
    cam.setToOrtho(false, 400, 700);
    cam.position.set(0,0,0);

    bg.setSize(1200, MyGame.HEIGHT);
    FitViewport viewp = new FitViewport(400, 700, cam); // change this to your needed viewport

    stage = new Stage(viewp);

    Image bg1 = new Image(new Texture("data/desertBackground.jpg"));
    bg1.setSize(1200, MyGame.HEIGHT);
    bg1.setPosition(1200, 0);

    stage.addActor(bg);
    stage.addActor(bg1);
    Gdx.input.setInputProcessor(stage);

    //Get the instance of global class
    gblVar = GlobalsCommonCount.getInstance();

    //read the current configuration
    chapterName = getChapterName();
    levelName = getLevelName();

    gblVar.currentLevel = currentLevelNumber;
    gblVar.currentChapter = GameStates.chapterNumber.ordinal();

    stepNumber = GameStates.steps.ordinal();

    //update the other components of the given screen.
    if(classArray.containsKey(chapterName))
    {
      screenMap = (Map)classArray.get(chapterName);

      if(screenMap.containsKey(levelName)) {
        displaysTotal = (Map) screenMap.get(levelName);
          if (displaysTotal.containsKey(gblVar.StepName[stepNumber])){
            Map currentStepTotal = (Map) displaysTotal.get(gblVar.StepName[stepNumber]);
            populateNextScreen(currentStepTotal, stepNumber++);
            xPosAdditionFactor += 400;
//            if(xPosAdditionFactor > 800)
//              xPosAdditionFactor = 0;
          }
      }
    }
  }

  public boolean goToNextStep(){
    if (displaysTotal.containsKey(gblVar.StepName[stepNumber])){
      Map currentStepTotal = (Map) displaysTotal.get(gblVar.StepName[stepNumber]);
      gblVar.currentStepNumber = stepNumber;
      for(Steps stp : Steps.values()){
        if(stp.getCurrentVal() == stepNumber)
          GameStates.steps = stp;
      }
      populateNextScreen(currentStepTotal, stepNumber++);


//      GameStates.steps = Steps.
      xPosAdditionFactor += 400;
//      if(xPosAdditionFactor > 800)
//        xPosAdditionFactor = 0;
      return true;
    }
    return false;
  }

  public void populateNextScreen(Map displaysTotal, int stepNumber){

    //Get the display objects.
    if (displaysTotal.containsKey("Displays")) {
      //Display labels information
      Map labelInfo = (Map) displaysTotal.get("Displays");

      //Update the current list of Labels.
      displayImages = new ArrayList<Image>(displaysTotal.size());
      updateLabels(labelInfo, displayImages);
    }
    if (displaysTotal.containsKey("Draggable")) {
      //
      Map dragInfo = (Map) displaysTotal.get("Draggable");

      //initialise the array list for the labels.
      draggable = new ArrayList<Image>(dragInfo.size());
      updateDraggableArea(dragInfo, draggable);
    }
    if (displaysTotal.containsKey("Updatable")) {

      Map updatableInfo = (Map) displaysTotal.get("Updatable");

      //initialise the array list for the labels.
      updatables = new ArrayList<Label>(updatableInfo.size());
      getUpdatable(updatableInfo, updatables);
    }

    if (displaysTotal.containsKey("Scrolling")) {
      Map labelInfo = (Map) displaysTotal.get("Scrolling");

      scrollingPara = new ArrayList<Image>(labelInfo.size());
      updateScrolling(labelInfo, scrollingPara);
    }

    if(displaysTotal.containsKey("TextLabel")){
      Map textLabels = (Map) displaysTotal.get("TextLabel");
      updateTextuals(stepNumber, textLabels);
    }
    if(displaysTotal.containsKey("Buttons")){
      Map buttons = (Map) displaysTotal.get("Buttons");
      updateButtons(stepNumber, buttons);
    }
  }

  //Populate the screen by extracting the data.
  public void populateScreen(Map displaysTotal, int stepNumber){
    if (displaysTotal.containsKey("Displays")) {
      Map labelInfo = (Map) displaysTotal.get("Displays");
      //initialise the array list for the labels.
      ArrayList<Image> displayObjects;
      switch (stepNumber)
      {
        case 0:
          displayImages = new ArrayList<Image>(displaysTotal.size());
          displayObjects = this.displayImages;
          break;
        case 1:
          displayImagesNext = new ArrayList<Image>(displaysTotal.size());
          displayObjects = displayImagesNext;
          break;
        case 2:
          displayImagesLast = new ArrayList<Image>(displaysTotal.size());
          displayObjects = displayImagesLast;
          break;

        default:
          displayImages = new ArrayList<Image>(displaysTotal.size());
          displayObjects = this.displayImages;
          break;
      }

      updateLabels(labelInfo, displayObjects);
    }
    if (displaysTotal.containsKey("Draggable")) {
      Map dragInfo = (Map) displaysTotal.get("Draggable");
      //initialise the array list for the labels.
      ArrayList<Image> draggableObjects;
      switch (stepNumber)
      {
        case 0:
          draggable = new ArrayList<Image>(dragInfo.size());
          draggableObjects = draggable;
          break;
        case 1:
          draggableNext = new ArrayList<Image>(dragInfo.size());
          draggableObjects = draggableNext;
          break;
        case 2:
          draggableLast = new ArrayList<Image>(dragInfo.size());
          draggableObjects = draggableLast;
          break;

        default:
          draggable = new ArrayList<Image>(dragInfo.size());
          draggableObjects = draggable;
          break;

      }
      updateDraggableArea(dragInfo, draggableObjects);
    }
    if (displaysTotal.containsKey("Updatable")) {
      Map updatableInfo = (Map) displaysTotal.get("Updatable");
      //initialise the array list for the labels.
      ArrayList<Label> updatableObjects;
      switch (stepNumber)
      {
        case 0:
          updatables = new ArrayList<Label>(updatableInfo.size());
          updatableObjects = updatables;
          break;
        case 1:
          updatablesNext = new ArrayList<Label>(updatableInfo.size());
          updatableObjects = updatablesNext;
          break;
        case 2:
          updatablesLast = new ArrayList<Label>(updatableInfo.size());
          updatableObjects = updatablesLast;
          break;
        default:
          updatables = new ArrayList<Label>(updatableInfo.size());
          updatableObjects = updatables;
          break;
      }
      getUpdatable(updatableInfo, updatableObjects);
    }

    if (displaysTotal.containsKey("Scrolling")) {
      Map labelInfo = (Map) displaysTotal.get("Scrolling");
      ArrayList<Image> scrollableObject;
      switch (stepNumber)
      {
        case 0:
          scrollingPara = new ArrayList<Image>(labelInfo.size());
          scrollableObject = scrollingPara;
          break;
        case 1:
          scrollingParaNext = new ArrayList<Image>(labelInfo.size());
          scrollableObject = scrollingParaNext;
          break;
        case 2:
          scrollingParaLast = new ArrayList<Image>(labelInfo.size());
          scrollableObject = scrollingParaLast;
          break;
        default:
          scrollingPara = new ArrayList<Image>(labelInfo.size());
          scrollableObject = scrollingPara;
          break;
      }
      updateScrolling(labelInfo, scrollableObject);
    }
    if(displaysTotal.containsKey("Buttons")){
      Map buttons = (Map) displaysTotal.get("Buttons");
      updateButtons(stepNumber, buttons);
    }
    if(displaysTotal.containsKey("TextLabel")){
      Map textLabels = (Map) displaysTotal.get("TextLabel");
      updateTextuals(stepNumber, textLabels);
    }
  }
  public void updateButtons(int stepNumber, Map buttons){
    //initialise the array list for the labels.
    buttonsList = new ArrayList<Image>();

    Label.LabelStyle label1Style = new Label.LabelStyle();
    BitmapFont myFont = new BitmapFont(Gdx.files.internal("fonts/gamebird.fnt"));
    label1Style.font = myFont;
    label1Style.fontColor = Color.BLACK;

    int totalDisplays = buttons.size();

    Set set = buttons.entrySet();
    Iterator iterator = set.iterator();

    //initialise the array list for the labels.
//    updatables = new ArrayList<Label>(totalDisplays);

    while (iterator.hasNext()) {
      //Get the current entry.
      Map.Entry mentry = (Map.Entry) iterator.next();
      Map str = (Map) mentry.getValue();

      //Initialise and obtain the image path, size and boolean visible
      String imgPath = (String) str.get("Image");
      ArrayList<Integer> sizesW = (ArrayList) str.get("Size");
      ArrayList<Integer> positionL = (ArrayList) str.get("Position");

      //Initialise the Local Image
      Image img = new Image(new Texture(imgPath));

      //Get and set the size of the given parameter
      Integer[] size;
      size = new Integer[2];
      size[0] = sizesW.get(0);
      size[1] = sizesW.get(1);

      //Get the position of the given parameter.
      Integer[] position;
      position = new Integer[2];
      position[0] = positionL.get(0) + xPosAdditionFactor;
      position[1] = positionL.get(1);

      //Set the size, position and visibility
      img.setSize(size[0],size[1]);
      img.setPosition(position[0], MyGame.HEIGHT - position[1]);

      //set the name of each component
      img.setName((String)mentry.getKey());

      //Add the parameter to the list of displayImages and stage
      buttonsList.add(img);
      stage.addActor(img);
    }
  }

  public void updateTextuals(int stepNumber, Map textuals){
    //initialise the array list for the labels.
    ArrayList<Label> textualObjects;
    switch (stepNumber)
    {
      case 0:
        textLabels = new ArrayList<Label>(textuals.size());
        textualObjects = textLabels;
        break;
      case 1:
        textLabelsNext = new ArrayList<Label>(textuals.size());
        textualObjects = textLabelsNext;
        break;
      case 2:
        textLabelsLast = new ArrayList<Label>(textuals.size());
        textualObjects = textLabelsLast;
        break;
      default:
        textLabels = new ArrayList<Label>(textuals.size());
        textualObjects = textLabels;
        break;
    }
    getUpdatable(textuals, textualObjects);
  }

  public String getChapterName(){
    String chapterName;

    if(GameStates.chapterNumber == CHAPTER_1) {
      chapterName = "Chapter1";
    }
    else if(GameStates.chapterNumber == CHAPTER_2){
      chapterName = "Chapter2";
    }
    else if(GameStates.chapterNumber == CHAPTER_3){
      chapterName = "Chapter3";
    }
    else if(GameStates.chapterNumber == CHAPTER_4){
      chapterName = "Chapter4";
    }
    else if(GameStates.chapterNumber == CHAPTER_5){
      chapterName = "Chapter5";
    }
    else if(GameStates.chapterNumber == CHAPTER_6){
      chapterName = "Chapter6";
    }
    else if(GameStates.chapterNumber == CHAPTER_7){
      chapterName = "Chapter7";
    }
    else if(GameStates.chapterNumber == CHAPTER_8){
      chapterName = "Chapter8";
    }
    else {
      chapterName = "Chapter1";
    }
    return chapterName;
  }

  public String getLevelName(){

    String levelName;
    switch (GameStates.levelNumber)
    {
      case LEVEL1:
        levelName = "Level1";
        currentLevelNumber = 0;
        break;
      case LEVEL2:
        levelName = "Level2";
        currentLevelNumber = 1;
        break;
      case LEVEL3:
        levelName = "Level3";
        currentLevelNumber = 2;
        break;
      case LEVEL4:
        levelName = "Level4";
        currentLevelNumber = 3;
        break;
      case LEVEL5:
        levelName = "Level5";
        currentLevelNumber = 4;
        break;
      case LEVEL6:
        levelName = "Level6";
        currentLevelNumber = 5;
        break;
      case LEVEL7:
        levelName = "Level7";
        currentLevelNumber = 6;
        break;
      case LEVEL8:
        levelName = "Level8";
        currentLevelNumber = 7;
        break;
      case LEVEL9:
        levelName = "Level9";
        currentLevelNumber = 8;
        break;
      case LEVEL10:
        levelName = "Level10";
        currentLevelNumber = 9;
        break;
      case LEVEL11:
        levelName = "Level11";
        currentLevelNumber = 10;
        break;
      case LEVEL12:
        levelName = "Level12";
        currentLevelNumber = 11;
        break;
      case LEVEL13:
        levelName = "Level13";
        currentLevelNumber = 12;
        break;
      case LEVEL14:
        levelName = "Level14";
        currentLevelNumber = 13;
        break;
      case LEVEL15:
        levelName = "Level15";
        currentLevelNumber = 14;
        break;

      default:
        levelName = "Level1";
        currentLevelNumber = 0;
        break;

    }
    return levelName;
  }

  protected void updateLabels(Map displayMap, ArrayList<Image> displayObjects){

    if(displayMap == null)
      return;

    int totalDisplays = displayMap.size();

    Set set = displayMap.entrySet();
    Iterator iterator = set.iterator();

    while (iterator.hasNext()) {
      //Get the current entry.
      Map.Entry mentry = (Map.Entry) iterator.next();
      Map str = (Map) mentry.getValue();

      //Initialise and obtain the image path, size and boolean visible
      String imgPath = (String) str.get("Image");
      ArrayList<Integer> sizesW = (ArrayList) str.get("Size");
      ArrayList<Integer> positionL = (ArrayList) str.get("Position");
      Boolean enableVis = (Boolean)  str.get("Visible");
      //Initialise the Local Image
      Image img = new Image(new Texture(imgPath));

      //Get and set the size of the given parameter
      Integer[] size;
      size = new Integer[2];
      size[0] = sizesW.get(0);
      size[1] = sizesW.get(1);

      //Get the position of the given parameter.
      Integer[] position;
      position = new Integer[2];
      position[0] = positionL.get(0) + xPosAdditionFactor;
      position[1] = positionL.get(1);

      //Set the size, position and visibility
      img.setSize(size[0],size[1]);
      img.setPosition(position[0], MyGame.HEIGHT - position[1]);
      img.setVisible(enableVis);

      //set the name of each component
      img.setName((String)mentry.getKey());

      //Add the parameter to the list of displayImages and stage
      displayObjects.add(img);
      stage.addActor(img);
    }
    for(Image pbar : displayObjects) {
//        pbar.addListener(clkPause);
    }
  }

  protected void updateDraggableArea(Map draggableMap, ArrayList draggable){

    if(draggableMap == null)
      return;
    int totalDraggables = draggableMap.size();

    Set set = draggableMap.entrySet();
    Iterator iterator = set.iterator();

    //initialise the array list for the labels.
//    draggable = new ArrayList<Image>(totalDraggables);

    draggableNames = new ArrayList<String>(totalDraggables);

    while (iterator.hasNext()) {
      //Get the current entry.
      Map.Entry mentry = (Map.Entry) iterator.next();
      Map str = (Map) mentry.getValue();

      //Total number of objects
      int totalObjects = 1;

      //Initialise and obtain the image path, size and boolean visible
      String imgPath = (String) str.get("Image");
      ArrayList<Integer> sizesW = (ArrayList) str.get("Size");
      ArrayList<Integer> positionL = (ArrayList) str.get("Position");
      Boolean enableTouch = (Boolean)  str.get("Touchable");
      if(str.containsKey("Total")){
        totalObjects = (Integer) str.get("Total");
      }

      //Get and set the size of the given parameter
      Integer[] size;
      size = new Integer[2];
      size[0] = sizesW.get(0);
      size[1] = sizesW.get(1);

      //Get the position of the given parameter.
      Integer[] position;
      position = new Integer[2];
      position[0] = positionL.get(0) + xPosAdditionFactor;
      position[1] = positionL.get(1);

      //Add the draglisteners' names
      draggableNames.add((String)str.get("DragListener"));

      //Set the size, position and visibility
      for(int totalObj = 0; totalObj < totalObjects; totalObj++) {
        //Initialise the Local Image
        Image img = new Image(new Texture(imgPath));
        img.setSize(size[0],size[1]);
        int xDiff = size[0] * totalObj;
        img.setPosition(position[0] + xDiff, MyGame.HEIGHT - position[1]);
        if(!enableTouch)
          img.setTouchable(Touchable.disabled);
        else
          img.setTouchable(Touchable.enabled);
        img.setName((String)mentry.getKey() + totalObj);

        //Add the parameter to the list of displayImages and stage
        draggable.add(img);
        stage.addActor(img);
      }
    }
  }

  protected void updateScrolling(Map scrollingData, ArrayList<Image> scrollableObject){

    if(scrollingData == null)
      return;

    scrollingData.size();

    Set set = scrollingData.entrySet();
    Iterator iterator = set.iterator();

    while (iterator.hasNext()) {
      //Get the current entry.
      Map.Entry mentry = (Map.Entry) iterator.next();
      Map str = (Map) mentry.getValue();

      //Initialise and obtain the image path, size and boolean visible
      String imgPath = (String) str.get("Image");
      ArrayList<Integer> sizesW = (ArrayList) str.get("Size");
      Boolean enableVis = (Boolean)  str.get("Visible");

      //Initialise the Local Image
      Image img = new Image(new Texture(imgPath));

      //Get and set the size of the given parameter
      Integer[] size;
      size = new Integer[2];
      size[0] = sizesW.get(0);
      size[1] = sizesW.get(1);

      //Set the size, position and visibility
      img.setSize(size[0], size[1]);
      img.setVisible(enableVis);

      img.setName((String) mentry.getKey());

      //Add the parameter to the list of displayImages and stage
      scrollableObject.add(img);
      stage.addActor(img);
    }
  }

  protected void getUpdatable(Map updatableInfo, ArrayList updatables){
    if(updatableInfo == null)
      return;

    Label.LabelStyle label1Style = new Label.LabelStyle();
    BitmapFont myFont = new BitmapFont(Gdx.files.internal("fonts/gamebird.fnt"));
    label1Style.font = myFont;
    label1Style.fontColor = Color.ROYAL;

    Label.LabelStyle labelStyle1 = new Label.LabelStyle();
    labelStyle1.font = myFont;
    labelStyle1.fontColor = Color.RED;

    Label.LabelStyle labelStyle2 = new Label.LabelStyle();
    labelStyle2.font = myFont;
    labelStyle2.fontColor = Color.WHITE;

    Label.LabelStyle labelStyle3 = new Label.LabelStyle();
    labelStyle3.font = myFont;
    labelStyle3.fontColor = Color.BLACK;

    int totalDisplays = updatableInfo.size();

    Set set = updatableInfo.entrySet();
    Iterator iterator = set.iterator();

    //initialise the array list for the labels.
//    updatables = new ArrayList<Label>(totalDisplays);

    while (iterator.hasNext()) {
      //Get the current entry.
      Map.Entry mentry = (Map.Entry) iterator.next();
      Map str = (Map) mentry.getValue();

      //Initialise and obtain the image path, size and boolean visible
      String imgPath = (String) str.get("Text");
      ArrayList<Integer> sizesW = (ArrayList) str.get("Size");
      ArrayList<Integer> positionL = (ArrayList) str.get("Position");
      String TextColor = (String) str.get("TextColor");

      //if colour declared
      if(str.containsKey("Color")){
        ArrayList<Integer> colorValues= (ArrayList) str.get("Color");
//        Gdx.app.log("ValueOfColour -------","" + colourValue.get(0));
        float r = (float)colorValues.get(0)/255;
        float g = (float)colorValues.get(1)/255;
        float b = (float)colorValues.get(2)/255;
        label1Style.fontColor = new Color(r,g, b, 1);
      }


      //Initialise the Local Image
      Label img = new Label(imgPath,label1Style);

      //Get and set the size of the given parameter
      Integer[] size;
      size = new Integer[2];
      size[0] = sizesW.get(0);
      size[1] = sizesW.get(1);

      //Get the position of the given parameter.
      Integer[] position;
      position = new Integer[2];
      position[0] = positionL.get(0) + xPosAdditionFactor;
      position[1] = positionL.get(1);

      //Set the size, position and visibility
      img.setSize(size[0],size[1]);
      img.setPosition(position[0], MyGame.HEIGHT - position[1]);

      //set the name of each component
      img.setName((String)mentry.getKey());

      //if colour is declared


      //Add the parameter to the list of displayImages and stage
      updatables.add(img);
      stage.addActor(img);
    }
  }

  ClickListener clkPause =  new ClickListener() {
    @Override
    public void clicked(InputEvent event, float x, float y) {
      Assets.playSound(Assets.clickSound);
      if (Settings.musicEnabled) Assets.music.stop();
      GameStates.screenStates = ScreenStates.DIALOGBOX;
      gblVar.clear();
    }
  };
}
