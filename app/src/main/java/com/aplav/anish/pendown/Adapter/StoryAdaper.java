package com.aplav.anish.pendown.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aplav.anish.pendown.Item.StoryItem;
import com.aplav.anish.pendown.R;

import java.util.ArrayList;

/**
 * Created by anish on 22-01-2017.
 */

public class StoryAdaper extends RecyclerView.Adapter<StoryAdaper.MyViewHolder> {


    ArrayList<StoryItem>list;
    public StoryAdaper(ArrayList<StoryItem> stories) {

        this.list = stories;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        StoryItem item = list.get(position);
        holder.date.setText(item.date);
        holder.story.setText(item.story);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView story;
        RelativeLayout item;
        public MyViewHolder(View itemView) {
            super(itemView);
            date = (TextView)itemView.findViewById(R.id.story_date);
            story = (TextView)itemView.findViewById(R.id.story_lines);
            item = (RelativeLayout)itemView.findViewById(R.id.item_story);
        }
    }
}
