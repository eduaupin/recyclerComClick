package com.example.recyclerview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.Adapter.Adapter;
import com.example.recyclerview.R;
import com.example.recyclerview.interfaces.RecyclerViewOnClick;
import com.example.recyclerview.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recyclerView;
    private Adapter adapter;
    public static final String ANIMAL_KEY = "animal";

    List<Animal> animalList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewAnimais);

        adapter = new Adapter(animalpopular(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public List<Animal> animalpopular(){
        animalList.add(new Animal(R.drawable.cachorro, "Cachorro"));
        animalList.add(new Animal(R.drawable.gato, "Gato"));
        animalList.add(new Animal(R.drawable.leao, "Leão"));

        return animalList;
    }

    @Override
    public void metodoOnclick(Animal animal) {
        Intent intent = new Intent(this, DetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ANIMAL_KEY, animal);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
