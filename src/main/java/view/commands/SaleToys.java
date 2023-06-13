package view.commands;

import view.View;

public class SaleToys implements Command {
    private View view;

    public SaleToys(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Продать игрушку.";
    }

    @Override
    public void execute() {
        view.saleToys();
    }
}
