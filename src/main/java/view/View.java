package view;


import presenter.Presenter;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
    void print(String text);
    void printMenu();
    void exit();
    void addNewToy(String name, String toyType, String ageRating, String material,
                   int length, int width, int height, String manufacturer, double cost);
    void addNewProcurement(int id, int quantity);
    void showToyInfo(int id);
    void showToysList();
    void showAvailableToys();
    void saleToys(int id, int quantity);
    void saveStore(String path);
    void loadStore(String path);
}
