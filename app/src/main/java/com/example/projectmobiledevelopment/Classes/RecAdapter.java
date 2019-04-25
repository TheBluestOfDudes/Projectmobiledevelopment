package com.example.projectmobiledevelopment.Classes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobiledevelopment.R;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    private List<DogObject> doglist;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView txt;

        public ViewHolder(View itemView){
            super(itemView);

            img = itemView.findViewById(R.id.img_dog);
            txt = itemView.findViewById(R.id.txt_navn);

        }
    }

    public RecAdapter(List<DogObject> dogs){
        doglist = dogs;
    }

    @Override
    public RecAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View dogView = inflater.inflate(R.layout.dog_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(dogView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecAdapter.ViewHolder viewHolder, int position){
        DogObject dog = doglist.get(position);
        TextView tv = viewHolder.txt;
        tv.setText(dog.dogName());
    }

    @Override
    public int getItemCount(){
        return doglist.size();
    }

}
