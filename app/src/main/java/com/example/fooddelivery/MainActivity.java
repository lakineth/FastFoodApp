 package com.example.fooddelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

 public class MainActivity extends AppCompatActivity {

     private EditText name, code, phone, province, city, zone, address;
     private Button add;
     private  DBhandler dbHandler;
     private Context context;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);





         //   button = findViewById(R.id.btnOne) ;
         //  button.setOnClickListener(new View.OnClickListener() {
         //     @Override
         //     public void onClick(View view) {

         //  Intent i = new Intent(getApplicationContext(), MainActivity2.class);
         // startActivity(i);
         //      text = findViewById(R.id.txtHello);
         //      text.setText("Code Change");

         //  }
         //});

         name = findViewById(R.id.editText1);
         code = findViewById(R.id.editform2);
         phone = findViewById(R.id.editform3);
         province = findViewById(R.id.editform4);
         city = findViewById(R.id.editform5);
         zone = findViewById(R.id.editform6);
         address = findViewById(R.id.editform7);

         add = findViewById(R.id.btnAdd);
         context = this;
         dbHandler = new DBhandler(context);


         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 String userName = name.getText().toString();
                 String userCode = code.getText().toString();
                 String userPhone = phone.getText().toString();
                 String userProvince = province.getText().toString();
                 String userCity = city.getText().toString();
                 String userZone = zone.getText().toString();
                 String userAddress = address.getText().toString();
                 long started = System.currentTimeMillis();

                 //catch saved data
                 CheckoutModel checkoutModel = new  CheckoutModel(userName,userCode,userPhone,userProvince,userCity,userZone,userAddress,started,0);
                 dbHandler.addCheckout(checkoutModel );

                 Toast.makeText(context, "Details Added Successfully", Toast.LENGTH_SHORT).show();

                 startActivity(new Intent(context,ListViewActivity.class));
             }
         });
     }


 }





  /* @Override
  protected void onStart() {
     super.onStart();
       Log.i(TAG,"onStart");
    }*/

   // @Override
  //  protected void onRestart() {
     //   super.onRestart();
     //   Log.i(TAG,"onRestart");
  //  }

  //  @Override
  //  protected void onPause() {
  //      super.onPause();
  //      Log.i(TAG,"onPause");
 //   }

  //  @Override
 //   protected void onResume() {
   //     super.onResume();
    //    Log.i(TAG,"onResume");
   // }

   // @Override
  //  protected void onStop() {
   //     super.onStop();
  //      Log.i(TAG,"onStop");
  //  }

  //  @Override
  //  protected void onDestroy() {
  //      super.onDestroy();
 //      Log.i(TAG,"onDestroy");
  //  }

  //  @Override
  //  protected void onRestoreInstanceState(Bundle savedInstanceState) {
  //      super.onRestoreInstanceState(savedInstanceState);
  //      Log.i(TAG,"onRestoreInstanceState");
  //  }

  //  @Override
 //   protected void onSaveInstanceState(Bundle outState) {
      //  super.onSaveInstanceState(outState);

   //     Log.i(TAG,"onSaveInstanceState");
   // }

