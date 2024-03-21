package com.elavarasanno3.interviewpanel.interviewpanel;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Candidate;

import java.util.Scanner;

public class InterviewPanelModel {
    Scanner in = new Scanner(System.in);
    private InterviewPanelView interviewPanelView;
    InterviewPanelModel (InterviewPanelView interviewPanelView){
        this.interviewPanelView = interviewPanelView;
    }


    public void startInterview(Candidate candidate) {
        System.out.println("Interview finished : ");
        int count = 4;
        int random =(int)((Math.random()*count))+1;
        switch (random){
            case 1 :
                System.out.println("------------Rejected in aptitude round.------------");
                break;
            case 2 :
                System.out.println("------------Rejected in basic programming round.------------");
                break;
            case 3 :
                System.out.println("------------Rejected in advanced programming round.------------");
                break;
            case 4 :
                System.out.println("Congrats You are selected");
        }
        System.out.println("\n\nDo you want to interview next candidate : YES OR NO ");
        String choice = in.next().toLowerCase();
        if(choice.equals("yes")) {
            interviewPanelView.init();
        }
    }
}
