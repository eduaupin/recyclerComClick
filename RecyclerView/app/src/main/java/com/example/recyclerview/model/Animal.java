package com.example.recyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    //atributos
    private int imagemAnimal;
    private String nomeAnimal;

    //Construtor

    public Animal() {
    }

    public Animal(int imagemAnimal, String nomeAnimal) {
        this.imagemAnimal = imagemAnimal;
        this.nomeAnimal = nomeAnimal;
    }

    //getters and setters

    protected Animal(Parcel in) {
        imagemAnimal = in.readInt();
        nomeAnimal = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public int getImagemAnimal() {
        return imagemAnimal;
    }

    public void setImagemAnimal(int imagemAnimal) {
        this.imagemAnimal = imagemAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagemAnimal);
        parcel.writeString(nomeAnimal);
    }
}
