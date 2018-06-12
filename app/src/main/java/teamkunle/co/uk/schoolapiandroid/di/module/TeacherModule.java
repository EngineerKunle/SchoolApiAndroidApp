package teamkunle.co.uk.schoolapiandroid.di.module;

import dagger.Module;
import dagger.Provides;
import teamkunle.co.uk.schoolapiandroid.StudentActivityContract;
import teamkunle.co.uk.schoolapiandroid.StudentActivityPresenterImpl;
import teamkunle.co.uk.schoolapiandroid.di.PerFragment;

@Module
public class TeacherModule {

    @Provides
    @PerFragment
    StudentActivityContract.presenter<StudentActivityContract.View> provideStudentPresenter
            (StudentActivityPresenterImpl<StudentActivityContract.View> presenter){
        return presenter;
    }
}
