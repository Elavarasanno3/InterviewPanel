package com.elavarasanno3.interviewpanel.interviewerlogin;

import com.elavarasanno3.interviewpanel.InterviewPanel2024;
import com.elavarasanno3.interviewpanel.Interviewsetup.InterviewSetupView;

import java.util.Scanner;

public class InterviewerLoginView {
    Scanner in = new Scanner(System.in);
    private InterviewerLoginModel interviewerLoginModel;
    public InterviewerLoginView(){
        interviewerLoginModel = new InterviewerLoginModel(this);
    }
    public void proceedLogin(){
        System.out.println("---Hii !! This is interviewer's panel.");
        System.out.print("Enter your name :");
        String interviewerName = in.next();
        System.out.print("Enter your password to login : ");
        String interviewerPassword = in.next();
        interviewerLoginModel.validateUser(interviewerName,interviewerPassword);
    }
    public void onLoginField(String alertMessage){
        System.out.println(alertMessage);
        checkForLogin();
    }
    private void checkForLogin(){
        System.out.println("Do you want to try again ?\nType YES or NO");
        String choice = in.next().toLowerCase();
        if(choice.equals("yes")){
            proceedLogin();
        }else if(choice.equals("no")) {
            System.out.println("---- Thanks you ----");
        }else{
            System.out.println("Invalid Choice Enter \n Enter a valid choice");
            checkForLogin();
        }
    }

    public void loginSuccess() {
        System.out.println("Interviewer login successful");
        System.out.println("Start the interview");
    }

}
