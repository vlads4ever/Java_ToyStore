package view.commands;

import view.View;

public class ShowToyInfo implements Command {
    private View view;

    public ShowToyInfo(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Информация об игрушке.";
    }

    @Override
    public void execute() {
        view.showToyInfo();
    }
}
