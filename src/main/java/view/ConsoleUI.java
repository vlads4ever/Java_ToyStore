package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private MainMenu mainMenu;
    private Scanner scanner;
    private boolean run;

    @Override
    public void start() {
        this.scanner = new Scanner(System.in);
        this.run = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {

    }

    @Override
    public void print(String text) {

    }

    @Override
    public void printMenu() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void addNewToy(String name, String toyType, String ageRating, String material, int length, int width, int height, String manufacturer, double cost) {

    }

    @Override
    public void addNewProcurement(int id, int quantity) {

    }

    @Override
    public void showToyInfo(int id) {

    }

    @Override
    public void showToysList() {

    }

    @Override
    public void showAvailableToys() {

    }

    @Override
    public void saleToys(int id, int quantity) {

    }

    @Override
    public void saveStore(String path) {

    }

    @Override
    public void loadStore(String path) {

    }
}
