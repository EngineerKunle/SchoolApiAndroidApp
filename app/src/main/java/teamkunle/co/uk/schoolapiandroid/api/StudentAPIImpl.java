package teamkunle.co.uk.schoolapiandroid.api;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        Observable<List<StudentModel>> getAllStudentsInfo();
    }

    private Api api;

    @Override
    public Observable<List<StudentModel>> getAllStudentsInfo() {
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

        final OkHttpClient httpClient;
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(loggingInterceptor);

        httpClient = httpClientBuilder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Api.class);
    }

}
