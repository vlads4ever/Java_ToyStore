package model.toy;

public interface Toys {
    public void setId(int id);
    public void setName(String name);
    public void setToyType(String string);
    public void setAgeRating(String ageRating);
    public void setMaterial(String material);
    public void setLength(int length);
    public void setWidth(int width);
    public void setHeight(int height);
    public void setManufacturer(String manufacturer);
    public void setCost(double cost);
    public int getId();
    public String getName();
    public String getToyType();
    public String getAgeRating();
    public String getMaterial();
    public int getLength();
    public int getWidth();
    public int getHeight();
    public String getManufacturer();
    public double getCost();
}
