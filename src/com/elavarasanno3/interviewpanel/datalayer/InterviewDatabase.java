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

    public ArrayList<Interviewer> getInterviewerList(){
        return interviewerList;
    }
    public void removeInterviewer(int id){
        System.out.println("Interviewer " + interviewerList.get(id).getName()+" removed Successfully");
        interviewerList.remove(id+1);
    }

    public ArrayList<Candidate> getCandidateList(){
        return candidateList;
    }
    public void removeCandidate(int id){
        System.out.println("Candidate " + candidateList.get(id).getName()+" removed Successfully");
        candidateList.remove(id+1);
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
