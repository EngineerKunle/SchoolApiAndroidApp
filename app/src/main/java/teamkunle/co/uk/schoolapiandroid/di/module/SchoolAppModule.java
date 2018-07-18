package teamkunle.co.uk.schoolapiandroid.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import teamkunle.co.uk.schoolapiandroid.SchoolApplication;
import teamkunle.co.uk.schoolapiandroid.api.StudentAPI;
import teamkunle.co.uk.schoolapiandroid.api.StudentAPIImpl;
import teamkunle.co.uk.schoolapiandroid.di.PerApplication;
import teamkunle.co.uk.schoolapiandroid.rxschedulers.RxScheduler;
import teamkunle.co.uk.schoolapiandroid.rxschedulers.RxSchedulerImpl;

@Module
public class SchoolAppModule {
    private final SchoolApplication application;

    public SchoolAppModule(SchoolApplication application) {
        this.application = application;
    }

    @Provides
    @PerApplication
    Context provideAppContext() {
        return application;
    }

    @Provides
    @PerApplication
    SchoolApplication provideApp() {
        return application;
    }

    @Provides
    @PerApplication
    StudentAPI provideStudentAPi(StudentAPIImpl api){return api;}

    @Provides
    @PerApplication
    RxScheduler providesRxScheduler(RxSchedulerImpl rxScheduler){return rxScheduler;}
}
