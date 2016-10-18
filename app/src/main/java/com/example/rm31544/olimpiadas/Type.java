package com.example.rm31544.olimpiadas;

/**
 * Created by rm31544 on 17/10/2016.
 */
public class Type {
    private int cod;
    private String name;

    @Override
    public String toString() {
        return name;
    }

    public Type(int cod, String name) {
        this.cod = cod;
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
