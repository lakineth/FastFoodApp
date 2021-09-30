package com.example.ordersystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private Button addfeed;
    private ListView listview;
    /* private TextView count; */
    Context context;
    private DBHandler dbHandler;
    private List<Feedback> feedBacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = this;

        dbHandler = new DBHandler(context);
        addfeed = findViewById(R.id.addfeed);
        listview = findViewById(R.id.feedbacklist);
        feedBacks = new ArrayList<>();

        feedBacks = dbHandler.getAll();

        FeedbackAdapter adapter = new FeedbackAdapter(context,R.layout.single_feedback,feedBacks);

        listview.setAdapter(adapter);




        addfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddFeedback.class));
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Feedback feedback = feedBacks.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(feedback.getTitle2());
                builder.setMessage(feedback.getDescription2());

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteFeedback(feedback.getTitle2());
                        startActivity(new Intent(context,MainActivity2.class));
                    }
                });

                builder.show();
            }
        });

    }
}