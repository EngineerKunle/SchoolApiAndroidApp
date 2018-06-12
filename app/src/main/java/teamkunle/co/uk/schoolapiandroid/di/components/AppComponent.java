package teamkunle.co.uk.schoolapiandroid.di.components;

import dagger.Component;
import teamkunle.co.uk.schoolapiandroid.SchoolApplication;
import teamkunle.co.uk.schoolapiandroid.di.PerApplication;
import teamkunle.co.uk.schoolapiandroid.di.module.SchoolAppModule;
import teamkunle.co.uk.schoolapiandroid.di.module.TeacherModule;

@PerApplication
@Component(modules = SchoolAppModule.class)
public interface AppComponent {
    void inject(SchoolApplication app);

    TeacherComponent plus(TeacherModule module);
}
