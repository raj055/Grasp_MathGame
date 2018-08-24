package com.mygdx.game.Database;

public enum DataGetUrl {

    student_LOGIN,
    student_REGISTER;

    private String[] urls = {

            "http://localhost/Grasp/LoginStudent.php",                 // student_LOGIN
            "http://localhost/Grasp/RegisterStudent.php",          //student_REGISTER
    };

    public String getUrl(DataGetUrl getUrl){

        //Get the relevant Url for the Data.
        if(getUrl != null) {
            return urls[getUrl.ordinal()];
        }
        else {
            return null;
        }

    }
}
