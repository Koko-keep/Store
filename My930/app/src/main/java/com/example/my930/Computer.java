package com.example.my930;

public class Computer {
    private int Imageid;
    private String name;
    private String Detalied;
    private String Money;

    public Computer(int imageid, String name, String detalied, String money) {
        Imageid = imageid;
        this.name = name;
        Detalied = detalied;
        Money = money;
    }

    public Computer() {
    }

    public int getImageid() {
        return Imageid;
    }

    public void setImageid(int imageid) {
        Imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetalied() {
        return Detalied;
    }

    public void setDetalied(String detalied) {
        Detalied = detalied;
    }

    public String  getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = Money;
    }
}
