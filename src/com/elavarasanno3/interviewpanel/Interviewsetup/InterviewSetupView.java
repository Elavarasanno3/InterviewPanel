package com.elavarasanno3.interviewpanel.Interviewsetup;

import com.elavarasanno3.interviewpanel.InterviewPanel2024;
import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.login.LoginView;
import com.elavarasanno3.interviewpanel.managecandidate.ManageCandidateView;
import com.elavarasanno3.interviewpanel.manageinterviewer.ManageInterviewerView;
import com.elavarasanno3.interviewpanel.model.Company;

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
        System.out.println("Enter company details ");
        Scanner in = new Scanner(System.in);
        Company company = new Company();
        System.out.println("\nEnter company name :");
        company.setCompanyName(in.nextLine());
        System.out.println("\nEnter company email :");
        company.setEmailId(in.nextLine());
        interviewSetupModel.createCompany(company);
    }

    public void onSetupComplete(Company company){
        System.out.println("\nCompany setup completed\n");
        System.out.println("\n\n ____________________________________________\n\n");
        System.out.println("\nCurrent Company Name - " + company.getCompanyName());
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("\n 1.Add Interviewer\n 2.Add Candidate\n 3.Get Interviewer Details\n 4.Get Candidate Details\n 5.Remove Interviewer \n 6.Remove Candidate \n 9.logout \n 0.Exit\n Enter your choice :");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    new ManageInterviewerView().initAdd();
                    break;
                case 2:
                    new ManageCandidateView().initAdd();
                    break;
                case 3:
                    InterviewDatabase.getInstance().getInterviewerListDetails();
                    break;
                case 4:
                    InterviewDatabase.getInstance().getCandidateListDetails();
                    break;
                case 5:
                    System.out.println("Enter the interviewer Id to delete");
                    int interviewerId = in.nextInt();
                    InterviewDatabase.getInstance().removeInterviewer(interviewerId);
                    break;
                case 6:
                    System.out.println("Enter the candidate Id  to delete");
                    int candidateId = in.nextInt();
                    InterviewDatabase.getInstance().removeCandidate(candidateId);
                    break;
                case 9:
                    System.out.println("\n-- You are logged out successfully -- \n\n");
                    new LoginView().init();
                    return; // Exit from the current session
                case 0:
                    System.out.println("\n-- Thanks for using " + InterviewPanel2024.getInstance().getAppName() + " --");
                    return; // Exit from the application
                default:
                    System.out.println("\nPlease Enter valid choice\n");
            }
        }
    }
}
