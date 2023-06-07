package model.toy;

import java.util.Objects;

public class Toy implements Toys{
    private static int count;
    private int id;
    private String name;
    private ToyType toyType;
    private AgeRating ageRating;
    private Material material;
    private int length;
    private int width;
    private int height;
    private String manufacturer;
    private double cost;

    public Toy(String name, ToyType toyType, AgeRating ageRating, Material material,
               int length, int width, int height, String manufacturer, double cost) {
        this.id = count++;
        this.name = name;
        this.toyType = toyType;
        this.ageRating = ageRating;
        this.material = material;
        this.length = length;
        this.width = width;
        this.height = height;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToyType(ToyType toyType) {
        this.toyType = toyType;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ToyType getToyType() {
        return toyType;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public Material getMaterial() {
        return material;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Наименование: '" + name + '\'' + '\n');
        output.append("Тип: " + toyType + '\n');
        output.append("Возрастной рейтинг: " + ageRating + '\n');
        output.append("Материал: " + material + '\n');
        output.append("Размеры (ДхШхВ): " + length + 'x' + width + 'x' + height + '\n');
        output.append("Производитель: '" + manufacturer + '\'' + '\n');
        output.append("Стоимость: " + cost + '\n');
        return output.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getMaterial(),
                this.getLength(), this.getWidth(), this.getHeight());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Toys toy) {
            if (toy.getName() != null &&
                    toy.getMaterial() != null &&
                    toy.getLength() != 0 &&
                    toy.getWidth() != 0 &&
                    toy.getHeight() != 0) {
                return this.getName().equals(toy.getName()) &&
                        this.getMaterial().equals(toy.getMaterial()) &&
                        this.getLength() == toy.getLength() &&
                        this.getWidth() == toy.getWidth() &&
                        this.getHeight() == toy.getHeight();
            }
        }
        return false;
    }
}
