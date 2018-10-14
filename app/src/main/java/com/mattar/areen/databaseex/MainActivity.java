package com.mattar.areen.databaseex;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends Activity {
    private  static  final  int REQUESTIMAGE=100;
    byte[] contactArray;

    EditText nameEditText;
    EditText phoneEditText;
    EditText emailEditText;
    ImageView contactImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText=findViewById(R.id.nameEditText);
        phoneEditText=findViewById(R.id.phoneEditText);
        emailEditText=findViewById(R.id.emailEditText);
        contactImgView=findViewById(R.id.imageView);
    }
    public void saveWithImage(View v){
        Dal dal=new Dal(MainActivity.this);
        dal.addContactWithImage(nameEditText.getText().toString(),emailEditText.getText().toString(),phoneEditText.getText().toString(),contactArray);
    }
    public void  imgClick(View v){
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,REQUESTIMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==REQUESTIMAGE&& resultCode==Activity.RESULT_OK){
            Bitmap userBitmap=(Bitmap)data.getExtras().get("data");
            contactImgView.setImageBitmap(userBitmap);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            userBitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
            contactArray=baos.toByteArray();
        }
    }
    public void saveContactButtonListener(View v){
        Dal dal=new Dal(this);
        dal.addContact(nameEditText.getText().toString(),emailEditText.getText().toString(),phoneEditText.getText().toString());
        Intent i=new Intent(MainActivity.this,DisplayAllContacts.class);
        startActivity(i);
    }
    public void displayContactBtn(View v){
    Intent i=new Intent(MainActivity.this,DisplayAllContacts.class);
      startActivity(i);
    }
}
