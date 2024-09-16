package com.example.bazaza;

import java.util.Date;

public class Basa {
    int id, ClId;
    String categ;
    Date date;

    public Basa(int id, int clId, String categ, Date date) {
        this.id = id;
        ClId = clId;
        this.categ = categ;
        this.date = date;
    }

    public Basa(int id, int clId, java.sql.Date date, String categ) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClId() {
        return ClId;
    }

    public void setClId(int clId) {
        ClId = clId;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
