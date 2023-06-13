package view.commands;

import view.View;

public class LoadStore implements Command {
    private View view;

    public LoadStore(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Загрузить базу из файла JSON.";
    }

    @Override
    public void execute() {
        this.view.loadStore();
    }
}
