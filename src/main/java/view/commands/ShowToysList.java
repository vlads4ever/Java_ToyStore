package view.commands;

import view.View;

public class ShowToysList implements Command {
    private View view;

    public ShowToysList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Справочник игрушек.";
    }

    @Override
    public void execute() {
        this.view.showToysList();
    }
}
