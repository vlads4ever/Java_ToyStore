package model.store;

import model.toy.Toys;
import model.toy.comparators.CompareByName;
import java.util.*;

public class ToyStore<E extends Toys> {
    private Set<E> toysSet;
    private List<Procurement<E>> procurementList;

    public ToyStore(boolean flag) {
        this.toysSet = new TreeSet<>(new CompareByName<E>());
        this.procurementList = new ArrayList<>();
    }

    public ToyStore() {
    }

    public void setToysSet(List<E> toysSet) {
        this.toysSet = (Set<E>) toysSet;
    }

    public void setProcurementList(List<Procurement<E>> procurementList) {
        this.procurementList = procurementList;
    }

    public List<Procurement<E>> getProcurementList() {
        return procurementList;
    }
    public Set<E> getToysSet(){
        return this.toysSet;
    }

    public void addNewToy(E toy){
        this.toysSet.add(toy);
    }

    public E getToy(int id){
        for (E toy : this.toysSet) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public void addNewProcurement(Procurement<E> procurement){
        this.procurementList.add(procurement);
    }

    public String getAvailableToyInfo(int id){
        StringBuilder output = new StringBuilder();
        int shopQuantity = 0;
        int warehouseQuantity = 0;
        String toyName = "";
        double toyCost = 0;
        for (Procurement<E> procurement: this.procurementList) {
            if (procurement.getToy().getId() == id) {
                shopQuantity += procurement.getShopQuantity();
                warehouseQuantity += procurement.getWarehouseQuantity();
                toyName = procurement.getToy().getName();
                toyCost = procurement.getToy().getCost();
            }
        }
        if (toyName != "") {
            if (shopQuantity != 0 || warehouseQuantity != 0) {
                output.append(String.format("id: %d %s %.2f",
                        id, toyName, toyCost) + "руб." + "\n");
                output.append("В магазине: " + shopQuantity + "шт." + "\n");
                output.append("На складе: " + warehouseQuantity + "шт." + "\n");
            } else {
                output.append("Товар отсутствует.");
            }

        } else {
            output.append("Товар с таким id отсутствует.");
        }
        return output.toString();
    }

    public String showAvailableToys(){
        StringBuilder output = new StringBuilder();
        if (this.toysSet.size() != 0) {
            for (E toy: this.toysSet) {
                String toyInfo = this.getAvailableToyInfo(toy.getId());
                if (!toyInfo.equals("Товар отсутствует.")) {
                    output.append(toyInfo + "\n");
                }
            }
        } else {
            output.append("Товары отстутсвуют.");
        }
        return output.toString();
    }

    public String buyFromShop(int id){
        //TODO: Продать с полок магазина
        return "";
    }

    public String buyFromWarehouse(int id){
        //TODO: Продать со склада
        return "";
    }
}
