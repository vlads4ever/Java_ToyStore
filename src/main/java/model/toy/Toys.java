package model.toy;

import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;

public interface Toys {
    void setId(int id);
    void setName(String name);
    void setToyType(ToyType toyType);
    void setAgeRating(AgeRating ageRating);
    void setMaterial(Material material);
    void setLength(int length);
    void setWidth(int width);
    void setHeight(int height);
    void setManufacturer(String manufacturer);
    void setCost(double cost);
    int getId();
    String getName();
    ToyType getToyType();
    AgeRating getAgeRating();
    Material getMaterial();
    int getLength();
    int getWidth();
    int getHeight();
    String getManufacturer();
    double getCost();
}
