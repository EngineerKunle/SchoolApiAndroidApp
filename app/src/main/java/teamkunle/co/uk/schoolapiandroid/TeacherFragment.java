
package teamkunle.co.uk.schoolapiandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import teamkunle.co.uk.schoolapiandroid.di.components.TeacherComponent;
import teamkunle.co.uk.schoolapiandroid.di.module.TeacherModule;
import teamkunle.co.uk.schoolapiandroid.ui.getallstudent.GetAllStudentFragment;


public class TeacherFragment extends Fragment implements StudentActivityContract.View {

    private Button getAllStudentButton;

    public TeacherFragment() {}

    @Inject
    StudentActivityContract.Presenter<StudentActivityContract.View> Presenter;

    private TeacherComponent component;

    public static TeacherFragment createInstance() {
        TeacherFragment teacherFragment = new TeacherFragment();
        return teacherFragment;
    }

    private void initComponent() {
        component = SchoolApplication.getApp()
                .getComponent()
                .plus(new TeacherModule());
        component.inject(this);

        Presenter.attach(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher, container, false);

        getAllStudentButton = view.findViewById(R.id.get_all_student_button);

        getAllStudentButton.setOnClickListener((v) -> Presenter.getAllStudentList());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initComponent();
    }

    @Override
    public void onDetach() {
        Presenter.detach();
        super.onDetach();
    }

    @Override
    public void startGetAllFragment() {
        Toast.makeText(getContext(), "Get All Student Fragment", Toast.LENGTH_LONG).show();
        changeFragment();
    }

    private void changeFragment() {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.student_activity_container, GetAllStudentFragment.createInstance())
                .addToBackStack(null)
                .commit();
    }
}
