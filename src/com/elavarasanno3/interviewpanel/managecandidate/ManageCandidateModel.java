package com.elavarasanno3.interviewpanel.managecandidate;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Candidate;
import com.elavarasanno3.interviewpanel.model.Company;

import java.util.Scanner;

public class ManageCandidateModel {
    private ManageCandidateView manageCandidateView;
    ManageCandidateModel(ManageCandidateView manageCandidateView){
        this.manageCandidateView = manageCandidateView;
    }
    public void addNewCandidate(Candidate candidate){
        if(InterviewDatabase.getInstance().insertCandidate(candidate)){
            manageCandidateView.onCandidateAdded(candidate);
        }else{
            manageCandidateView.onCandidateExist(candidate);
        }
    }
    public boolean nameAndEmailVerification(String name,String gmail){
        if(nameVerification(name)){
            if(gmailVerification(gmail)){
                    return true;
            }else{
                manageCandidateView.alertMessage("\n$$ Alert : Enter valid name & gmail-$$\n");
                return false;
            }
        }else{
            manageCandidateView.alertMessage("\n$$ Alert : Enter valid name $$\n");
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
