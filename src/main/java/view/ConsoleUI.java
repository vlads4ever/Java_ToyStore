package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private MainMenu mainMenu;
    private Scanner scanner;
    private boolean run;

    public ConsoleUI(Presenter presenter, MainMenu mainMenu, Scanner scanner, boolean run) {
        this.scanner = new Scanner(System.in);
        this.run = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        this.print("Добро пожаловать в Магазин Игрушек!");
        this.print("************************************");
        this.print("");
        this.print("Вы можете наполнить магазин игрушками вручную или загрузить" + "\n" +
                "из файла ToyStore.json, прилагаемого к проекту." + "\n");
        while (run) {
            this.printMenu();
            this.execute();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printMenu() {
        this.print(mainMenu.print());
    }

    @Override
    public void exit() {
        run = false;
        System.out.println("Завершение работы.");
    }

    private void execute() throws IOException, ClassNotFoundException {
        System.out.print("Введите номер команды> ");
        String userInput = scanner.nextLine();
        if (checkTextForInt(userInput)){
            int numCommand = Integer.parseInt(userInput);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private int inputInt(String message) {
        int number = 0;
        boolean run = true;
        while (run) {
            try
            {
                number = Integer.parseInt(this.inputString(message).trim());
                run = false;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Введено некорректное значение.");
            }
        }
        return number;
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            this.print("Введено некорректное значение.");
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            this.print("Введено некорректное значение.");
            return false;
        }
    }

    @Override
    public void addNewToy() {
        this.print("Собираем информацию о новой игрушке...");
        String toyName = this.inputString("Введите название игрушки: ");
        this.print("Доступные типы игрушек: 1:'Кукла', 2:'Пазл', 3:'Конструктор', 4:'Игрушечный инструмент', " +
                "5:'Машинка', 6:'Настольная игра'");
        int toyType = this.inputInt("Укажите тип игрушки: ");
        this.print("Доступные варианты возрастного рейтинга: 1:'0+', 2:'3+', 3:'7+'");
        int ageRating = this.inputInt("Укажите возрастной рейтинг: ");
        this.print("Доступные варианты материала: 1:'Плюш', 2:'Пластик', 3:'Дерево', 4:'ПВХ', 5:'Фарфор', " +
                "6:'Метал'");
        int material = this.inputInt("Укажите материал: ");
//        int length, int width, int height, String manufacturer, double cost


    }

    @Override
    public void addNewProcurement() {

    }

    @Override
    public void showToyInfo() {

    }

    @Override
    public void showToysList() {

    }

    @Override
    public void showAvailableToys() {

    }

    @Override
    public void showAllProcurements() {

    }

    @Override
    public void saleToys() {

    }

    @Override
    public void saveStore() {

    }

    @Override
    public void loadStore() {

    }
}
