package presenter;

import model.Service;
import view.View;

import java.io.IOException;

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

    public void addNewSale(int id, String bayer, int quantity) {
        this.view.print(this.service.addNewSale(id, bayer, quantity));
    }

    public void showToyInfo(int id){
        this.view.print(this.service.showToyInfo(id));
    }

    public void showToysList(){
        this.view.print(this.service.showToysList());
    }

    public void showAvailableToys(){
        this.view.print(this.service.showAvailableToys());
    }

    public void showAllProcurements(){
        this.view.print(this.service.showAllProcurements());
    }

    public void showAllSales(){
        this.view.print(this.service.showAllSales());
    }

    public void saveStore(String path) throws IOException {
        this.view.print(this.service.saveStore(path));
    }

    public void loadStore(String path){
        this.view.print(this.service.loadStore(path));
    }
}
