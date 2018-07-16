package teamkunle.co.uk.schoolapiandroid.api;

import java.util.List;

import io.reactivex.Observable;
import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;

public interface StudentAPI {
     Observable<List<StudentModel>> getAllStudentsInfo();
}
