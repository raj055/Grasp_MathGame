package com.mygdx.game.Levels;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Factory.GameStates;
import com.mygdx.game.Global.GlobalsCommonCount;
import com.mygdx.game.Util.JSONUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.mygdx.game.Util.MathUtils.asFloat;

/**
 * Created by HP on 12-01-2018.
 */

public class ReadConfiguration {

    public static List layoutArray;

    static InputStream fin;
    static BufferedReader br;
    static StringBuilder buffer;
    static String line;

    public static void readLayoutArray() {
        try {
            switch (GameStates.chapterNumber){

                case CHAPTER_1:
                     fin = Gdx.files.internal("Info/chapter1.json").read();
                     br = new BufferedReader(new InputStreamReader(fin));

                     buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());
                    break;

                case CHAPTER_2:
                     fin = Gdx.files.internal("Info/chapter2.json").read();
                     br = new BufferedReader(new InputStreamReader(fin));

                     buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());
                    break;

                case CHAPTER_3:
                    fin = Gdx.files.internal("Info/chapter3.json").read();

                    br = new BufferedReader(new InputStreamReader(fin));

                    buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());

                    break;

                case CHAPTER_4:
                    fin = Gdx.files.internal("Info/chapter4.json").read();

                    br = new BufferedReader(new InputStreamReader(fin));

                    buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());

                    break;

                case CHAPTER_5:
                    fin = Gdx.files.internal("Info/chapter5.json").read();

                    br = new BufferedReader(new InputStreamReader(fin));

                    buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());

                    break;

                case CHAPTER_6:
                    fin = Gdx.files.internal("Info/chapter6.json").read();

                    br = new BufferedReader(new InputStreamReader(fin));

                    buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());

                    break;

                case CHAPTER_7:
                    fin = Gdx.files.internal("Info/chapter7.json").read();

                    br = new BufferedReader(new InputStreamReader(fin));

                    buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());

                    break;

                case CHAPTER_8:
                    fin = Gdx.files.internal("Info/chapter8.json").read();

                    br = new BufferedReader(new InputStreamReader(fin));

                    buffer = new StringBuilder();

                    while ((line = br.readLine()) != null) {
                        buffer.append(line);
                    }
                    fin.close();
                    layoutArray = JSONUtils.listFromJSONString(buffer.toString());

                    break;

                    default:
                        break;

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static ReadConfiguration layoutForLevel (int level) {
        try {
            if (layoutArray == null) readLayoutArray();
            Map layoutMap = (Map)layoutArray.get(level - 1);
            return new ReadConfiguration(layoutMap);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    static int numberOfLevels () {
        return layoutArray.size();
    }

    float width;
    float height;
    float targetTimeRatio;
    Map allParameters;
    public ReadConfiguration (Map layoutMap) {
        this.width = asFloat(layoutMap.get("width"), 20.0f);
        this.height = asFloat(layoutMap.get("height"), 30.0f);
        this.targetTimeRatio = asFloat(layoutMap.get("targetTimeRatio"));
        this.allParameters = layoutMap;
    }
}
