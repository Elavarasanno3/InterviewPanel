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
        System.out.println("Enter the following candidate Details: ");
        Scanner scanner = new Scanner(System.in);
        Candidate candidate = new Candidate();
        System.out.println("\nEnter candidate name:");
        String name = scanner.next();
        candidate.setName(name);
        System.out.println("\nEnter candidate gmailId(google mail):");
        String gmail = scanner.next();
        candidate.setEmailId(gmail);
        System.out.println("\nEnter candidate Qualification:");
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

    public static void getCandidateListDetails(){
        ArrayList<Candidate> candidateList = InterviewDatabase.getInstance().getCandidateList();
        int count = 1;
        for(Candidate candidate : candidateList){
            System.out.println("Candidate Details ::: \n_______________________________________");

            System.out.println( count++ +  " --  Candidate name : " + candidate.getName());
            System.out.println(" --  Candidate Qualification : "+ candidate.getQualification() );
            System.out.println(" --  Candidate Email Id : " + candidate.getEmailId());
            System.out.println("\n");
        }
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
