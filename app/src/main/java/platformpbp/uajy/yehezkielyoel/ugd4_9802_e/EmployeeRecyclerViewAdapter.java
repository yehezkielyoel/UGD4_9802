package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeRecyclerViewAdapter.EmployeeViewHolder> {

    private Context context;
    private List<Employee> employeeListList;

    public EmployeeRecyclerViewAdapter(Context context, List<Employee> employeeListList) {
        this.context = context;
        this.employeeListList = employeeListList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeListList.get(position);
        holder.textViewNumber.setText(employee.getStringNumber());
        holder.textViewName.setText(employee.getFullName());
        holder.textViewAge.setText(employee.getStringAge()+" Years Old");
    }

    @Override
    public int getItemCount() {
        return employeeListList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName,textViewNumber,textViewAge;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.number_text);
            textViewName = itemView.findViewById(R.id.full_name_text);
            textViewAge = itemView.findViewById(R.id.age_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            Employee employee = employeeListList.get(getAdapterPosition());
            Bundle data = new Bundle();
            data.putSerializable("employee", employee);
            UpdateFragment updateFragment = new UpdateFragment();
            updateFragment.setArguments(data);
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, updateFragment)
                    .commit();
        }
    }
}
