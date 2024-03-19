package com.elavarasanno3.interviewpanel.manageinterviewer;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Candidate;
import com.elavarasanno3.interviewpanel.model.Interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageInterviewerView {
    private ManageInterviewerModel manageInterviewerModel;
    public ManageInterviewerView(){
        manageInterviewerModel = new ManageInterviewerModel(this);
    }
    public void initAdd() {
        System.out.println("Enter the following Interviewer Details: ");
        Scanner scanner = new Scanner(System.in);
        Interviewer interviewer = new Interviewer();
        System.out.println("\nEnter Interviewer name:");
        interviewer.setName(scanner.nextLine());
        System.out.println("\nEnter Interviewer emailId:");
        interviewer.setEmailId(scanner.next());
        System.out.println("\nEnter new password:");
        interviewer.setPassword(scanner.next());
        manageInterviewerModel.addNewInterviewer(interviewer);
    }
    public void onInterviewerAdded(Interviewer interviewer){
        System.out.println("\n------- Interviewer'" + interviewer.getName() + "' added successfully ------- \n");
        checkForAddNewInterviewer();
    }
    public void onInterviewerExist(Interviewer interviewer) {
        System.out.println("\n------- Interviewer '" + interviewer.getName() + "' already exist -------\n");
        checkForAddNewInterviewer();
    }
    private void checkForAddNewInterviewer() {
        System.out.println("Do you want to add more Interviewer? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toLowerCase();
        if (choice.equals("yes")) {
            initAdd();
        } else if (choice.equals("no")) {
            System.out.println("\n Thanks for adding users");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewInterviewer();
        }
    }
}
