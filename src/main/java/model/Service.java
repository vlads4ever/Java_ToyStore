package model;

import model.saving.Savable;
import model.store.Procurement;
import model.store.ToyStore;
import model.toy.*;
import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;


import java.io.*;
import java.util.Set;

public class Service {
    private Savable serializing;
    private ToyStore toyStore;

    public Service(Savable serializing) {
        this.toyStore = new ToyStore(true);
        this.serializing = serializing;
    }

    public String addNewToy(String name, ToyType toyType, AgeRating ageRating, Material material,
                                      int length, int width, int height, String manufacturer, double cost) {
        Toy toy = new Toy(name, toyType, ageRating, material, length, width, height, manufacturer, cost);
        this.toyStore.addNewToy(toy);
        return "Новый товар создан.";
    }

    public String showToyInfo(int id) {
        return this.toyStore.getToy(id).toString();
    }

    public String showToysList() {
        StringBuilder output = new StringBuilder();
        Set<Toy> toys = toyStore.getToysSet();
        if (toys.size() != 0) {
            for (Toy toy: toys) {
                output.append(String.format("id: %d %s %.2fруб.",
                        toy.getId(), toy.getName(), toy.getCost()) + "\n");
            }
        } else {
            output.append("Список пуст." + "\n");
        }
        return output.toString();
    }

    public String addNewProcurement(int id, String supplier, int quantity) {
        Toy toy = (Toy) this.toyStore.getToy(id);
        if (toy != null) {
            Procurement procurement = new Procurement(id, supplier, quantity);
            this.toyStore.addNewProcurement(procurement);
            return "Поставка проведена.";
        }
        return "Товар с таким id отсутствует.";
    }

    public String showAvailableToys() {
        return this.toyStore.showAvailableToys();
    }

    public String showAllProcurements() {
        return this.toyStore.showAllProcurements();
    }

    public String saleToys(int id, int quantity) {
        return this.toyStore.saleToys(id, quantity);
    }

    public String saveStore(String path) throws IOException {
        return serializing.saveObjectAs(this.toyStore, path);
    }

    public String loadStore(String path) {
        this.toyStore = serializing.loadObjectFrom(path);
        this.toyStore.setMaxCounters();
        return "Успешное восстановление из файла " + path;
    }
}
