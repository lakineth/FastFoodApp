package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private Button btnDataC;
    private Button btnAddCa;
    EditText txtid, txtname;
    SQLiteHelper DB;
    private Context context;

    public static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnDataC=findViewById(R.id.btnDataC);
        btnDataC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                startActivity(intent);
            }
        });
        btnAddCa = findViewById(R.id.btnAddCa);
        txtid = findViewById(R.id.txtid);
        txtname = findViewById(R.id.txtname);
        DB = new SQLiteHelper(this);

        btnAddCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CIDtxt = txtid.getText().toString();
                String cnametxt = txtname.getText().toString();

                Boolean checkinsertcate = DB.insertcate(CIDtxt, cnametxt);
                if(checkinsertcate==true)
                    Toast.makeText(MainActivity4.this, "New Category Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity4.this, "Did not Added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}