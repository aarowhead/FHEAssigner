package fheassigner.com.fheassigner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import fheActivity.FheActivity;

public class NewAssignmentActivity extends AppCompatActivity {

    private EditText mAssignment;
    private Spinner mDifficulty;
    private Button mSave;
    private Button mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_assignment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAssignment = (EditText)findViewById(R.id.new_assignment_name);
        mDifficulty = (Spinner)findViewById(R.id.difficulty_spinner);
        mSave = (Button)findViewById(R.id.new_assignment_save_button);
        mCancel = (Button)findViewById(R.id.new_assignment_cancel_button);

        mSave.setEnabled(false);

        mAssignment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSave.setEnabled(!s.toString().isEmpty());
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAssignment();
                Toast.makeText(NewAssignmentActivity.this,
                        mAssignment.getText().toString() + " " + getResources().getString(R.string.save_successful),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewAssignmentActivity.this,
                        getResources().getString(R.string.save_unsuccessful),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.difficulty_array, android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mDifficulty.setAdapter(spinnerAdapter);

    }

    private void saveAssignment(){
        FheActivity assignment = new FheActivity();
        assignment.setName(mAssignment.getText().toString());
        assignment.setDifficulty(mDifficulty.getSelectedItemPosition());
    }
}
