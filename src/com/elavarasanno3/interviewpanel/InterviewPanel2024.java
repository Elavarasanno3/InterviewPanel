package com.elavarasanno3.interviewpanel;
import com.elavarasanno3.interviewpanel.login.LoginView;

public class InterviewPanel2024 {

    private static InterviewPanel2024 interviewPanel;
    private String appName = "Interview Panel";
    private String appVersion = "0.0.1";
    private InterviewPanel2024(){

    }
    public static InterviewPanel2024 getInstance(){
        if(interviewPanel == null){
            interviewPanel = new InterviewPanel2024();
        }
        return interviewPanel;
    }

    private void create(){
        LoginView loginView = new LoginView();
        loginView.init();
    }
    public String getAppName(){
        return appName;
    }
    public String getAppVersion(){
        return appVersion;
    }


    public static void main(String[] args) {
        InterviewPanel2024.getInstance().create();
    }
}
