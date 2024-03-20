package com.elavarasanno3.interviewpanel.interviewerlogin;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class InterviewerLoginModel {
    private InterviewerLoginView interviewerLoginView;
    InterviewerLoginModel(InterviewerLoginView interviewerLoginView){
        this.interviewerLoginView = interviewerLoginView;
    }
    public void validateUser(String userName, String password) {
        if(isValidUserName(userName)){
            if(isValidPassword(password)){
                interviewerLoginView.loginSuccess();
            }else{
                interviewerLoginView.onLoginField("Invalid Password");
            }
        }else{
            interviewerLoginView.onLoginField("Invalid Username");
        }
    }
    private boolean isValidUserName(String userName)     {
        ArrayList <Interviewer> interviewerList =  InterviewDatabase.getInstance().getInterviewerList();
        for(Interviewer interviewer:interviewerList){
            if(interviewer.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    private boolean isValidPassword(String password) {
        ArrayList <Interviewer> interviewerList =  InterviewDatabase.getInstance().getInterviewerList();
        for(Interviewer interviewer:interviewerList){
            if(interviewer.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
