package teamkunle.co.uk.schoolapiandroid;

import teamkunle.co.uk.schoolapiandroid.di.PerFragment;

public interface StudentActivityContract {

    interface View {
        void startGetAllFragment(); 
    }

    @PerFragment
    interface Presenter<V extends View> {
        void attach(V view);
        void getAllStudentList();
        void detach();
    }
}
