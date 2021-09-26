package com.example.product;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btnDataP;
    private Button btnAddC;
    private Button btnDataC;
    private Context context;
    EditText txtid, txtname, txtprice, txtcate, txtdesc;
    Button btnAdd, btnImg;
    ImageView productpic;
    SQLiteHelper DB;

    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelper sqLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        btnDataP = findViewById(R.id.btnDataP);
        btnDataP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnAddC = findViewById(R.id.btnAddC);
        btnAddC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        btnDataC = findViewById(R.id.btnDataC);
        btnDataC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        txtid = findViewById(R.id.txtid);
        txtname = findViewById(R.id.txtname);
        txtprice= findViewById(R.id.txtprice);
        txtdesc = findViewById(R.id.txtdesc);
        txtcate = findViewById(R.id.txtcate);

        btnAdd = findViewById(R.id.btnUpdate);
        DB = new SQLiteHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PIDtxt = txtid.getText().toString();
                String nametxt = txtname.getText().toString();
                String pricetxt = txtprice.getText().toString();
                String desctxt = txtdesc.getText().toString();
                String catetxt = txtcate.getText().toString();

                Boolean checkinsertdata = DB.insertfood(PIDtxt, nametxt, pricetxt, desctxt, catetxt);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "New Food Added", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Did not Added", Toast.LENGTH_SHORT).show();
            }
        });
    }


}