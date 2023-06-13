package presenter;

import model.Service;
import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void addNewToy(String name, int toyType, int ageRating, int material,
                          int length, int width, int height, String manufacturer, double cost) {
        this.view.print(this.service.addNewToy(name, toyType, ageRating, material,
                length, width, height, manufacturer, cost));
    }
    public void addNewProcurement(int id, String supplier, int quantity) {
        this.view.print(this.service.addNewProcurement(id, supplier, quantity));
    }
    public void showToyInfo(){}
    public void showToysList(){}
    public void showAvailableToys(){}
    public void showAllProcurements(){}
    public void saleToys(){}
    public void saveStore(){}
    public void loadStore(){}
}
