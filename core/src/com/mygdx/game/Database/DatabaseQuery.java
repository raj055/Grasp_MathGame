package com.mygdx.game.Database;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpParametersUtils;
import com.badlogic.gdx.utils.async.AsyncTask;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;


public class DatabaseQuery {

    private Map<String, String>  hashMap;
    private String url;

    private String finalResult;
    private HttpParse httpParse;
    private Context currentContext;

    private CallBackInterface resultReceiver;
    private CallType queryType;

    DataGetUrl dataGetUrl;

    String status;

    public void DatabaseQuery(Map<String, String> hashMapRef,
                              DataGetUrl urlQry,
                              CallType typeOfQuery,
                              CallBackInterface callBackExecutor){

        hashMap = new HashMap<String, String>();
        hashMap.putAll(hashMapRef);
        httpParse = new HttpParse();

        dataGetUrl = urlQry;

        //Get the required url.
        url = urlQry.getUrl(urlQry);
        Gdx.app.log("Url Enum----", urlQry.toString());
        Gdx.app.log("Url-----",url);

        //Assign the call back executor.
        resultReceiver = callBackExecutor;

        queryType = typeOfQuery;

    }

    public void PrepareForQuery(){
        switch (queryType){

            case POST_CALL:
                ExecuteDatabaseQuery();
                break;
            default:
                break;
        }
    }

    // Execute the DataBase Query
    public void ExecuteDatabaseQuery() {

        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
        httpPost.setContent(HttpParametersUtils.convertHttpParameters(hashMap));

        Gdx.net.sendHttpRequest (httpPost, new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                status = httpResponse.getResultAsString();

                Gdx.app.log("Received------",status);
            }

            public void failed(Throwable t) {
                status = "failed";
                Gdx.app.log("Received------","Failed");

            }

            @Override
            public void cancelled() {

                Gdx.app.log("Received------","Cancelled");
            }
        });
    }

    public void RegisterData(String name, String state, String email, String password, String conformPassword){

            Map parameters = new HashMap();
            parameters.put("name", name);
            parameters.put("state", state);
            parameters.put("email", email);
            parameters.put("password", password);
            parameters.put("conform_password", conformPassword);

            Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
            httpPost.setUrl("http://localhost/Grasp/RegisterStudent.php");
            httpPost.setContent(HttpParametersUtils.convertHttpParameters(parameters));

            Gdx.net.sendHttpRequest (httpPost, new Net.HttpResponseListener() {
                public void handleHttpResponse(Net.HttpResponse httpResponse) {
                    status = httpResponse.getResultAsString();

                    Gdx.app.log("Received------",status);
                }

                public void failed(Throwable t) {
                    status = "failed";
                    Gdx.app.log("Received------","Failed");

                }

                @Override
                public void cancelled() {

                    Gdx.app.log("Received------","Cancelled");
                }
            });
    }

    public void LoginData(String email, String password){

        Map parameters = new HashMap();
        parameters.put("email", email);
        parameters.put("password", password);

        Net.HttpRequest httpPost = new Net.HttpRequest(Net.HttpMethods.POST);
        httpPost.setUrl("http://localhost/Grasp/LoginStudent.php");
        httpPost.setContent(HttpParametersUtils.convertHttpParameters(parameters));

        Gdx.net.sendHttpRequest (httpPost, new Net.HttpResponseListener() {
            public void handleHttpResponse(Net.HttpResponse httpResponse) {
                status = httpResponse.getResultAsString();

                Gdx.app.log("Received------",status);
            }

            public void failed(Throwable t) {
                status = "failed";
                Gdx.app.log("Received------","Failed");

            }

            @Override
            public void cancelled() {

                Gdx.app.log("Received------","Cancelled");
            }
        });
    }

}
