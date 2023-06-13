package view.commands;

import view.View;

public class AddNewProcurement implements Command {
    private View view;

    public AddNewProcurement(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Оформить поставку.";
    }

    @Override
    public void execute() {
        view.addNewProcurement();
    }
}
