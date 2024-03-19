package com.elavarasanno3.interviewpanel.datalayer;

import com.elavarasanno3.interviewpanel.model.Candidate;
import com.elavarasanno3.interviewpanel.model.Company;
import com.elavarasanno3.interviewpanel.model.Interviewer;

import java.util.ArrayList;

public class InterviewDatabase {
    private static InterviewDatabase interviewDatabase;
    private Company company;

    private ArrayList <Candidate> candidateList = new ArrayList<>();
    private ArrayList <Interviewer> interviewerList = new ArrayList<>();

    public void setCompany(Company company) {
        this.company = company;
    }

    public void getInterviewerListDetails(){
        int  count = 1;
        for(Interviewer interviewer : interviewerList){

            System.out.println("Interviewer Details ::: \n_______________________________________");

            System.out.println( count++ +  " --   Interviewer name : " + interviewer.getName() + " . Email id : "+ interviewer.getEmailId()+"  -- ");
            System.out.println("\n");
        }
    }
    public void removeInterviewer(int id){
        System.out.println("Interviewer " + interviewerList.get(id).getName()+" removed Successfully");
        interviewerList.remove(id);
    }

    public void getCandidateListDetails(){
        int count = 1;
        for(Candidate candidate : candidateList){
            System.out.println("Candidate Details ::: \n_______________________________________");

            System.out.println( count++ +  " --  Candidate name : " + candidate.getName());
            System.out.println(" --  Candidate Qualification : "+ candidate.getQualification() );
            System.out.println(" --  Candidate Email Id : " + candidate.getEmailId());
            System.out.println("\n");
        }
    }
    public void removeCandidate(int id){
        System.out.println("Candidate " + candidateList.get(id).getName()+" removed Successfully");
        candidateList.remove(id);
    }

    public static InterviewDatabase getInstance(){
        if(interviewDatabase == null){
            interviewDatabase = new InterviewDatabase();
        }
        return interviewDatabase;
    }
    public Company getCompany(){
        return company;
    }

    public Company insertCompany(Company company2){
        this.company = company2;
        this.company.setCompanyId(1);
        return company;
    }
    public boolean insertCandidate(Candidate candidate) {
        boolean hasCandidate = false;
        for (Candidate addedCandidate : candidateList) {
            if (addedCandidate.getEmailId().equals(candidate.getEmailId())) {
                hasCandidate = true;
                break;
            }
        }
        if (hasCandidate) {
            return false;
        } else {
            candidateList.add(candidate);
            return true;
        }
    }
    public boolean insertInterviewer(Interviewer interviewer) {
        boolean hasInterviewer = false;
        for (Interviewer addedInterviewer : interviewerList) {
            if (addedInterviewer.getEmailId().equals(interviewer.getEmailId())) {
                hasInterviewer = true;
                break;
            }
        }
        if (hasInterviewer) {
            return false;
        } else {
            interviewerList.add(interviewer);
            return true;
        }
    }
 }
