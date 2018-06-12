package teamkunle.co.uk.schoolapiandroid;

import javax.inject.Inject;

public class StudentActivityPresenterImpl<V extends StudentActivityContract.View>
        implements StudentActivityContract.presenter<V> {

    private V view;

    @Inject
    public StudentActivityPresenterImpl() {
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    private V getView() {
        return view;
    }

    @Override
    public void somethingPressed() {
        getView().showDebugToast();
    }
}
