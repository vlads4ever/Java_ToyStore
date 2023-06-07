package model.store;

import model.toy.Toys;

import java.util.ArrayList;
import java.util.List;

public class ToyStore<E extends Toys> {
    private List<E> shop;
    private List<E> warehouse;

    public ToyStore() {
        this.shop = new ArrayList<>();
        this.warehouse = new ArrayList<>();
    }

    public String addToShop(E toy){
        this.shop.add(toy);
        return "Товар выставлен на продажу.";
    }

    public String removeFromShop(int id){
        for (E toy: this.shop) {
            if (toy.getId() == id) {
                this.shop.remove(toy);
                return "Товар снят с продажи.";
            }
        }
        return "Товар не обнаружен";
    }

    public String addToWarehouse(E toy){
        this.warehouse.add(toy);
        return "Товар размещен на складе";
    }

    public String removeFromWarehouse(int id){
        for (E toy: this.warehouse) {
            if (toy.getId() == id) {
                this.shop.remove(toy);
                return "Товар удален со склада";
            }
        }
        return "Товар не обнаружен";
    }

    private int getQuantityAt(List<E> list, E toy){
        int quantity = 0;
        for (E item: list) {
            if (item.equals(toy)) {
                quantity++;
            }
        }
        return quantity;
    }

    public int toyQuantityAtShop(E toy){
        return getQuantityAt(this.shop, toy);
    }

    public int toyQuantityAtWarehouse(E toy){
        return getQuantityAt(this.warehouse, toy);
    }

    public String getToyInfo(int id){
        E toy = this.getToyAt(this.shop, id);
        if (toy != null){
            return toy.toString();
        }
        toy = this.getToyAt(this.warehouse, id);
        if (toy != null){
            return toy.toString();
        }
        return "Товар не обнаружен";
    }

    private E getToyAt(List<E> list, int id){
        for (E toy: list) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public String moveFromShopToWarehouse(int id){
        E toy = this.getToyAt(this.shop, id);
        if (toy != null) {
            this.removeFromShop(id);
            return this.addToWarehouse(toy);
        }
        return "Товар не обнаружен";
    }

    public String moveFromWarehouseToShop(int id){
        E toy = this.getToyAt(this.warehouse, id);
        if (toy != null) {
            this.removeFromWarehouse(id);
            return this.addToShop(toy);
        }
        return "Товар не обнаружен";
    }

    public String generalReport(){
        StringBuilder output = new StringBuilder();
        // TODO: Сделать общий отчет по игрушкам на складе и на полках
        return output.toString();
    }
}
