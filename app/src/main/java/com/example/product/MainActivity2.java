package com.example.product;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {


    private Button btnAddP ,btnDataC, btnAddC;
    private SQLiteHelper sqLiteHelper;
    private ListView listView;
    Context context;
    private List<FoodModel> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        context = this;
        sqLiteHelper = new SQLiteHelper(context);
        listView = findViewById(R.id.list_view);
        foods = new ArrayList<>();

        foods = sqLiteHelper.getAll();
        FoodAdapter adapter = new FoodAdapter(context,R.layout.foodlist,foods);

        listView.setAdapter(adapter);

        btnAddP = findViewById(R.id.btnAddP);
        btnAddP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnAddC = findViewById(R.id.btnAddC);
        btnAddC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        btnDataC = findViewById(R.id.btnDataC);
        btnDataC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               final FoodModel foodModel = foods.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(foodModel.getName());
                builder.setMessage(foodModel.getPrice());


                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Intent intent = new Intent(context,MainActivity3.class);
                      intent.putExtra("name", String.valueOf(foodModel.getName()));
                      startActivity(intent);

                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqLiteHelper.deletefood(foodModel.getPID());
                            Toast.makeText(MainActivity2.this, "Food Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,MainActivity2.class));
                    }
                });
                builder.show();
            }
        });

    }
}