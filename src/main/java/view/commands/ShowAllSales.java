package view.commands;

import view.View;

public class ShowAllSales implements Command {
    private View view;

    public ShowAllSales(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Информация по продажам.";
    }

    @Override
    public void execute() {
        this.view.showAllSales();
    }
}
