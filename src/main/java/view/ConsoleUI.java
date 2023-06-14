package view;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static String WRONG_VALUE = "Введено некорректное значение.";
    private Presenter presenter;
    private MainMenu mainMenu;
    private Scanner scanner;
    private boolean run;

    public ConsoleUI() {
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
            try {
                number = Integer.parseInt(this.inputString(message).trim());
                run = false;
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_VALUE);
            }
        }
        return number;
    }

    private double inputDouble(String message) {
        double number = 0;
        boolean run = true;
        while (run) {
            try {
                number = Double.parseDouble(this.inputString(message).trim());
                run = false;
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_VALUE);
            }
        }
        return number;
    }

    public int inputEnumerates(String message, int value) {
        int checkingValue = 0;
        boolean run = true;
        while (run) {
            checkingValue = this.inputInt(message);
            if (checkingValue >= 0 && checkingValue <= value) {
                return checkingValue;
            } else {
                this.print(WRONG_VALUE);
            }
        }
        return checkingValue;
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            this.print(WRONG_VALUE);
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            this.print(WRONG_VALUE);
            return false;
        }
    }

    @Override
    public void addNewToy() {
        this.print("Заводим новую игрушку...");
        String toyName = this.inputString("Введите название игрушки: ");
        this.print("Доступные типы игрушек: 1:'Кукла', 2:'Пазл', 3:'Конструктор', 4:'Игрушечный инструмент', " +
                "5:'Машинка', 6:'Настольная игра'");
        int toyType = this.inputEnumerates("Укажите тип игрушки (от 0 до 6): ", 6);
        this.print("Доступные варианты возрастного рейтинга: 1:'0+', 2:'3+', 3:'7+'");
        int ageRating = this.inputEnumerates("Укажите возрастной рейтинг (от 0 до 3): ", 3);
        this.print("Доступные варианты материала: 1:'Плюш', 2:'Пластик', 3:'Дерево', 4:'ПВХ', 5:'Фарфор', " +
                "6:'Метал'");
        int material = this.inputEnumerates("Укажите материал (от 0 до 6): ", 6);
        int length = this.inputInt("Укажите длину в мм.: ");
        int width = this.inputInt("Укажите ширину в мм.: ");
        int height = this.inputInt("Укажите высоту в мм.: ");
        String manufacturer = this.inputString("Укажите изготовителя: ");
        double cost = this.inputDouble("Укажите цену: ");
        this.presenter.addNewToy(toyName, toyType, ageRating, material,
                length, width, height, manufacturer, cost);
    }

    @Override
    public void addNewProcurement() {
        this.print("Оформляем новую поставку...");
        int id = this.inputInt("Введите id игрушки: ");
        String supplier = this.inputString("Введите поставщика: ");
        int quantity = this.inputInt("Введите количество товара: ");
        this.presenter.addNewProcurement(id, supplier, quantity);
    }

    @Override
    public void addNewSale() {
        this.print("Оформляем новую продажу...");
        int id = this.inputInt("Введите id игрушки: ");
        String bayer = this.inputString("Введите покупателя: ");
        int quantity = this.inputInt("Введите количество товара: ");
        this.presenter.addNewSale(id, bayer, quantity);
    }

    @Override
    public void showToyInfo() {
        this.print("Подготовка информации об игрушке...");
        int id = this.inputInt("Введите id игрушки: ");
        this.print("---Информация об игрушке---");
        this.presenter.showToyInfo(id);
    }

    @Override
    public void showToysList() {
        this.print("---Справочник игрушек---");
        this.presenter.showToysList();
    }

    @Override
    public void showAvailableToys() {
        this.print("---Игрушки в наличии---");
        this.presenter.showAvailableToys();
    }

    @Override
    public void showAllProcurements() {
        this.print("---Отчет по закупкам---");
        this.presenter.showAllProcurements();
    }

    @Override
    public void showAllSales() {
        this.print("---Отчет по продажам---");
        this.presenter.showAllSales();
    }

    @Override
    public void saveStore() throws IOException {
        this.print("Подготовка к сохранению...");
        String path = this.inputString("Введите название файла (без расширения): ");
        this.presenter.saveStore(path + ".json");
    }

    @Override
    public void loadStore() {
        this.print("Подготовка к загрузке...");
        String path = this.inputString("Введите название файла (без расширения): ");
        this.presenter.loadStore(path + ".json");
    }
}
