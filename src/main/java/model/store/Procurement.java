package model.store;

import model.toy.Toys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Procurement<E extends Toys> {
    private static int count;
    private int id;
    private E toy;
    private String supplier;
    private int shopQuantity;
    private int warehouseQuantity;
    private String date;

    public Procurement(E toy, String supplier, int shopQuantity, int warehouseQuantity, String date) {
        this.id = count++;
        this.toy = toy;
        this.shopQuantity = shopQuantity;
        this.warehouseQuantity = warehouseQuantity;
        this.supplier = supplier;
        if (date.equals("currentDate")) {
            Date currentDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.date = formatter.format(currentDate);
        } else {
            this.date = date;
        }
    }

    public Procurement(E toy, String supplier, int warehouseQuantity) {
        this(toy, supplier, 0, warehouseQuantity, "currentDate");
    }

    public int getId() {
        return id;
    }

    public E getToy() {
        return toy;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getShopQuantity() {
        return shopQuantity;
    }

    public int getWarehouseQuantity() {
        return warehouseQuantity;
    }

    public void setToy(E toy) {
        this.toy = toy;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setShopQuantity(int shopQuantity) {
        this.shopQuantity = shopQuantity;
    }

    public void setWarehouseQuantity(int warehouseQuantity) {
        this.warehouseQuantity = warehouseQuantity;
    }
}
