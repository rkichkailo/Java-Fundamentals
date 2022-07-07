package by.academy.Deal;

import java.util.Objects;

public class Vine extends Product{

    private String country;
    private int volume;
    private String color;


    public Vine(double price, String productName, int quantity, boolean isTax, String country, int volume, String color) {
        super(price, productName, quantity, isTax);
        this.country = country;
        this.volume = volume;
        this.color = color;
    }

    @Override
    public double discount() {
        switch (country){
            case "Italy": return price * 0.01;
            case "Germany": return  price * 0.02;
            case "Spain": return  price * 0.03;
            case "France": return  price * 0.04;
            default: return  price * 0.05;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vine vine = (Vine) o;
        return volume == vine.volume && country.equals(vine.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, volume);
    }

    @Override
    public String toString() {
        return "Vine{" +
                ", country='" + country + '\'' +
                ", volume=" + volume +
                '}';
    }
}
