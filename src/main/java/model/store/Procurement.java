package model.store;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Procurement {
    private static int count;
    private int id;
    private int toyId;
    private String supplier;
    private int quantity;
    private String date;

    public Procurement(int toyId, String supplier, int quantity, String date) {
        this.id = count++;
        this.toyId = toyId;
        this.supplier = supplier;
        this.quantity = quantity;
        if (date.equals("currentDate")) {
            Date currentDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.date = formatter.format(currentDate);
        } else {
            this.date = date;
        }
    }

    public Procurement(int toyId, String supplier, int quantity) {
        this(toyId, supplier, quantity, "currentDate");
    }

    public Procurement() {}

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getToyId() {
        return toyId;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public static void setCount(int count) {
        Procurement.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
