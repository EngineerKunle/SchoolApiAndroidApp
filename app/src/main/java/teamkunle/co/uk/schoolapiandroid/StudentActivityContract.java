package teamkunle.co.uk.schoolapiandroid;

import teamkunle.co.uk.schoolapiandroid.di.PerFragment;

public interface StudentActivityContract {

    interface View {
        void showDebugToast(); ////TODO : Delete Debug function
    }

    @PerFragment
    interface presenter<V extends View> {
        void attach(V view);
        void somethingPressed(); //TODO : Delete Debug function
        void detach();
    }

}
