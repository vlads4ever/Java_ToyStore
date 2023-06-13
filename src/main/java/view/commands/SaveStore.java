package view.commands;

import view.View;

public class SaveStore implements Command {
    private View view;

    public SaveStore(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранить базу в файл JSON.";
    }

    @Override
    public void execute() {
        view.saveStore();
    }
}
