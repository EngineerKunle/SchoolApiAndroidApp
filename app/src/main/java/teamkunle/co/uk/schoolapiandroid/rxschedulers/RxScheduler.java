package teamkunle.co.uk.schoolapiandroid.rxschedulers;

import io.reactivex.Scheduler;

public interface RxScheduler {
    Scheduler uiScheduler();
    Scheduler computationScheduler();
}
