package fheassigner.com.fheassigner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import model.Model;

public class PersonActivity extends AppCompatActivity {

    private FloatingActionButton mAddFab;
    private RecyclerView mPersonRecycler;
    private PersonListAdapter mAdapter;

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

        mPersonRecycler = (RecyclerView)findViewById(R.id.people_recycler_view);
        mPersonRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PersonListAdapter(Model.getInstance().getPeople());
        mPersonRecycler.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

    }
}
