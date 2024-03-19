package com.elavarasanno3.interviewpanel.managecandidate;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Candidate;

import java.util.Scanner;

public class ManageCandidateView {
    private ManageCandidateModel manageCandidateModel;
    public ManageCandidateView(){
        manageCandidateModel = new ManageCandidateModel(this);
    }
    public void initAdd() {
        System.out.println("Enter the following candidate Details: ");
        Scanner scanner = new Scanner(System.in);
        Candidate candidate = new Candidate();
        System.out.println("\nEnter candidate name:");
        candidate.setName(scanner.nextLine());
        System.out.println("\nEnter candidate emailId:");
        candidate.setEmailId(scanner.next());
        System.out.println("\nEnter candidate Qualification:");
        candidate.setQualification(scanner.next());
        manageCandidateModel.addNewCandidate(candidate);
    }
    public void onCandidateAdded(Candidate candidate){
        System.out.println("\n------- Candidate '" + candidate.getName() + "' added successfully ------- \n");
        checkForAddNewCandidate();
    }
    public void onCandidateExist(Candidate candidate) {
        System.out.println("\n------- Candidate '" + candidate.getName() + "' already exist -------\n");
        checkForAddNewCandidate();
    }
    private void checkForAddNewCandidate() {
        System.out.println("Do you want to add more candidate? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toLowerCase();
        if (choice.equals("yes")) {
            initAdd();
        } else if (choice.equals("no")) {
            System.out.println("\n Thanks for adding users");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewCandidate();
        }
    }


}
