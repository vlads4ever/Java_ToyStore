package view;

import presenter.Presenter;
import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void setPresenter(Presenter presenter);
    void print(String text);
    void printMenu();
    void exit();
    void addNewToy();
    void addNewProcurement();
    void addNewSale();
    void showToyInfo();
    void showToysList();
    void showAvailableToys();
    void showAllProcurements();
    void showAllSales();
    void saveStore() throws IOException;
    void loadStore();
}
