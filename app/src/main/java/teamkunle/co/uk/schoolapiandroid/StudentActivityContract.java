package teamkunle.co.uk.schoolapiandroid;

import teamkunle.co.uk.schoolapiandroid.di.PerFragment;

public interface StudentActivityContract {

    interface View {
        void startGetAllFragment(); 
    }

    @PerFragment
    interface presenter<V extends View> {
        void attach(V view);
        void somethingPressed();
        void detach();
    }

}
