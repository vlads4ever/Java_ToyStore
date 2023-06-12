package model.store;

import model.toy.Toy;
import model.toy.comparators.CompareByName;
import java.util.*;

public class ToyStore {
    private Set<Toy> toysSet;
    private Map<Integer, Integer> toysCount;

    public ToyStore(boolean newToyStore) {
        this.toysSet = new TreeSet<>(new CompareByName<Toy>());
        this.toysCount = new HashMap<Integer, Integer>();
    }

    public ToyStore(){
    }

    public void setToysSet(Set<Toy> toysSet) {
        this.toysSet = toysSet;
    }

    public Set<Toy> getToysSet(){
        return this.toysSet;
    }

    public void setToysCount(Map<Integer, Integer> toysCount) {
        this.toysCount = toysCount;
    }

    public Map<Integer, Integer> getToysCount() {
        return toysCount;
    }

    public void addNewProcurement(int id, int count) {
        if (this.toysCount.containsKey(id)) {
            int availableCount = this.toysCount.get(id);
            this.toysCount.put(id, availableCount + count);
        } else {
            this.toysCount.put(id, count);
        }
    }

    public String showAvailableToys() {
        StringBuilder output = new StringBuilder();
        for (Toy toy: this.toysSet) {
            int id = toy.getId();
            String name = toy.getName();
            output.append(String.format("id: %d %s %dшт. %.2fруб.",
                        id, name, this.toysCount.get(id), toy.getCost()) + "\n");
        }
        return output.toString();
    }

    public void addNewToy(Toy toy){
        this.toysSet.add(toy);
    }

    public Toy getToy(int id){
        for (Toy toy : this.toysSet) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public String saleToys(int id, int count){
        Toy toy = this.getToy(id);
        if (toy == null) {
            return "Товар с таким id отсутствует.";
        } else {
            int quantity = this.toysCount.get(id);
            if (quantity >= count) {
                int balance = quantity - count;
                if (balance == 0) {
                    this.toysCount.remove(id);
                } else {
                    this.toysCount.put(id, balance);
                }
                return String.format("Товар продан по цене %.2fруб. за штуку на сумму %.2fруб.",
                        toy.getCost(), count * toy.getCost());
            } else {
                return "Такого количества нет в наличии.";
            }
        }
    }

}
