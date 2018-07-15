package teamkunle.co.uk.schoolapiandroid.ui.getallstudent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teamkunle.co.uk.schoolapiandroid.R;
import teamkunle.co.uk.schoolapiandroid.api.model.StudentModel;

public class GetAllStudentsAdapter extends RecyclerView.Adapter<GetAllStudentsAdapter.ViewHolder> {

    private List<StudentModel> studentModelList;

    public GetAllStudentsAdapter(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView = inflater.inflate(R.layout.item_student, parent, false);
        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView firstName;
        public TextView surname;
        public TextView age;

        public ViewHolder(View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.view_first_name);
            surname   = itemView.findViewById(R.id.view_surname);
            age       = itemView.findViewById(R.id.view_age);
        }
    }
}
