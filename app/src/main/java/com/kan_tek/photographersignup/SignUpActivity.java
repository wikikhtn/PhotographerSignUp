package com.kan_tek.photographersignup;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class SignUpActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private ProgressDialog mProgressDialog;
    private ViewGroup mLayoutProfile;
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
    private File mProfileImage;
//    private String mProfileImage;
    private static final int REQUEST_CAMERA = 0;
    private static final int SELECT_FILE = 1;
    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_READ_EXTERNAL_PERM = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBar();
        initView();
        setAutoSizeImageProfile();
        setListener();
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
        mProgressDialog = new ProgressDialog(this);
        mLayoutProfile = (ViewGroup) findViewById(R.id.layout_img_profile);
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
        mCheckBackground = "";
    }

    public void setListener() {
        mImgViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
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
                boolean isEmptyInput = checkEmptyInput(new EditText[]{mEdtFirstName, mEdtLastName, mEdtPhoneNumber, mEdtEmail, mEdtBirthday,
                        mEdtSSN, mEdtPassword, mEdtConfirmPassword});
                String password = mEdtPassword.getText().toString().trim();
                String confirmPassword = mEdtConfirmPassword.getText().toString().trim();

                if (isEmptyInput) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.please_enter_info), Toast.LENGTH_SHORT).show();
                } else if (mCheckBackground.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.please_choose_background_check), Toast.LENGTH_SHORT).show();
                } else if (mEdtSSN.length() < 4) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.ssn_least_4), Toast.LENGTH_SHORT).show();
                } else if (mEdtPhoneNumber.length() < 10) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.phone_least_10), Toast.LENGTH_SHORT).show();
                } else if (checkValidEmail(mEdtEmail.getText().toString().trim())) {
                    Toast.makeText(SignUpActivity.this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();
                } else if (confirmPassword.equals(password)) {
                    checkSignUp();
                } else {
                    Toast.makeText(SignUpActivity.this, getString(R.string.confirm_pass_dont_match), Toast.LENGTH_SHORT).show();
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

    public void setAutoSizeImageProfile() {
        ViewTreeObserver vto = mLayoutProfile.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightView = getWindow().getDecorView().getBottom();
                int height = heightView * 6 / 52; //Height image profile = 3/4 height container layout = 2/13 parent layout
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(height, height);
                mImgViewProfile.setLayoutParams(lp);
            }
        });
    }

    private boolean hasCameraPermission() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA);
    }

    private boolean hasReadExternalPermission() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void cameraTask() {
        if (hasCameraPermission()) {
            cameraIntent();
        }
    }

    @AfterPermissionGranted(RC_READ_EXTERNAL_PERM)
    public void choosePictureTask() {
        if (hasReadExternalPermission()) {
            galleryIntent();
        }
    }

    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setTitle("Add profile picture!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    if (hasCameraPermission()) {
                        cameraIntent();
                    } else {
                        EasyPermissions.requestPermissions(
                                SignUpActivity.this,
                                getString(R.string.rationale_camera),
                                RC_CAMERA_PERM,
                                Manifest.permission.CAMERA);
                    }
                } else if (items[item].equals("Choose from Library")) {
                    if (hasReadExternalPermission()) {
                        galleryIntent();
                    } else {
                        EasyPermissions.requestPermissions(
                                SignUpActivity.this,
                                getString(R.string.rationale_external_storage),
                                RC_READ_EXTERNAL_PERM,
                                Manifest.permission.READ_EXTERNAL_STORAGE);
                    }
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mImgViewProfile.setImageBitmap(thumbnail);
        mProfileImage = destination;
//        byte[] imageBytes = bytes.toByteArray();
//        mProfileImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        Uri selectedImageURI = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                selectedImageURI = data.getData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mImgViewProfile.setImageBitmap(bm);
        mProfileImage = new File(Environment.getExternalStorageDirectory(), selectedImageURI.getPath());
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    public void checkSignUp() {
        SignUpRequestModel rqt = new SignUpRequestModel();
        rqt.setFirstName(mEdtFirstName.getText().toString().trim());
        rqt.setLastName(mEdtLastName.getText().toString().trim());
        rqt.setPhoneNumber(mEdtPhoneNumber.getText().toString().trim());
        rqt.setEmailId(mEdtEmail.getText().toString().trim());
        rqt.setDateOfBirth(mEdtBirthday.getText().toString().trim());
        rqt.setSsn(mEdtSSN.getText().toString().trim());
        rqt.setPassword(mEdtPassword.getText().toString().trim());
        rqt.setBackgroundCheck(mCheckBackground);
        rqt.setProfileImage(mProfileImage);
        rqt.setDeviceToken("1");
        rqt.setDeviceType("ANDROID");
        SignUpApiHandler.signUpAccount(this, rqt, new SmartCallBack<SignUpResponseModel>() {
            @Override
            public Context getCurrentContext() {
                return SignUpActivity.this;
            }

            @Override
            public void onSuccess(SignUpResponseModel response) {
                if (response.getStatusCode() == HttpURLConnection.HTTP_CREATED) {
                    Toast.makeText(SignUpActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError() {
//                Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
