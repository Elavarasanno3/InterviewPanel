package com.elavarasanno3.interviewpanel.login;

import com.elavarasanno3.interviewpanel.InterviewPanel2024;
import com.elavarasanno3.interviewpanel.Interviewsetup.InterviewSetupView;

import java.util.Scanner;

public class LoginView {
    Scanner in = new Scanner(System.in);
    private LoginModel loginModel;
    public LoginView(){
        loginModel = new LoginModel(this);
    }
    public void init(){
        System.out.println("--- " + InterviewPanel2024.getInstance().getAppName()+" ---\n ---version : "+
                InterviewPanel2024.getInstance().getAppVersion()+"---");
        System.out.println("\n--- Please login to proceed ---");
        proceedLogin();
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
    private void proceedLogin(){
        System.out.print("\nEnter the Admin name : ");
        String userName = in.next();
        System.out.print("\nEnter the password : ");
        String password = in.next();
        loginModel.validateUser(userName,password);
    }

    public void loginSuccess() {
        System.out.flush();
        System.out.println("\n\nLogin successfully ...\n\n Welcome to "+ InterviewPanel2024.getInstance().getAppName()+" - v "
        + InterviewPanel2024.getInstance().getAppVersion());
        InterviewSetupView interviewSetupView = new InterviewSetupView();
        interviewSetupView.init();
    }
}
