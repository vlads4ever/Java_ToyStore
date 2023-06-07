package model.toy;

public interface Toys {
    public void setId(int id);
    public void setName(String name);
    public void setToyType(ToyType toyType);
    public void setAgeRating(AgeRating ageRating);
    public void setMaterial(Material material);
    public void setLength(int length);
    public void setWidth(int width);
    public void setHeight(int height);
    public void setManufacturer(String manufacturer);
    public void setCost(double cost);
    public int getId();
    public String getName();
    public ToyType getToyType();
    public AgeRating getAgeRating();
    public Material getMaterial();
    public int getLength();
    public int getWidth();
    public int getHeight();
    public String getManufacturer();
    public double getCost();
}
