package view.commands;

import view.View;

public class AddNewSale implements Command {
    private View view;

    public AddNewSale(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Оформить продажу.";
    }

    @Override
    public void execute() {
        this.view.addNewSale();
    }
}
