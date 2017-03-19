package com.example.jasonjinsooyoo.freefindr;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.jasonjinsooyoo.freefindr.ENUM.Categories;

import java.io.Serializable;

/**
 * Created by jasonjinsooyoo on 2017-03-18.
 */

public class Event{

    private String name;
    private int id;
    private double lat;
    private double lon;
    private Categories type;
    private String description;


    public Event(String name) {
        this.name = name;
    }

    // Setters
    public void setID(int id) {
        this.id = id;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public void setLon(double lon) {
        this.lon = lon;
    }
    public void setType(Categories type) {
        this.type = type;
    }
    public void setDesc(String description) {
        this.description = description;
    }

    // Getters
    public int getID() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getType() {
        if (type==Categories.ART) return "ART";
        if (type==Categories.BUSINESS) return "BUSINESS";
        if (type==Categories.FOOD) return "FOOD";
        if (type==Categories.GAME) return "GAME";
        if (type==Categories.HEALTH) return "HEALTH";
        if (type==Categories.OTHER) return "OTHER";
        if (type==Categories.SOCIAL) return "SOCIAL";
        if (type==Categories.SPORTS) return "SPORTS";
        if (type==Categories.TECH) return "TECH";
        return null;
    }

    public double getLat() { return lat; }
    public double getLon() { return lon; }

    // Two events are equal if and only if their id are the same
    @Override
    public boolean equals(Object o) {
        if (o==null || o.getClass()!=this.getClass()) return false;
        Event ye = (Event) o;
        return ye.id == id;
    }
    @Override
    public int hashCode() {
        return id;
    }

}
