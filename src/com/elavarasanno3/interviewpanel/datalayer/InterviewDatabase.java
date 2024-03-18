package com.elavarasanno3.interviewpanel.datalayer;

import com.elavarasanno3.interviewpanel.model.Candidate;
import com.elavarasanno3.interviewpanel.model.Company;
import com.elavarasanno3.interviewpanel.model.Interviewer;

import java.util.ArrayList;

public class InterviewDatabase {
    private static InterviewDatabase interviewDatabase;
    private Company company;
    private ArrayList <Candidate> candidateList = new ArrayList<>();
    private ArrayList <Interviewer> interviewersList = new ArrayList<>();

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
 }
