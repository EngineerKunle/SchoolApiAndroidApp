package teamkunle.co.uk.schoolapiandroid.api;

import io.reactivex.Observable;
import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;

public interface StudentAPI {
     Observable<StudentModel> getAllStudentsInfo();
}
