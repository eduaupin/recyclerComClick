package com.example.recyclerview.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.RecyclerViewOnClick;
import com.example.recyclerview.model.Animal;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private RecyclerViewOnClick listener;
    private List<Animal> animalList;

    public Adapter(List<Animal> animalLis, RecyclerViewOnClick listener) {
        this.animalList = animalLis;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Animal animal = animalList.get(i);
        viewHolder.bind(animal);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.metodoOnclick(animal);
            }
        });

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textViewNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
        }
        public void bind(Animal animal){
            textViewNome.setText(animal.getNomeAnimal());

            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), animal.getImagemAnimal()));
        }
    }



}
