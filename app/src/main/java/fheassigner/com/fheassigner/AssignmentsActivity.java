package fheassigner.com.fheassigner;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AssignmentsActivity extends AppCompatActivity {

    private FloatingActionButton mAddFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assigments);

        mAddFab = (FloatingActionButton) findViewById(R.id.add_assignment_fab);
        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addAssignmentIntent = new Intent(AssignmentsActivity.this, NewAssignmentActivity.class);
                startActivity(addAssignmentIntent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
