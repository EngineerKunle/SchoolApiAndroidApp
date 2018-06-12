package teamkunle.co.uk.schoolapiandroid.di.components;

import dagger.Subcomponent;
import teamkunle.co.uk.schoolapiandroid.TeacherFragment;
import teamkunle.co.uk.schoolapiandroid.di.PerFragment;
import teamkunle.co.uk.schoolapiandroid.di.module.TeacherModule;

@PerFragment
@Subcomponent(modules = TeacherModule.class)
public interface TeacherComponent {
    void inject(TeacherFragment f);
}
