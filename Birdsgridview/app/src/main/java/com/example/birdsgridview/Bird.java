package com.example.birdsgridview;

public class Bird {
    private String Name;
    private int Image;

    public Bird(String name, int image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return Image;
    }
}
