package com.elavarasanno3.interviewpanel.managecandidate;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Candidate;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageCandidateView {
    private ManageCandidateModel manageCandidateModel;
    public ManageCandidateView(){
        manageCandidateModel = new ManageCandidateModel(this);
    }
    public void initAdd() {
        System.out.println("-------------------------------------------------------------------\n\n");
        System.out.println("\n-------------->Candidate portal<-------------");
        System.out.print("\nEnter the following candidate Details : ");
        Scanner scanner = new Scanner(System.in);
        Candidate candidate = new Candidate();
        System.out.print("\nEnter candidate name : ");
        String name = scanner.next();
        candidate.setName(name);
        System.out.print("\nEnter candidate gmailId(google mail) : ");
        String gmail = scanner.next();
        candidate.setEmailId(gmail);
        System.out.print("\nEnter candidate Qualification : ");
        candidate.setQualification(scanner.next());
        if(manageCandidateModel.nameAndEmailVerification(name,gmail)){
            manageCandidateModel.addNewCandidate(candidate);
        }else{
            initAdd();
        }

    }
    public void alertMessage(String text){
        System.out.println(text);
        System.out.println("---------------------------------------------------");
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
