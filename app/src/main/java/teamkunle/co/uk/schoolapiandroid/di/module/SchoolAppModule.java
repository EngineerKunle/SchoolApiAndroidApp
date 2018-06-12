package teamkunle.co.uk.schoolapiandroid.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import teamkunle.co.uk.schoolapiandroid.SchoolApplication;
import teamkunle.co.uk.schoolapiandroid.di.PerApplication;

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
}
