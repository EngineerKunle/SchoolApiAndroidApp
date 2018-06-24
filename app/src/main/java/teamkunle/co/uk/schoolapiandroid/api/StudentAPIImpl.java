package teamkunle.co.uk.schoolapiandroid.api;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;

public class StudentAPIImpl implements StudentAPI {

    interface Api {
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
            api = createAPI("BASE_URl"); //TODO : add URl
        }
        return api;
    }

    private Api createAPI(String baseURl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(Api.class);
    }

}
