package com.elavarasanno3.interviewpanel.Interviewsetup;

import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Company;

public class InterviewSetupModel {
    private InterviewSetupView interviewSetupView ;

    private Company company;
    public InterviewSetupModel(InterviewSetupView interviewSetupView){
        this.interviewSetupView = interviewSetupView;
        company = InterviewDatabase.getInstance().getCompany();
    }

    public void startSetUp() {
        if(company == null || company.getCompanyId() == 0){
            interviewSetupView.initialSetup();
        }
    }

    public void createCompany(Company company) {
        if (company.getCompanyName().length() <3  || company.getCompanyName().length() > 50) {
            interviewSetupView.showAlert("Enter valid name");
            return;
        }
        this.company = InterviewDatabase.getInstance().insertCompany(company);
        interviewSetupView.onSetupComplete(company);
    }

}
