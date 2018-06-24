package teamkunle.co.uk.schoolapiandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity {

    private static final String INITIAL_FRAGMENT = "First Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.student_activity_container, TeacherFragment.createInstance(), INITIAL_FRAGMENT)
                .commit();
    }
}
