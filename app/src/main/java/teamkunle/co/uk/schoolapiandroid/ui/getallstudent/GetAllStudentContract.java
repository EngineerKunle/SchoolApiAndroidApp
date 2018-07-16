package teamkunle.co.uk.schoolapiandroid.ui.getallstudent;

import java.util.List;

import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;

public interface GetAllStudentContract {

    interface View {
        void populateRecyclerView(List<StudentModel> model);
        void errorAPICall(Throwable t);
    }

    interface Presenter<V extends View> {
        void attach(V view);
        void detach();
        void apiCallToGetStudents();
    }
}
