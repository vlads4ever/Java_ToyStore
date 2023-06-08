package model;

import model.store.Procurement;
import model.store.ToyStore;
import model.toy.*;


import java.util.Set;

public class Service {
    private ToyStore<Toy> toyStore;

    public Service() {
        this.toyStore = new ToyStore<>();
    }

    public java.lang.String addNewToy(String name, String toyType, String ageRating, String material,
                                      int length, int width, int height, String manufacturer, double cost){
        Toy toy = new Toy(name, toyType, ageRating, material, length, width, height, manufacturer, cost);
        this.toyStore.addNewToy(toy);
        return "Новый товар создан.";
    }

    public java.lang.String showToyInfo(int id){
        return this.toyStore.getToy(id).toString();
    }

    public java.lang.String showToysList(){
        StringBuilder output = new StringBuilder();
        Set<Toy> toys = toyStore.getToysSet();
        if (toys.size() != 0) {
            for (Toy toy: toys) {
                output.append(java.lang.String.format("id: %d %s %.2f",
                        toy.getId(), toy.getName(), toy.getCost()) + "руб." + "\n");
            }
        } else {
            output.append("Список пуст." + "\n");
        }

        return output.toString();
    }

    public java.lang.String addNewProcurement(int id, java.lang.String supplier, int warehouseQuantity){
        Toy toy = this.toyStore.getToy(id);
        if (toy != null) {
            Procurement procurement = new Procurement<Toy>(toy, supplier, warehouseQuantity);
            this.toyStore.addNewProcurement(procurement);
            return "Поставка проведена.";
        }
        return "Товар с таким id отсутствует.";
    }

    public java.lang.String showAvailableToys(){
        return this.toyStore.getAvailableToys();
    }
}
