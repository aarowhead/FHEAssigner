package fheassigner.com.fheassigner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import person.Person;

public class NewPersonActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mEmail;
    private EditText mPhone;
    private CheckBox mSendSms;
    private CheckBox mSendEmail;
    private Button mSave;
    private Button mCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mName = (EditText)findViewById(R.id.new_person_name);
        mEmail = (EditText)findViewById(R.id.new_person_email);
        mPhone = (EditText)findViewById(R.id.new_person_phone);
        mSendEmail = (CheckBox)findViewById(R.id.notify_email_check_box);
        mSendSms = (CheckBox)findViewById(R.id.notify_sms_check_box);
        mSave = (Button)findViewById(R.id.new_person_save_button);
        mCancel = (Button)findViewById(R.id.new_person_cancel_button);

        mSave.setEnabled(false);
        mSendEmail.setEnabled(false);
        mSendSms.setEnabled(false);

        mName.addTextChangedListener(new TextWatcher() {
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

        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSendEmail.setEnabled(!s.toString().isEmpty());
            }
        });

        mPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSendSms.setEnabled(!s.toString().isEmpty());
            }
        });
    }

    private void savePerson(){
        Person newPerson = new Person();
        newPerson.setName(mName.getText().toString());

        //TODO: Finish this to save to model
    }
}
