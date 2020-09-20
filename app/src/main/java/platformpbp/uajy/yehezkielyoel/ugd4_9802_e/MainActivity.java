package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editTextName,editTextNumber,editTextAge;
    private Button addBtn;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.input_number);
        editTextName = findViewById(R.id.input_name);
        editTextAge = findViewById(R.id.input_age);
        addBtn = findViewById(R.id.btn_add);
        refreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.user_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getEmployees();
                refreshLayout.setRefreshing(false);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment AddFragment = new addFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout, AddFragment)
                        .commit();
            }
        });
        getEmployees();
    }

    private void getEmployees(){
        class GetEmployees extends AsyncTask<Void, Void, List<Employee>> {

            @Override
            protected List<Employee> doInBackground(Void... voids) {
                List<Employee> employees = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getDatabase()
                        .userDao()
                        .getAll();
                return employees;
            }

            @Override
            protected void onPostExecute(List<Employee> employees) {
                super.onPostExecute(employees);
                EmployeeRecyclerViewAdapter adapter = new EmployeeRecyclerViewAdapter(MainActivity.this, employees);
                recyclerView.setAdapter(adapter);
                if (employees.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Empty List", Toast.LENGTH_SHORT).show();
                }
            }
        }

        GetEmployees get = new GetEmployees();
        get.execute();
    }
}