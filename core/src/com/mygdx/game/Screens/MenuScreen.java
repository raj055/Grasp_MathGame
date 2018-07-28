package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.MyGame;

public class MenuScreen implements Screen {

    private Stage stage;

    private ScreenStates screenState;

    public MenuScreen(ScreenStates screenStates){

        stage = new Stage();

        this.screenState = screenStates;

        //Set the input processor as the current stage
        Gdx.input.setInputProcessor(stage);

        //Set the background image.
        Image background = new Image(new Texture("data/bg_1.png"));
        background.setSize(MyGame.WIDTH, MyGame.HEIGHT);
        stage.addActor(background);
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
