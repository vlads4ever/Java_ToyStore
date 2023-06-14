package model.toy;

import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;

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

    public Toy(int id, String name, ToyType toyType, AgeRating ageRating, Material material,
               int length, int width, int height, String manufacturer, double cost) {
        this.id = id;
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

    public Toy(String name, ToyType toyType, AgeRating ageRating, Material material,
               int length, int width, int height, String manufacturer, double cost) {
        this(count++, name, toyType, ageRating, material, length, width, height, manufacturer, cost);
    }

    public Toy() {

    }

    public static void setCount(int count) {
        Toy.count = count;
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

    public java.lang.String getName() {
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

    public java.lang.String getManufacturer() {
        return manufacturer;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public java.lang.String toString() {
        String tType = "Кукла";
        String tRating = "0+";
        String tMaterial = "Плюш";
        switch (toyType) {
            case Doll -> tType = "Кукла";
            case Puzzle -> tType = "Пазл";
            case Constructor -> tType = "Конструктор";
            case ToyTool -> tType = "Игрушечный инструмент";
            case ToyCar -> tType = "Машинка";
            case BoardGame -> tType = "Настольная игра";
        }
        switch (ageRating) {
            case ZeroPlus -> tRating = "0+";
            case ThreePlus -> tRating = "3+";
            case SevenPlus -> tRating = "7+";
        }
        switch (material) {
            case Plush -> tMaterial = "Плюш";
            case Plastic -> tMaterial = "Пластик";
            case Wood -> tMaterial = "Дерево";
            case PVC -> tMaterial = "ПВХ";
            case Porcelain -> tMaterial = "Фарфор";
            case Metal -> tMaterial = "Метал";
        }
        StringBuilder output = new StringBuilder();
        output.append("Наименование: '" + name + '\'' + '\n');
        output.append("Тип: " + tType + '\n');
        output.append("Возрастной рейтинг: " + tRating + '\n');
        output.append("Материал: " + tMaterial + '\n');
        output.append("Размеры (ДхШхВ): " + length + 'x' + width + 'x' + height + '\n');
        output.append("Производитель: '" + manufacturer + '\'' + '\n');
        output.append(String.format("Стоимость: %.2f", cost) + "руб." + '\n');
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
