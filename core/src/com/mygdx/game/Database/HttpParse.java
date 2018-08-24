package com.mygdx.game.Database;

import com.badlogic.gdx.Gdx;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Grasp
 * @version 1.0 on 28-06-2018.
 * @class_name HttpParse
 * @description this class set request in has map to link database to class variable
 */

public class HttpParse {

    String FinalHttpData = "";
    String Result = new String();
    String line = null;
    BufferedWriter bufferedWriter ;
    OutputStream outputStream ;
    BufferedReader bufferedReader ;
    StringBuilder stringBuilder = new StringBuilder();
    URL url;

    public String postRequest(HashMap<String, String> Data, String HttpUrlHolder) {

        try {
            url = new URL(HttpUrlHolder);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setReadTimeout(14000);

            httpURLConnection.setConnectTimeout(14000);

            httpURLConnection.setRequestMethod("POST");


            httpURLConnection.setDoInput(true);

            httpURLConnection.setDoOutput(true);

            outputStream = httpURLConnection.getOutputStream();

            bufferedWriter = new BufferedWriter(

                    new OutputStreamWriter(outputStream, "UTF-8"));

            bufferedWriter.write(FinalDataParse(Data));

            bufferedWriter.flush();

            bufferedWriter.close();

            outputStream.close();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                BufferedInputStream is = new BufferedInputStream(httpURLConnection.getInputStream());
                bufferedReader = new BufferedReader(
                  new InputStreamReader(is)
                );
                StringBuilder sb = new StringBuilder();
                boolean count = false;
                while( (line = bufferedReader.readLine()) != null)
                {
                    //add the '/n' on every next line- not the first line.
                    if (count) sb.append("/n");
                    count = true;
                    sb.append(line);

                }
                Gdx.app.log("d",FinalHttpData);
                FinalHttpData = sb.toString();
                Gdx.app.log("After",FinalHttpData);

            }
            else {
                FinalHttpData = "Something Went Wrong";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return FinalHttpData;
    }

    public String FinalDataParse(HashMap<String,String> hashMap2) throws UnsupportedEncodingException {

        for(Map.Entry<String,String> map_entry : hashMap2.entrySet()){

            stringBuilder.append("&");

            stringBuilder.append(URLEncoder.encode(map_entry.getKey(), "UTF-8"));

            stringBuilder.append("=");

            stringBuilder.append(URLEncoder.encode(map_entry .getValue(), "UTF-8"));
        }

        Result = stringBuilder.toString();

        Gdx.app.log("Rslt-------", Result);

        return Result ;
    }
}