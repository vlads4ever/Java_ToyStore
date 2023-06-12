package model.store;

import model.toy.Toy;
import model.toy.comparators.CompareByName;
import java.util.*;

public class ToyStore {
    private Set<Toy> toysSet;
    private Map<Integer, Integer> toysQuantity;
    private List<Procurement> toysProcurements;

    public ToyStore(boolean newToyStore) {
        this.toysSet = new TreeSet<>(new CompareByName<Toy>());
        this.toysQuantity = new HashMap<Integer, Integer>();
        this.toysProcurements = new ArrayList<>();
    }

    public ToyStore() {
    }

    public void setToysSet(Set<Toy> toysSet) {
        this.toysSet = toysSet;
    }

    public void setToysQuantity(Map<Integer, Integer> toysQuantity) {
        this.toysQuantity = toysQuantity;
    }

    public void setToysProcurements(List<Procurement> toysProcurements) {
        this.toysProcurements = toysProcurements;
    }

    public Set<Toy> getToysSet() {
        return this.toysSet;
    }

    public Map<Integer, Integer> getToysQuantity() {
        return toysQuantity;
    }

    public List<Procurement> getToysProcurements() {
        return toysProcurements;
    }

    public void setMaxCounters() {
        int toyMaxId = 0;
        for (Toy toy: this.toysSet) {
            if (toy.getId() > toyMaxId) {
                toyMaxId = toy.getId();
            }
        }
        Toy.setCount(toyMaxId + 1);

        int procurementMaxId = 0;
        for (Procurement procurement: this.toysProcurements) {
            if (procurement.getId() > procurementMaxId) {
                procurementMaxId = procurement.getId();
            }
        }
        Procurement.setCount(procurementMaxId + 1);
    }

    public void addNewProcurement(Procurement procurement) {
        int toyId = procurement.getId();
        int quantity = procurement.getQuantity();
        if (this.toysQuantity.containsKey(toyId)) {
            int availableCount = this.toysQuantity.get(toyId);
            this.toysQuantity.put(toyId, availableCount + quantity);
        } else {
            this.toysQuantity.put(toyId, quantity);
        }
        this.toysProcurements.add(procurement);
    }

    public String showAllProcurements() {
        StringBuilder output = new StringBuilder();
        for (Procurement procurement: this.toysProcurements) {
            String toyName = this.getToy(procurement.getToyId()).getName();
            output.append("id: " + procurement.getId() + " " + procurement.getDate() + " " + toyName + " " +
                    procurement.getQuantity() + "шт. " + "Поставщик: " + procurement.getSupplier() + "\n");
        }
        return output.toString();
    }

    public String showAvailableToys() {
        StringBuilder output = new StringBuilder();
        for (Toy toy: this.toysSet) {
            int id = toy.getId();
            String name = toy.getName();
            output.append(String.format("id: %d %s %dшт. %.2fруб.",
                        id, name, this.toysQuantity.get(id), toy.getCost()) + "\n");
        }
        return output.toString();
    }

    public void addNewToy(Toy toy) {
        this.toysSet.add(toy);
    }

    public Toy getToy(int id) {
        for (Toy toy : this.toysSet) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public String saleToys(int id, int count) {
        Toy toy = this.getToy(id);
        if (toy == null) {
            return "Товар с таким id отсутствует.";
        } else {
            int quantity = this.toysQuantity.get(id);
            if (quantity >= count) {
                int balance = quantity - count;
                if (balance == 0) {
                    this.toysQuantity.remove(id);
                } else {
                    this.toysQuantity.put(id, balance);
                }
                return String.format("Товар %s продан по цене %.2fруб. за штуку на сумму %.2fруб.",
                        toy.getName(), toy.getCost(), count * toy.getCost());
            } else {
                return "Такого количества нет в наличии.";
            }
        }
    }
}
