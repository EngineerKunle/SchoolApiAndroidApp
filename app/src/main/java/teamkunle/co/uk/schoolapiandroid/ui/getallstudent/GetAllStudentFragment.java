package teamkunle.co.uk.schoolapiandroid.ui.getallstudent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import teamkunle.co.uk.schoolapiandroid.R;

public class GetAllStudentFragment extends Fragment {

    public GetAllStudentFragment() {}

    private RecyclerView getAllStudentRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    public static GetAllStudentFragment createInstance() {
        GetAllStudentFragment fragment = new GetAllStudentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_all_student, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        progressBar = view.findViewById(R.id.progress_loading);
        progressBar.setVisibility(View.VISIBLE);

        getAllStudentRecyclerView = view.findViewById(R.id.list_of_students);
        getAllStudentRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());

        getAllStudentRecyclerView.setLayoutManager(layoutManager);
    }
}
