package com.example.adminpanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button addfood,homepage;
    //Dialog View find
    EditText Name,Price,URL;
    Button Submit;
    String ProductName,ProductPrice,ProductURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homepage=findViewById(R.id.homepage);
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HomeScreen.class);
                startActivity(intent);
            }
        });
        addfood=findViewById(R.id.btnAddFood);
        addfood.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.upload);

                Name=dialog.findViewById(R.id.uploadName);
                Price=dialog.findViewById(R.id.uploadPrice);
                URL=dialog.findViewById(R.id.uploadurl);
                Submit=dialog.findViewById(R.id.savebutton);



                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ProductName=Name.getText().toString();
                        ProductPrice=Price.getText().toString();
                        ProductURL=URL.getText().toString();


                        Map<String, Object> exclusive = new HashMap<>();
                        exclusive.put("ProductName", ProductName);
                        exclusive.put("ProductPrice", ProductPrice);
                        exclusive.put("ProductURL", ProductURL);


                        FirebaseDatabase.getInstance().getReferenceFromUrl("https://adminpanel-8d5b3-default-rtdb.firebaseio.com/").child("Recommended Products").push()
                                .setValue(exclusive)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Name.setText("");
                                        Price.setText("");
                                        URL.setText("");
                                        Toast.makeText(MainActivity.this, "Successs", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                                    }
                                });

                        dialog.dismiss();
                    }

                });
                dialog.show();

            }
        });
    }
}