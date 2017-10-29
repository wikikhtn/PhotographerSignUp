package com.kan_tek.photographersignup;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {
    private ActionBar mActionBar;
    private ImageView mImgViewBack;
    private CircleImageView mImgViewProfile;
    private TextView mTvTitle;
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
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.action_bar_custom, null);

        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT);
        mActionBar.setCustomView(view, layoutParams);
        Toolbar toolbar = (Toolbar) view.getParent();
        toolbar.setContentInsetsAbsolute(0, 0);

        mImgViewBack = view.findViewById(R.id.imageViewBack);
        mTvTitle = view.findViewById(R.id.tvTitle);

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
    }

    public void loadData() {

    }

    public void setListener() {
        mImgViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mEdtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void checkValidInput(){

    }
}
