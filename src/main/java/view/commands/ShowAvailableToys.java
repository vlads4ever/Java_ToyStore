package view.commands;

import view.View;

public class ShowAvailableToys implements Command {
    private View view;

    public ShowAvailableToys(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Игрушки в наличии.";
    }

    @Override
    public void execute() {
        this.view.showAvailableToys();
    }
}
