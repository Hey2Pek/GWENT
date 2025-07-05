package com.example.gwent;

public class Card {
    private String name;
    private int power;
    private String range;
    private String type;

    public Card(String name, int power, String range, String type) {
        this.name = name;
        this.power = power;
        this.range = range;
        this.type = type;
    }

    public Card(String name, int power, String range) {
        this(name, power, range, "NORMAL");
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getRange() {
        return range;
    }

    public String getType() {
        return type;
    }

    public boolean isSpy() {
        return type.equals("SPY");
    }

    public boolean isWeather() {
        return type.equals("WEATHER");
    }

    public boolean isHero() {
        return type.equals("HERO");
    }
}
