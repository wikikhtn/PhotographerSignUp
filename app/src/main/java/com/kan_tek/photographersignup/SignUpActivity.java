package com.kan_tek.photographersignup;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {
    private CircleImageView mImgViewProfile;
    private EditText mEdtFirstName;
    private EditText mEdtLastName;
    private EditText mEdtPhoneNumber;
    private EditText mEdtEmail;
    private EditText mEdtBirthday;
    private EditText mEdtSSN;
    private EditText mEdtPassword;
    private EditText mEdtConfirmPassword;
    private CheckBox mChkYes;
    private CheckBox mChkNo;
    private Button mBtnAccept;
    private Calendar mCalendar;
    private String mCheckBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBar();
        initView();
        setListener();
        loadData();

    }

    public void setActionBar() {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.action_bar_custom, null);

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);
        mActionBar.setCustomView(view, layoutParams);
        Toolbar toolbar = (Toolbar) view.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);

        ImageView mImgViewBack = view.findViewById(R.id.imageViewBack);
        TextView mTvTitle = view.findViewById(R.id.tvTitle);

        mImgViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mTvTitle.setText(R.string.title_text);
    }

    public void initView() {
        mImgViewProfile = (CircleImageView) findViewById(R.id.image_profile);
        mEdtFirstName = (EditText) findViewById(R.id.edtFirstName);
        mEdtLastName = (EditText) findViewById(R.id.edtLastName);
        mEdtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber);
        mEdtEmail = (EditText) findViewById(R.id.edtEmail);
        mEdtBirthday = (EditText) findViewById(R.id.edtBirthday);
        mEdtSSN = (EditText) findViewById(R.id.edtSSN);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mEdtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPass);
        mChkYes = (CheckBox) findViewById(R.id.chkYes);
        mChkNo = (CheckBox) findViewById(R.id.chkNo);
        mBtnAccept = (Button) findViewById(R.id.btnAccept);
        mCalendar = Calendar.getInstance();
    }

    public void loadData() {

    }

    public void setListener() {
        mImgViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent chooseImageIntent = ImagePicker.getPickImageIntent(getActivity(),1);

            }
        });

        mEdtBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mEdtBirthday.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                    }
                }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }

        });

        mChkYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isYesChecked) {
                if (isYesChecked) {
                    mChkNo.setChecked(false);
                    mCheckBackground = "YES";
                } else {
                    mCheckBackground = "";
                }
            }
        });

        mChkNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isNoChecked) {
                if (isNoChecked) {
                    mChkYes.setChecked(false);
                    mCheckBackground = "NO";
                } else {
                    mCheckBackground = "";
                }
            }
        });

        mBtnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isEmpty = checkEmptyInput(new EditText[]{mEdtFirstName, mEdtLastName, mEdtPhoneNumber, mEdtEmail, mEdtBirthday,
                        mEdtSSN, mEdtPassword, mEdtConfirmPassword});
                String password = mEdtPassword.getText().toString().trim();
                String confirmPassword = mEdtConfirmPassword.getText().toString().trim();

                if (isEmpty || mCheckBackground.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.please_enter_info), Toast.LENGTH_SHORT).show();
                } else if(mEdtSSN.length() < 4) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.ssn_least_4), Toast.LENGTH_SHORT).show();
                } else if (mEdtPhoneNumber.length() < 10) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.phone_least_10), Toast.LENGTH_SHORT).show();
                } else if (checkValidEmail(mEdtEmail.getText().toString().trim())){
                    Toast.makeText(SignUpActivity.this,getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();
                } else if (confirmPassword.equals(password)){

                } else {
                    Toast.makeText(SignUpActivity.this,getString(R.string.confirm_pass_dont_match), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public boolean checkValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern)) {
            //valid email
            return false;
        } else {
            //invalid email
            return true;
        }
    }

    public boolean checkEmptyInput(EditText[] fields) {
        for (int i = 0; i < fields.length; i++) {
            EditText currentField = fields[i];
            if (currentField.getText().toString().length() <= 0) {
                //has field empty
                return true;
            }
        }
        //not has field empty
        return false;
    }

}
