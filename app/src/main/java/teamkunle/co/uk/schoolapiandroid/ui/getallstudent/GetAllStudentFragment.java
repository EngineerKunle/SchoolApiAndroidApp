package teamkunle.co.uk.schoolapiandroid.ui.getallstudent;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import teamkunle.co.uk.schoolapiandroid.R;
import teamkunle.co.uk.schoolapiandroid.SchoolApplication;
import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;
import teamkunle.co.uk.schoolapiandroid.di.components.GetAllStudentComponent;
import teamkunle.co.uk.schoolapiandroid.di.module.GetAllStudentModule;

public class GetAllStudentFragment extends Fragment implements GetAllStudentContract.View {

    public GetAllStudentFragment() {}

    private GetAllStudentComponent component;

    private RecyclerView getAllStudentRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeContainer;
    private GetAllStudentsAdapter adapter;

    private static final String TAG = GetAllStudentFragment.class.getSimpleName();

    public static GetAllStudentFragment createInstance() {
        GetAllStudentFragment fragment = new GetAllStudentFragment();
        return fragment;
    }

    @Inject
    GetAllStudentContract.Presenter<GetAllStudentContract.View> presenter;

    private void initView(View view) {

        swipeContainer = view.findViewById(R.id.get_all_student_container);

        swipeContainer.setOnRefreshListener(() -> presenter.apiCallToGetStudents());

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        getAllStudentRecyclerView = view.findViewById(R.id.list_of_students);

    }

    private void initComponent() {
        component = SchoolApplication.getApp()
                .getComponent()
                .plus(new GetAllStudentModule());

        component.inject(this);
        presenter.attach(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_all_student, container, false);

        initView(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initComponent();
    }

    @Override
    public void onDetach() {
        presenter.detach();
        super.onDetach();
    }

    @Override
    public void populateRecyclerView(List<StudentModel> models) {
        getAllStudentRecyclerView.setHasFixedSize(true);
        adapter = new GetAllStudentsAdapter(models);

        getAllStudentRecyclerView.setAdapter(adapter);

        layoutManager = new LinearLayoutManager(getContext());

        getAllStudentRecyclerView.setLayoutManager(layoutManager);
        swipeContainer.setRefreshing(false);
    }

    @Override
    public void errorAPICall(Throwable t) {
        Toast.makeText(getContext(), R.string.get_all_student_fragment_error, Toast.LENGTH_LONG).show();
        Log.e(TAG, "Error occured here " + t.getMessage());
        swipeContainer.setRefreshing(false);
    }
}
