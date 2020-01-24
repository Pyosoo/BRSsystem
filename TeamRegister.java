package com.example.snstk.psrecord;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.Manifest;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class TeamRegister extends AppCompatActivity {

    private static final int PICK_FROM_CAMERA = 0;
    private static final int PICK_FROM_ALBUM = 1;
    private static final int CROP_FROM_IMAGE = 2;
    private Uri mImageCaptureUri;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    //프로그래스바 위한 장치들


    private File tempFile;
    ImageView TeamPicture;
    Button PictureButton;
    EditText TeamNameET;
    EditText TeamLeaderET;
    EditText TeamInfoET;
    Button TeamRegisterBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_register);

        //프로그래스바 위한 장치들


        tedPermission();

        TeamPicture = (ImageView)findViewById(R.id.TeamPicture);
        PictureButton = (Button)findViewById(R.id.PictureButton);
        TeamNameET = (EditText)findViewById(R.id.TeamNameET);
        TeamLeaderET = (EditText)findViewById(R.id.TeamLeaderET);
        TeamInfoET = (EditText)findViewById(R.id.TeamInfoET);
        TeamRegisterBT = (Button)findViewById(R.id.TeamRegisterBT);

        mStorageRef = FirebaseStorage.getInstance().getReference("Teams");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Teams");


        PictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAlbum();
            }
        });


        TeamRegisterBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDatabase();
            }
        });

    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void saveDatabase(){
        
        String teamName = TeamNameET.getText().toString();
        String teamLeader = TeamLeaderET.getText().toString();
        String teamInfo = TeamInfoET.getText().toString();

        if(mImageCaptureUri != null){
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

          //  SimpleDateFormat formatter = new SimpleDateFormat(teamName);
          //  Date now = new Date();
          ///  String filename = formatter.format(now) +  ".png";
            String filename = teamName + ".png";
            StorageReference storageReference = firebaseStorage.getReferenceFromUrl("gs://psrecords-461ae.appspot.com").child(filename);

            storageReference.putFile(mImageCaptureUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) { //등록성공시
                            Toast.makeText(TeamRegister.this, "Team Register Complete", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ChoiceActivity.class);
                            startActivity(intent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TeamRegister.this, "Team Register Failed. Try again", Toast.LENGTH_SHORT).show();
                        }
                    });
        }else{
            Toast.makeText(TeamRegister.this, "사진을 먼저 등록하여주세요!", Toast.LENGTH_SHORT).show();
        }

    }

    private void tedPermission(){
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                //권한 요청 성공
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                //권한 요청 실패
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();

    }

    private void goToAlbum(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_FROM_ALBUM){

            Uri photoUri = data.getData();
            Cursor cursor = null;
            try {

                /*
                 *  Uri 스키마를
                 *  content:/// 에서 file:/// 로  변경한다.
                 */
                String[] proj = { MediaStore.Images.Media.DATA };

                assert photoUri != null;
                cursor = getContentResolver().query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));

                mImageCaptureUri = photoUri;

            }finally {
                if(cursor != null){
                    cursor.close();
                }
            }
            setImage();
            }
    }

    private void setImage() {

        ImageView imageView = findViewById(R.id.TeamPicture);

        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap originalBm = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);

        imageView.setImageBitmap(originalBm);

    }
}

