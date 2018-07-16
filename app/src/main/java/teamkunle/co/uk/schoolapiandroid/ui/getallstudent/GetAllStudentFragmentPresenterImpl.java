package teamkunle.co.uk.schoolapiandroid.ui.getallstudent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import teamkunle.co.uk.schoolapiandroid.api.StudentAPI;

public class GetAllStudentFragmentPresenterImpl<V extends GetAllStudentContract.View> implements GetAllStudentContract.Presenter<V> {

    private V view;
    private StudentAPI studentAPI;

    @Inject
    public GetAllStudentFragmentPresenterImpl(StudentAPI studentAPI){
        this.studentAPI = studentAPI;
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void apiCallToGetStudents() {
        studentAPI.getAllStudentsInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getView().populateRecyclerView(s), t -> getView().errorAPICall(t));
    }

    private V getView() {
        return view;
    }
}

/**
 *
 * public class StudentActivityPresenterImpl<V extends StudentActivityContract.View>
 implements StudentActivityContract.Presenter<V>
 * */