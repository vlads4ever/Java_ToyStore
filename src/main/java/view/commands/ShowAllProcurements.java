package view.commands;

import view.View;

public class ShowAllProcurements implements Command {
    private View view;

    public ShowAllProcurements(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Информация по поставкам.";
    }

    @Override
    public void execute() {
        this.view.showAllProcurements();
    }
}
