package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddToDo extends AppCompatActivity {

    private EditText title, pri, des, siz, ext;
    private Button add;
    private DBHandler dbhandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        title = findViewById(R.id.editTextTitle);
        pri = findViewById(R.id.editTextPrices);
        des = findViewById(R.id.editTextDescription);
        siz = findViewById(R.id.editTextSizes);
        ext = findViewById(R.id.editTextExtra);
        add = findViewById(R.id.buttonAdd);
        context = this;

        dbhandler = new DBHandler(context);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userTitle = title.getText().toString();
                String userPrices = pri.getText().toString();
                String userDesc = des.getText().toString();
                String userSizes = siz.getText().toString();
                String userExtra = ext.getText().toString();
                long started = System.currentTimeMillis();

                ToDo toDo = new ToDo(userTitle,userPrices,userDesc,userSizes,userExtra,started,0);
                dbhandler.addToDo(toDo);

                startActivity(new Intent(context,MainActivity.class));
            }
        });

    }

}