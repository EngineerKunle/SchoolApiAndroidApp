package teamkunle.co.uk.schoolapiandroid.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teamkunle.co.uk.schoolapiandroid.R;

public class GetAllStudentFragment extends Fragment {

    public GetAllStudentFragment() {}

    public static GetAllStudentFragment createInstance() {
        GetAllStudentFragment fragment = new GetAllStudentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_all_student, container, false);
        return view;
    }

}
