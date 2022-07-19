package by.academy.Deal;

import java.util.Objects;

public class Vine extends Product{
    private String country;
    private double volume;
    private String type;


    public Vine(double price, String productName, String country, double volume, String type, int shopQuantity, int bagQuantity ) {
        super(price, productName, shopQuantity, bagQuantity);
        this.country = country;
        this.volume = volume;
        this.type = type;
    }

    @Override
    public double discount() {
        switch (country){
            case "Italy": return 5;
            case "Germany": return  4;
            case "Spain": return  3;
            case "France": return  2;
            default: return  10;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return Objects.hash(super.hashCode(), country, volume, type);
    }

    @Override
    public String toString() {
        return "Vine{" +
                "productName='" + productName + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }
}
