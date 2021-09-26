package com.example.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<FoodModel> {
    private  Context context;
    private  int resource;
    List<FoodModel> foods;
    FoodAdapter(Context context, int resource, List<FoodModel> foods){
        super(context, resource,foods);
        this.context =context;
        this.resource =resource;
        this.foods = foods;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView text_id = row.findViewById(R.id.text_id);
        TextView edittext_name = row.findViewById(R.id.edittext_name);
        TextView edittext_price = row.findViewById(R.id.edittext_price);
        TextView edittext_desc = row.findViewById(R.id.edittext_desc);
        TextView edittext_cate = row.findViewById(R.id.edittext_cate);

        FoodModel foodModel = foods.get(position);
        text_id.setText(foodModel.getPID());
        edittext_name.setText(foodModel.getName());
        edittext_price.setText(foodModel.getPrice());
        edittext_desc.setText(foodModel.getDescription());
        edittext_cate.setText(foodModel.getCategory());

        return row;
    }
}
