package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.async.AsyncTask;;
import com.mygdx.game.Enum.ScreenStates;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.MyGame;

import java.util.HashMap;

public class LoginScreen implements Screen {

    private Stage stage;

    private ScreenStates screenState;

    private BitmapFont font;

    private Label.LabelStyle style;

    private TextButton btnLogin;
    private TextField textEmail;
    private TextField textPassword;

    private Label email;
    private Label password;

    String EmailHolder = "";
    String PasswordHolder = "";

    Boolean CheckEditText;

    String HttpURL = "http://10.0.2.2/Grasp/StudentLogin.php";

    public static final String UserEmail = "";

    public LoginScreen(ScreenStates loginscreen) {
        stage = new Stage();

        this.screenState = loginscreen;

        //Set the input processor as the current stage
        Gdx.input.setInputProcessor(stage);

        //Set the background image.
        Image background = new Image(new Texture("data/bg_1.png"));
        background.setSize(MyGame.WIDTH, MyGame.HEIGHT);
        stage.addActor(background);

        font = new BitmapFont(Gdx.files.internal("fonts/foo.fnt"));

        Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.BLACK);

        style = new Label.LabelStyle();
        style.font = font;
    }

    @Override
    public void show() {

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        btnLogin = new TextButton("Login", skin);
        btnLogin.setColor(Color.BLUE);
        btnLogin.setPosition(80,200);
        btnLogin.setSize(250,50);
        btnLogin.addListener(new ClickListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                btnClickLogin();

                GameStates.screenStates = ScreenStates.MENUSCREEN;
            }
        });

        email = new Label("Email_ID",style);
        email.setFontScale(1.0f);
        email.setPosition(50,MyGame.HEIGHT - 150);
        email.setColor(Color.VIOLET);

        textEmail = new TextField("", skin);
        textEmail.setPosition(50,500);
        textEmail.setSize(300,40);
        textEmail.setColor(Color.WHITE);

        password = new Label("Password",style);
        password.setFontScale(1.0f);
        password.setPosition(50,MyGame.HEIGHT - 300);
        password.setColor(Color.VIOLET);

        textPassword = new TextField("", skin);
        textPassword.setPosition(50,350);
        textPassword.setSize(300,40);
        textPassword.setColor(Color.WHITE);


        stage.addActor(password);
        stage.addActor(email);
        stage.addActor(textEmail);
        stage.addActor(textPassword);
        stage.addActor(btnLogin);

    }

    private void btnClickLogin() {

        EmailHolder = email.getText().toString();
        PasswordHolder = password.getText().toString();

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
