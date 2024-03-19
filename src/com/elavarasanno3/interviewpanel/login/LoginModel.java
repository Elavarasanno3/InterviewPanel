package com.elavarasanno3.interviewpanel.login;

public class LoginModel {
    private LoginView loginView;
    LoginModel(LoginView loginView){
        this.loginView = loginView;
    }
    public void validateUser(String userName, String password) {
        if(isValidUserName(userName)){
            if(isValidPassword(userName,password)){
                loginView.loginSuccess();
            }else{
                loginView.onLoginField("Invalid Password");
            }
        }else{
            loginView.onLoginField("Invalid Username");
        }
    }

    private boolean isValidUserName(String userName) {
        return userName.equals("admin")||userName.equals("zsgsAdmin");
    }

    private boolean isValidPassword(String userName,String password) {
        return (userName.equals("admin")&&password.equals("123"))||(userName.equals("zsgsAdmin")&&password.equals("admin123"));
    }
}
