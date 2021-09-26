package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private EditText txtid, txtname, txtprice, txtdesc, txtcate2;
    private Button btnUpdate;
    private SQLiteHelper sqLiteHelper;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        context = this;
        sqLiteHelper = new SQLiteHelper(context);

        txtid = findViewById(R.id.txtid);
        txtname = findViewById(R.id.txtname);
        txtprice = findViewById(R.id.txtprice);
        txtdesc = findViewById(R.id.txtdesc);
        txtcate2 = findViewById(R.id.txtcate2);
        btnUpdate = findViewById(R.id.btnUpdate);


        final String id = getIntent().getStringExtra("name");
        FoodModel foodModel = sqLiteHelper.getsingle(id);

        txtid.setText(foodModel.getPID());
        txtname.setText(foodModel.getName());
        txtprice.setText(foodModel.getPrice());
        txtdesc.setText(foodModel.getDescription());
        txtcate2.setText(foodModel.getCategory());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtid.getText().toString();
                String name = txtname.getText().toString();
                String price = txtprice.getText().toString();
                String desc = txtdesc.getText().toString();
                String cate = txtcate2.getText().toString();

                FoodModel foodModel = new FoodModel(id,name,price,desc,cate);
                int state = sqLiteHelper.updateFoods(foodModel);
                if(state >= 1)
                     Toast.makeText(MainActivity3.this, "Food Updated Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this, "Does Not Updated", Toast.LENGTH_SHORT).show();
                System.out.println(state);
                startActivity(new Intent(context,MainActivity2.class));

            }
        });
    }
}