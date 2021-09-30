package com.example.product;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private Button btnDataP, btnAddC;
    private SQLiteHelper sqLiteHelper;
    Context context;
    private List<CateModel> cates;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        context = this;
        sqLiteHelper = new SQLiteHelper(context);
        listView = findViewById(R.id.list_view2);
        cates = new ArrayList<>();

        cates = sqLiteHelper.getAllCate();
        CateAdapter adapter = new CateAdapter(context,R.layout.catelist,cates);

        listView.setAdapter(adapter);
        btnAddC=findViewById(R.id.btnAddC);
        btnAddC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this,MainActivity4.class);
                startActivity(intent);
            }
        });

        btnDataP=findViewById(R.id.btnDataP);
        btnDataP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this,MainActivity6.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final CateModel cateModel = cates.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(cateModel.getCID());
                builder.setMessage(cateModel.getCname());

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sqLiteHelper.deletecate(cateModel.getCID());
                        Toast.makeText(MainActivity5.this, "Category Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,MainActivity2.class));
                    }
                });
                builder.show();
            }
        });
    }
}