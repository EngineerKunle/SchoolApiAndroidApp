package teamkunle.co.uk.schoolapiandroid.api;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import teamkunle.co.uk.schoolapiandroid.BuildConfig;
import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;

public class StudentAPIImpl implements StudentAPI {

    @Inject
    public StudentAPIImpl() {}

    interface Api {
        @GET("/school/students")
        Observable<StudentModel> getAllStudentsInfo();
    }

    private Api api;

    @Override
    public Observable<StudentModel> getAllStudentsInfo() {
        final Api lazyApi = createLazyAPI();
        return lazyApi.getAllStudentsInfo();
    }

    private Api createLazyAPI() {
        if (api == null) {
            api = createAPI();
        }
        return api;
    }

    private Api createAPI() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Api.class);
    }

}
