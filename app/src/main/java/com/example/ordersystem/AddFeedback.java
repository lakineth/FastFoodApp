package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFeedback extends AppCompatActivity {

    private EditText title2, des2, email2;
    private Button addfeed;
    private DBHandler dbhandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        title2 = findViewById(R.id.editTextFeedbackName);
        des2 = findViewById(R.id.editTextFeedbackDesctipt);
        email2 = findViewById(R.id.editTextFeedbackEmail);
        addfeed = findViewById(R.id.buttonFeedAdd);
        context = this;

        dbhandler = new DBHandler(context);

        addfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userTitle2 = title2.getText().toString();
                String userEmail2 = email2.getText().toString();
                String userDescription2 = des2.getText().toString();

         /*       Feedback feedBack = new Feedback(userTitle2,userEmail2,userDescription2);
                dbhandler.addfeedback(feedBack);

                startActivity(new Intent(context,MainActivity2.class));      */

                Boolean checkinsertdata = dbhandler.insertfeedback(userTitle2, userEmail2, userDescription2);
                if(checkinsertdata==true)
                    Toast.makeText(AddFeedback.this, "New Food Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddFeedback.this, "Did not Added", Toast.LENGTH_SHORT).show();


            }
        });

    }

}