package com.example.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CateAdapter extends ArrayAdapter {
    private Context context;
    private  int resource;
    List<CateModel> cates;
    CateAdapter(Context context, int resource, List<CateModel> cates){
        super(context, resource,cates);
        this.context =context;
        this.resource =resource;
        this.cates = cates;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView txt_id = row.findViewById(R.id.txt_id);
        TextView txt_name = row.findViewById(R.id.txt_name);


        CateModel cateModel = cates.get(position);
        txt_id.setText(cateModel.getCID());
        txt_name.setText(cateModel.getCname());


        return row;
    }
}
