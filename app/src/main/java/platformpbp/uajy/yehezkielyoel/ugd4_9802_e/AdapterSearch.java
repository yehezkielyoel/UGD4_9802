package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder>{
    private Context context;
    private List<Employee> employeeList;

    public AdapterSearch(Context context, List<Employee> employeeListList) {
        this.context = context;
        this.employeeList = employeeListList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.textViewName.setText(employeeList.get(position));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.full_name_text);
        }
    }
}
