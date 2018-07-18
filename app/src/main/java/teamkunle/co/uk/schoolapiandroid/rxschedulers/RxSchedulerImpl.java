package teamkunle.co.uk.schoolapiandroid.rxschedulers;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulerImpl implements RxScheduler {
    @Inject
    public RxSchedulerImpl() {}

    @Override
    public Scheduler uiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler computationScheduler() {
        return Schedulers.io();
    }
}
