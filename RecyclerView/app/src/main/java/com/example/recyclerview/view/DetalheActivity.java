package com.example.recyclerview.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Animal;

import static com.example.recyclerview.view.MainActivity.ANIMAL_KEY;

public class DetalheActivity extends AppCompatActivity {
    private TextView txtNomeAnimal;
    private ImageView imagemAnimalDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        txtNomeAnimal = findViewById(R.id.txtNomeAnimal);
        imagemAnimalDetalhe = findViewById(R.id.imagemAnimalDetalhe);

        Intent intent = getIntent();
        if(getIntent() != null && intent.getExtras() != null){
            Bundle bundle = intent.getExtras();

            Animal animal = bundle.getParcelable(ANIMAL_KEY);

            txtNomeAnimal.setText(animal.getNomeAnimal());
            Drawable drawable = getResources().getDrawable(animal.getImagemAnimal());
            imagemAnimalDetalhe.setImageDrawable(drawable);
        }

    }
}
