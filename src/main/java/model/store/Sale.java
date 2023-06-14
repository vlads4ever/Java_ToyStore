package model.store;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sale {
    private static int count;
    private int id;
    private int toyId;
    private String bayer;
    private int quantity;
    private String date;

    public Sale(int toyId, String bayer, int quantity, String date) {
        this.id = count++;
        this.toyId = toyId;
        this.bayer = bayer;
        this.quantity = quantity;
        if (date.equals("currentDate")) {
            Date currentDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.date = formatter.format(currentDate);
        } else {
            this.date = date;
        }
    }

    public Sale(int toyId, String bayer, int quantity) {
        this(toyId, bayer, quantity, "currentDate");
    }

    public Sale() {}

    public static void setCount(int count) {
        Sale.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public void setBayer(String bayer) {
        this.bayer = bayer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getToyId() {
        return toyId;
    }

    public String getBayer() {
        return bayer;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }
}
