package teamkunle.co.uk.schoolapiandroid.ui.getallstudent;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import teamkunle.co.uk.schoolapiandroid.api.StudentAPI;
import teamkunle.co.uk.schoolapiandroid.rxschedulers.RxScheduler;

public class GetAllStudentFragmentPresenterImpl<V extends GetAllStudentContract.View> implements GetAllStudentContract.Presenter<V> {

    private V view;
    private StudentAPI studentAPI;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private RxScheduler schedulers;

    @Inject
    public GetAllStudentFragmentPresenterImpl(StudentAPI studentAPI, RxScheduler schedulers){
        this.studentAPI = studentAPI;
        this.schedulers = schedulers;
    }

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach() {
        this.view = null;
        compositeDisposable.clear();
    }

    @Override
    public void apiCallToGetStudents() {
        final Disposable studentAPIDisposable;

        studentAPIDisposable = studentAPI.getAllStudentsInfo()
                .subscribeOn(schedulers.computationScheduler())
                .observeOn(schedulers.uiScheduler())
                .subscribe(s -> getView().populateRecyclerView(s), t -> getView().errorAPICall(t));

        compositeDisposable.add(studentAPIDisposable);
    }

    private V getView() {
        return view;
    }
}
