package com.example.ordersystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedbackAdapter extends ArrayAdapter<Feedback>{

    private Context context;
    private int resource;
    List<Feedback> feedbacks;

    FeedbackAdapter(Context context, int resource, List<Feedback> feedbacks){
        super(context,resource,feedbacks);
        this.context = context;
        this.resource = resource;
        this.feedbacks = feedbacks;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView title2 = row.findViewById(R.id.title2);
        TextView description2 = row.findViewById(R.id.despript2);


        // todos [obj1,obj2,obj3]
        Feedback feedBack = feedbacks.get(position);
        title2.setText(feedBack.getTitle2());
        description2.setText(feedBack.getDescription2());
        return row;
    }
}
