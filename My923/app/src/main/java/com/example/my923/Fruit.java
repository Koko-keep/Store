package com.example.my923;

public class Fruit {
    private String fruitName;
    private int fruitImage;

    public Fruit() {
    }

    public Fruit(String fruitName, int fruitImage) {
        this.fruitName = fruitName;
        this.fruitImage = fruitImage;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitImage() {
        return fruitImage;
    }

    public void setFruitImage(int fruitImage) {
        this.fruitImage = fruitImage;
    }
}
