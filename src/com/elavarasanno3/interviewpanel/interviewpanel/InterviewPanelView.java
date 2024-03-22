package com.elavarasanno3.interviewpanel.interviewpanel;

import com.elavarasanno3.interviewpanel.Interviewsetup.InterviewSetupView;
import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.login.LoginView;
import com.elavarasanno3.interviewpanel.model.Candidate;

import java.util.Scanner;

public class InterviewPanelView {
    private InterviewPanelModel interviewPanelModel;
    Scanner in = new Scanner(System.in);
    public InterviewPanelView (){
        interviewPanelModel = new InterviewPanelModel(this);
    }
    public void init(){
        Candidate candidate = InterviewDatabase.getInstance().getCandidate();
        System.out.println("\n--------->Hello this is Interview Panel<---------");
        System.out.println("\n-- Time to conduct an Interview --");
        System.out.println("\nThe candidate name is :" + candidate.getName());
        System.out.println("\nEmail id :" + candidate.getEmailId());
        System.out.println("\n\nQualification :" + candidate.getQualification());
        System.out.println("\nCan we start the exam : yes/no");
        System.out.println("\n\nif no then the candidate got rejected (Resume shortlist) ");
        System.out.println("\n--------->Any other key to exit<---------");
        String choice = in.next().toLowerCase();
        if(choice.equals("yes")){
            interviewPanelModel.startInterview(candidate);
        }else if(choice.equals("no")){
            init();
        }else{
            new InterviewSetupView().initialSetup();
        }
    }
}
