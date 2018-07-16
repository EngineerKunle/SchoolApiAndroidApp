package teamkunle.co.uk.schoolapiandroid.di.components;

import dagger.Subcomponent;
import teamkunle.co.uk.schoolapiandroid.di.PerFragment;
import teamkunle.co.uk.schoolapiandroid.di.module.GetAllStudentModule;
import teamkunle.co.uk.schoolapiandroid.ui.getallstudent.GetAllStudentFragment;

@PerFragment
@Subcomponent(modules = GetAllStudentModule.class)
public interface GetAllStudentComponent {
    void inject(GetAllStudentFragment f);
}
