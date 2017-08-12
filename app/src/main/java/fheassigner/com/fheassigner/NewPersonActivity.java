package fheassigner.com.fheassigner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import model.Model;
import person.ContactInfo;
import person.Person;

public class NewPersonActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private static final int TAKE_PICTURE = 2;
    private EditText mName;
    private EditText mEmail;
    private EditText mPhone;
    private CheckBox mSendSms;
    private CheckBox mSendEmail;
    private Button mSave;
    private Button mCancel;
    private FloatingActionButton mCamera;
    private FloatingActionButton mPhotos;
    private ImageView mImageView;
    private Bitmap mPhoto;

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
        mImageView = (ImageView)findViewById(R.id.new_person_image);
        mCamera = (FloatingActionButton)findViewById(R.id.camera_fab);
        mPhotos = (FloatingActionButton)findViewById(R.id.images_fab);

        mSave.setEnabled(false);
        mSendEmail.setEnabled(false);
        mSendSms.setEnabled(false);
        mImageView.setImageResource(R.drawable.profile_icon_white);
        //mImageView.s
        //mImageView.setImageDrawable(new IconDrawable(this, Iconify.IconValue.f).sizeDp(30));
        //mImageView.setImageResource(R.mipmap.tache_balloons_png);

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

        mCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, TAKE_PICTURE);
            }
        });

        mPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson();
                Toast.makeText(NewPersonActivity.this,
                        mName.getText().toString() + " " + getResources().getString(R.string.save_successful),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NewPersonActivity.this,
                        getResources().getString(R.string.save_unsuccessful),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void savePerson(){
        Person newPerson = new Person();
        newPerson.setName(mName.getText().toString());

        if(!mEmail.toString().isEmpty() || !mPhone.toString().isEmpty()){
            ContactInfo personInfo = new ContactInfo();
            if(!mEmail.getText().toString().isEmpty()){
                personInfo.setEmail(mEmail.toString());
            }
            if(!mPhone.getText().toString().isEmpty()){
                personInfo.setPhoneNumber(mPhone.toString());
            }
            newPerson.setContact(personInfo);
        }

        newPerson.getContact().setSendEmailReminder(mSendEmail.isChecked());
        newPerson.getContact().setSendSmsReminder(mSendSms.isChecked());

        Model.getInstance().addPerson(newPerson);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && data != null) {
            switch(requestCode){
                case TAKE_PICTURE:
                    mPhoto = (Bitmap)data.getExtras().get("data");
                    break;
                case PICK_IMAGE:
                    try {
                        InputStream inputStream = getContentResolver().openInputStream(data.getData());
                        mPhoto = BitmapFactory.decodeStream(inputStream);
                    }catch(FileNotFoundException e){
                        Toast.makeText(NewPersonActivity.this,
                                getResources().getString(R.string.error_toast) + " " +
                                        getResources().getString(R.string.file_not_found),
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
            }
            if(mPhoto != null){
                Matrix m = new Matrix();
                m.setRectToRect(new RectF(0, 0, mPhoto.getWidth(), mPhoto.getHeight()),
                        new RectF(0, 0, mImageView.getWidth(), mImageView.getHeight()),
                        Matrix.ScaleToFit.CENTER);
                if(mPhoto.getHeight() < mPhoto.getWidth()){
                    mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                mImageView.setImageBitmap(Bitmap.createBitmap(mPhoto, 0, 0, mPhoto.getWidth(),
                        mPhoto.getHeight(), m, false));
            }else{
                Toast.makeText(NewPersonActivity.this,
                        getResources().getString(R.string.error_toast) + " " +
                                getResources().getString(R.string.generic_error),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
