package com.example.ordersystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ToDoAdapter extends ArrayAdapter<ToDo> {

    private Context context;
    private int resource;
    List<ToDo> todos;

    ToDoAdapter(Context context, int resource, List<ToDo> todos){
        super(context,resource,todos);
        this.context = context;
        this.resource = resource;
        this.todos = todos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        ImageView imageView1 = row.findViewById(R.id.pizza111);
        TextView title = row.findViewById(R.id.title);
        TextView prices = row.findViewById(R.id.prices);
        ImageView imageView = row.findViewById(R.id.onGoing);


        // todos [obj1,obj2,obj3]
        ToDo toDo = todos.get(position);
        imageView1.setVisibility(row.VISIBLE);
        title.setText(toDo.getTitle());
        prices.setText(toDo.getDescription());
        imageView.setVisibility(row.INVISIBLE);

        if(toDo.getFinished() > 0){
            imageView.setVisibility(View.VISIBLE);
        }
        return row;
    }
}
