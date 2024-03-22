package com.elavarasanno3.interviewpanel.Interviewsetup;

import com.elavarasanno3.interviewpanel.InterviewPanel2024;
import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.interviewerlogin.InterviewerLoginView;
import com.elavarasanno3.interviewpanel.login.LoginView;
import com.elavarasanno3.interviewpanel.managecandidate.ManageCandidateView;
import com.elavarasanno3.interviewpanel.manageinterviewer.ManageInterviewerView;
import com.elavarasanno3.interviewpanel.model.Candidate;
import com.elavarasanno3.interviewpanel.model.Company;
import com.elavarasanno3.interviewpanel.model.Interviewer;

import java.util.ArrayList;
import java.util.Scanner;


public class InterviewSetupView {
    private InterviewSetupModel interviewSetupModel;
    public InterviewSetupView(){
        interviewSetupModel = new InterviewSetupModel(this);
    }
    public void init(){
        interviewSetupModel.startSetUp();
    }
    public void showAlert(String alert){
        System.out.println(alert);
        initialSetup();
    }

    public void initialSetup() {
        System.out.println("-------------Enter company details---------- ");
        Scanner in = new Scanner(System.in);
        Company company = new Company();
        System.out.print("\nEnter company name :");
        String name = in.nextLine();
        System.out.print("\nCompany Phone number :");
        String phoneNumber = in.nextLine();
        System.out.print("\nCompany gmail id : ");
        String gmail = in.nextLine();
        interviewSetupModel.validate(name,phoneNumber,gmail,company);

    }
    public void onSuccess(Company company){
        System.out.println("--Successfully created ");
        interviewSetupModel.createCompany(company);
    }

    public void getCandidateListDetails(){
        ArrayList<Candidate> candidateList = InterviewDatabase.getInstance().getCandidateList();
        int count = 1;
        System.out.println("Candidate Details ::: \n_______________________________________");
        for(Candidate candidate : candidateList){
            System.out.print("\n" + count++ +  " --  Candidate name : " + candidate.getName());
            System.out.print("\n --  Candidate Qualification : "+ candidate.getQualification() );
            System.out.print("\n --  Candidate Email Id : " + candidate.getEmailId());
            System.out.print("\n");
        }
    }
    public void getInterviewerListDetails(){
        ArrayList<Interviewer> interviewerList = InterviewDatabase.getInstance().getInterviewerList();
        int  count = 1;
        System.out.println("Interviewer Details ::: \n_______________________________________");
        for(Interviewer interviewer : interviewerList){
            System.out.println( count++ +  " --   Interviewer name : " + interviewer.getName() + "--" + "\n -- Email id : "+ interviewer.getEmailId()+"  -- ");
            System.out.println("\n");
        }
    }

    public void onSetupComplete(Company company){
        System.out.println("\nCompany setup completed\n");
        System.out.println("\n\n ____________________________________________\n\n");
        System.out.println("\nCurrent Company Name - " + company.getCompanyName());
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("\n 1.Add Interviewer\n 2.Add Candidate\n 3.Get Interviewer Details\n" +
                    " 4.Get Candidate Details\n 5.Remove Interviewer \n 6.Remove Candidate \n 7.Interviewer Login \n" +
                    " 9.logout \n 0.Exit\n Enter your choice :");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    new ManageInterviewerView().initAdd();
                    break;
                case 2:
                    new ManageCandidateView().initAdd();
                    break;
                case 3:
                    getInterviewerListDetails();
                    break;
                case 4:
                    getCandidateListDetails();
                    break;
                case 5:
                    getInterviewerListDetails();
                    System.out.print("Enter the interviewer Id to delete : ");
                    int interviewerId = in.nextInt();
                    InterviewDatabase.getInstance().removeInterviewer(interviewerId);
                    break;
                case 6:
                    getCandidateListDetails();
                    System.out.print("Enter the candidate Id  to delete : ");
                    int candidateId = in.nextInt();
                    InterviewDatabase.getInstance().removeCandidate(candidateId);
                    break;
                case 7:
                    new InterviewerLoginView().proceedLogin();
                    break;
                case 9:
                    System.out.println("\n-- You are logged out successfully --");
                    new LoginView().init();
                    break;
                case 0:
                    System.out.println("\n-- Thanks for using " + InterviewPanel2024.getInstance().getAppName() + " --");
                    break;
                default:
                    System.out.println("\nPlease Enter valid choice");
            }
        }
    }

    public void onLoginField(String text) {
        System.out.print("\n----"+text+"----");
        System.out.print("\n--------------------------------------------------");
        initialSetup();
    }
}
