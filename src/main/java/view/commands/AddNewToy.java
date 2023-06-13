package view.commands;

import view.View;

public class AddNewToy implements Command{
    private View view;

    public AddNewToy(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Завести новую игрушку.";
    }

    @Override
    public void execute() {
        this.view.addNewToy();
    }
}
