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



}
