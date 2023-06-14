package model;

import model.saving.Savable;
import model.store.Procurement;
import model.store.Sale;
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

    public String addNewToy(String name, int tType, int tRating, int tMaterial,
                            int length, int width, int height, String manufacturer, double cost) {
        ToyType toyType = ToyType.Doll;
        AgeRating ageRating = AgeRating.ZeroPlus;
        Material material = Material.Plush;
        switch (tType) {
            case 1 -> toyType = ToyType.Doll;
            case 2 -> toyType = ToyType.Puzzle;
            case 3 -> toyType = ToyType.Constructor;
            case 4 -> toyType = ToyType.ToyTool;
            case 5 -> toyType = ToyType.ToyCar;
            case 6 -> toyType = ToyType.BoardGame;
        }
        switch (tRating) {
            case 1 -> ageRating = AgeRating.ZeroPlus;
            case 2 -> ageRating = AgeRating.ThreePlus;
            case 3 -> ageRating = AgeRating.SevenPlus;
        }
        switch (tMaterial) {
            case 1 -> material = Material.Plush;
            case 2 -> material = Material.Plastic;
            case 3 -> material = Material.Wood;
            case 4 -> material = Material.PVC;
            case 5 -> material = Material.Porcelain;
            case 6 -> material = Material.Metal;
        }
        Toy toy = new Toy(name, toyType, ageRating, material, length, width, height, manufacturer, cost);
        this.toyStore.addNewToy(toy);
        return "Новый товар создан."  + "\n";
    }

    public String showToyInfo(int id) {
        return this.toyStore.showToyInfo(id);
    }

    public String showToysList() {
        return this.toyStore.showToysList();
    }

    public String addNewProcurement(int id, String supplier, int quantity) {
        Toy toy = (Toy) this.toyStore.getToy(id);
        if (toy != null) {
            Procurement procurement = new Procurement(id, supplier, quantity);
            this.toyStore.addNewProcurement(procurement);
            return "Поставка проведена." + "\n";
        }
        return "Товар с таким id отсутствует." + "\n";
    }

    public String addNewSale(int id, String bayer, int quantity) {
        Toy toy = (Toy) this.toyStore.getToy(id);
        if (toy != null) {
            Sale sale = new Sale(id, bayer, quantity);
            return this.toyStore.addNewSale(sale) + "\n";
        }
        return "Товар с таким id отсутствует." + "\n";
    }

    public String showAvailableToys() {
        return this.toyStore.showAvailableToys();
    }

    public String showAllProcurements() {
        return this.toyStore.showAllProcurements();
    }

    public String showAllSales() {
        return this.toyStore.showAllSales();
    }

    public String saveStore(String path) throws IOException {
        return serializing.saveObjectAs(this.toyStore, path);
    }

    public String loadStore(String path) {
        this.toyStore = serializing.loadObjectFrom(path);
        this.toyStore.setMaxCounters();
        return "Успешное восстановление из файла " + path + "\n";
    }
}
