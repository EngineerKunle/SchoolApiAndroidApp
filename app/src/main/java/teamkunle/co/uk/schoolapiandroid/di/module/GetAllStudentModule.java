package teamkunle.co.uk.schoolapiandroid.di.module;

import dagger.Module;
import dagger.Provides;
import teamkunle.co.uk.schoolapiandroid.di.PerFragment;
import teamkunle.co.uk.schoolapiandroid.ui.getallstudent.GetAllStudentContract;
import teamkunle.co.uk.schoolapiandroid.ui.getallstudent.GetAllStudentFragmentPresenterImpl;

@Module
public class GetAllStudentModule {
    @Provides
    @PerFragment
    GetAllStudentContract.Presenter<GetAllStudentContract.View> providesPresenter
            (GetAllStudentFragmentPresenterImpl<GetAllStudentContract.View> presenter){
        return presenter;
    }
}
