package com.elavarasanno3.interviewpanel.Interviewsetup;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Company;

public class InterviewSetupModel {
    private InterviewSetupView interviewSetupView ;

    private Company company;
    public InterviewSetupModel(InterviewSetupView interviewSetupView){
        this.interviewSetupView = interviewSetupView;
        company = InterviewDatabase.getInstance().getCompany();
    }

    public void startSetUp() {
        if(company == null || company.getCompanyId() == 0){
            interviewSetupView.initialSetup();
        }
    }

    public void createCompany(Company company) {
        this.company = InterviewDatabase.getInstance().insertCompany(company);
        interviewSetupView.onSetupComplete(company);
    }

    public void validate(String companyName, String phoneNumber,String gmail,Company company) {
        if(isValidUserName(companyName)){
            if(isValidPhoneNumber(phoneNumber)){
                if(isValidGmail(gmail)){
                    interviewSetupView.onSuccess(company);
                }else{
                    interviewSetupView.onLoginField("Invalid gmail id (googleMail)");
                }
            }else{
                interviewSetupView.onLoginField("Invalid Phone number");
            }
        }else{
            interviewSetupView.onLoginField("Invalid Username");
        }
    }
    private boolean isValidGmail(String gmail){
        if(gmail.length() < 10)
            return false;
        if(gmail.charAt(gmail.length()-11) == '.')
            return false ;
        if(!(gmail.endsWith("@gmail.com")))
            return false;
        for(int i = 0;i<gmail.length()-10;i++){
            char c = gmail.charAt(i);
            if(!(Character.isAlphabetic(c) || c == '.'|| Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidUserName(String userName){
        return userName.length()>3 && userName.length() < 50;
    }

    private boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length() != 10){
            return false;
        }
        for(int i = 0;i<phoneNumber.length();i++){
            if(!Character.isDigit(phoneNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
