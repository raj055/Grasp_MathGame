package com.mygdx.game.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Database.CallBackInterface;
import com.mygdx.game.Database.CallType;
import com.mygdx.game.Database.DataGetUrl;
import com.mygdx.game.Database.DatabaseQuery;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Tools.Assets;

import java.util.HashMap;
import java.util.Map;

public class LoginScreen implements Screen,CallBackInterface {

    private Stage stage;

    private Skin skin;

    private TextButton btnLogin,btnNewRegister;
    private TextField email;
    private TextField password;
    private Label label_email;
    private Label label_password;

    private DatabaseQuery databaseQuery;

    Map<String,String> hashMap = new HashMap<String, String>();
    DataGetUrl urlQry;
    CallType typeOfQuery;

    public LoginScreen(ScreenStates loginscreen) {

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        Assets.background.isVisible();

        stage.addActor(Assets.background);

        databaseQuery = new DatabaseQuery();

        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    @Override
    public void show() {

        btnLogin = new TextButton("Login",skin);
        btnLogin.setPosition(100,200);
        btnLogin.setSize(200,50);
        btnLogin.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                databaseQuery.LoginData(email.getText(),password.getText());

               /* urlQry = DataGetUrl.student_LOGIN;
                typeOfQuery = CallType.POST_CALL;

                hashMap.put("email_id",email.getText());

                hashMap.put("password",password.getText());

                //Send Database query for inquiring to the database.
                databaseQuery = new DatabaseQuery(hashMap,
                        urlQry,
                        typeOfQuery,
                        LoginScreen.this
                );
                //Prepare for the database query
                databaseQuery.PrepareForQuery();*/

                GameStates.screenStates = ScreenStates.MENUSCREEN;
            }
        });
        stage.addActor(btnLogin);

        btnNewRegister = new TextButton("New Student/Teacher Register",skin);
        btnNewRegister.setPosition(20,50);
        btnNewRegister.setSize(250,30);
        btnNewRegister.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                GameStates.screenStates = ScreenStates.REGISTERSCREEN;
            }
        });
        stage.addActor(btnNewRegister);

        email = new TextField("",skin);
        email.setPosition(50,500);
        email.setSize(300,50);
        stage.addActor(email);

        password = new TextField("",skin);
        password.setPosition(50,350);
        password.setSize(300,50);
        stage.addActor(password);

        label_email = new Label("Email Id :",skin);
        label_email.setPosition(50,550);
        label_email.setSize(100,50);
        stage.addActor(label_email);

        label_password = new Label("Password :",skin);
        label_password.setPosition(50,400);
        label_password.setSize(100,50);
        stage.addActor(label_password);
    }

    @Override
    public void render(float delta) {
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

    @Override
    public void ExecuteQueryResult(String response, DataGetUrl dataGetUrl) {

    }
}
