package view.commands;

import view.View;

import java.io.IOException;

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
    public void execute() throws IOException {
        this.view.saveStore();
    }
}
