package com.example.projectmobiledevelopment.Classes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectmobiledevelopment.R;
import com.example.projectmobiledevelopment.Utils.BitmapConverter;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    private List<DogObject> doglist;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private View dogsView;

        public ViewHolder(View itemView){
            super(itemView);
            dogsView = itemView;
        }
    }

    public RecAdapter(List<DogObject> dogs){
        doglist = dogs;

        for (DogObject f: doglist) {
            Log.d("Find problem", "RecAdapter: " + f.dogName());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecAdapter.ViewHolder viewHolder, int position){
        final DogObject dog = doglist.get(position);
        if(dog.image() != null){
            ((TextView) viewHolder.dogsView.findViewById(R.id.txt_navn)).setText("" + dog.dogName());
            ((ImageView)viewHolder.dogsView.findViewById(R.id.img_dog)).setImageBitmap(BitmapConverter.toBitmap(dog.image()));
        }
        else {
            ((TextView) viewHolder.dogsView.findViewById(R.id.txt_navn)).setText("" + dog.dogName());
        }
    }

    @Override
    public int getItemCount(){
        return doglist.size();
    }

}
