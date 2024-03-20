package com.elavarasanno3.interviewpanel.manageinterviewer;
import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Interviewer;

public class ManageInterviewerModel {
    private ManageInterviewerView manageInterviewerView;
    ManageInterviewerModel(ManageInterviewerView manageInterviewerView){
        this.manageInterviewerView = manageInterviewerView;
    }
    public void addNewInterviewer(Interviewer interviewer){
        if(InterviewDatabase.getInstance().insertInterviewer(interviewer)){
            manageInterviewerView.onInterviewerAdded(interviewer);
        }else{
            manageInterviewerView.onInterviewerExist(interviewer);
        }
    }
    public boolean nameAndEmailVerification(String name,String gmail){
        if(nameVerification(name)){
            if(gmailVerification(gmail)){
                return true;
            }else{
                manageInterviewerView.alertMessage("\n$$ Alert : Enter valid name & gmail-$$\n");
                return false;
            }
        }else{
            manageInterviewerView.alertMessage("\n$$ Alert : Enter valid name $$\n");
            return false;
        }

    }
    public boolean nameVerification(String name){
        return name.length() >= 3 && name.length() <= 50;
    }
    public boolean gmailVerification(String gmail){
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



}
