package fheassigner.com.fheassigner;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PersonActivity extends AppCompatActivity {

    private FloatingActionButton mAddFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAddFab = (FloatingActionButton) findViewById(R.id.add_person_fab);
        mAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addAssignmentIntent = new Intent(PersonActivity.this, NewPersonActivity.class);
                startActivity(addAssignmentIntent);
            }
        });
    }
}
