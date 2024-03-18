package com.elavarasanno3.interviewpanel.manageinterviewer;
import com.elavarasanno3.interviewpanel.datalayer.InterviewDatabase;
import com.elavarasanno3.interviewpanel.model.Interviewer;

public class ManageInterviewerModel {
    private ManageInterviewerView manageInterviewerView;
    ManageInterviewerModel(ManageInterviewerView manageInterviewerView){
        this.manageInterviewerView = manageInterviewerView;
    }
    public void addNewInterviewer(Interviewer interviewer){
        if(InterviewDatabase.getInstance().insertInterviewer(interviewer)){
            manageInterviewerView.onInterviewerAdded(interviewer);
        }else{
            manageInterviewerView.onInterviewerExist(interviewer);
        }
    }



}
