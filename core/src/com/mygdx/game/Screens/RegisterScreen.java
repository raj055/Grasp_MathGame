package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Database.DatabaseQuery;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;
import com.mygdx.game.Tools.Assets;

public class RegisterScreen implements Screen {

    private Stage stage;

    private Skin skin;

    private TextButton btnRegister;

    private TextField register_name,register_state,register_email,register_password,register_ConformPassword;

    private Label label_name,label_state,label_email,label_password,label_ConformPassword;

    private DatabaseQuery databaseQuery;

    public RegisterScreen(ScreenStates registerscreen) {

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        Assets.background.isVisible();

        stage.addActor(Assets.background);

        databaseQuery = new DatabaseQuery();

        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    @Override
    public void show() {

        btnRegister = new TextButton("Register",skin);
        btnRegister.setPosition(80,80);
        btnRegister.setSize(250,50);
        btnRegister.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                databaseQuery.RegisterData(register_name.getText(),register_state.getText(),register_email.getText(),
                                register_password.getText(),register_ConformPassword.getText());

                GameStates.screenStates = ScreenStates.LOGINSCREEN;
            }
        });
        stage.addActor(btnRegister);

        register_name = new TextField("",skin);
        register_name.setPosition(50, MyGame.HEIGHT - 180);
        register_name.setSize(300,40);
        stage.addActor(register_name);

        register_state = new TextField("",skin);
        register_state.setPosition(50,MyGame.HEIGHT - 270);
        register_state.setSize(300,40);
        stage.addActor(register_state);

        register_email = new TextField("",skin);
        register_email.setPosition(50,MyGame.HEIGHT - 360);
        register_email.setSize(300,40);
        stage.addActor(register_email);

        register_password = new TextField("",skin);
        register_password.setPosition(50,MyGame.HEIGHT - 440);
        register_password.setSize(300,40);
        stage.addActor(register_password);

        register_ConformPassword = new TextField("",skin);
        register_ConformPassword.setPosition(50,MyGame.HEIGHT - 530);
        register_ConformPassword.setSize(300,40);
        stage.addActor(register_ConformPassword);

        // Label Name
        label_name = new Label("Name :",skin);
        label_name.setPosition(50,MyGame.HEIGHT - 150);
        label_name.setSize(100,50);
        stage.addActor(label_name);

        label_state = new Label("State :",skin);
        label_state.setPosition(50,MyGame.HEIGHT - 240);
        label_state.setSize(100,50);
        stage.addActor(label_state);

        label_email = new Label("Email Id :",skin);
        label_email.setPosition(50,MyGame.HEIGHT - 330);
        label_email.setSize(100,50);
        stage.addActor(label_email);

        label_password = new Label("Password :",skin);
        label_password.setPosition(50,MyGame.HEIGHT - 410);
        label_password.setSize(100,50);
        stage.addActor(label_password);

        label_ConformPassword = new Label("Conform Password :",skin);
        label_ConformPassword.setPosition(50,MyGame.HEIGHT - 500);
        label_ConformPassword.setSize(100,50);
        stage.addActor(label_ConformPassword);
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
}
