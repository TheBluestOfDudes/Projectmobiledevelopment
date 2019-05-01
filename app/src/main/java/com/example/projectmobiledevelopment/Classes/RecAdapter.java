package com.example.projectmobiledevelopment.Classes;

import android.graphics.Color;
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

    private int selected_position  = RecyclerView.NO_POSITION;
    public static DogObject selectedDog;
    public static boolean selected = false;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View dogsView;

        public ViewHolder(View itemView){
            super(itemView);
            dogsView = itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            notifyItemChanged(selected_position);
            selected_position = getAdapterPosition();
            notifyItemChanged(selected_position);

            selectedDog = doglist.get(selected_position);
            selected = true;

            Log.d("Now", ((Integer)selected_position).toString());
            Log.d("Dog", selectedDog.dogName());
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
            ((ImageView)viewHolder.dogsView.findViewById(R.id.img_dogimage)).setImageBitmap(BitmapConverter.toBitmap(dog.image()));
        }
        else {
            ((TextView) viewHolder.dogsView.findViewById(R.id.txt_navn)).setText("" + dog.dogName());
        }

        if(selected_position == position) {
            viewHolder.dogsView.setBackgroundColor(Color.GREEN);
        }
        else{
            viewHolder.dogsView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount(){
        return doglist.size();
    }

}
