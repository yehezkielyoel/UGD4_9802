package platformpbp.uajy.yehezkielyoel.ugd4_9802_e;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class addFragment extends Fragment {
    TextInputEditText editTextNumber,editTextName,editTextAge;
    private Button btn_add,btn_cancel;

    public addFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        editTextNumber = view.findViewById(R.id.input_number);
        editTextName = view.findViewById(R.id.input_name);
        editTextAge = view.findViewById(R.id.input_age);
        btn_add = view.findViewById(R.id.btn_add);
        btn_cancel = view.findViewById(R.id.btn_cancel);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(addFragment.this).commit();
            }
        });
    }

    private void addEmployee(){
        final String number = editTextNumber.getText().toString();
        final String name = editTextName.getText().toString();
        final String age = editTextAge.getText().toString();

        class AddEmployee extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                Employee employee = new Employee();
                employee.setFullName(name);
                employee.setStringNumber(number);
                employee.setStringAge(age);

                DatabaseClient.getInstance(getActivity().getApplicationContext()).getDatabase()
                        .userDao()
                        .insert(employee);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getActivity().getApplicationContext(), "User saved", Toast.LENGTH_SHORT).show();
                editTextName.setText("");
            }
        }

        AddEmployee add = new AddEmployee();
        add.execute();
    }
}