package teamkunle.co.uk.schoolapiandroid;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import teamkunle.co.uk.schoolapiandroid.di.components.AppComponent;
import teamkunle.co.uk.schoolapiandroid.di.components.DaggerAppComponent;
import teamkunle.co.uk.schoolapiandroid.di.module.SchoolAppModule;

public class SchoolApplication extends Application {

    private AppComponent component;

    @Inject
    Context context;

    private static SchoolApplication application;

    public static SchoolApplication getApp() {
        return application;
    }

    public SchoolApplication() {
        application = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent
                .builder()
                .schoolAppModule(new SchoolAppModule(this))
                .build();

        component.inject(this);
    }

    public AppComponent getComponent() {
        return component;
    }
}
