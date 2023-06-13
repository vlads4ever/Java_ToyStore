package view;

import view.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new Exit(view));
        commandList.add(new AddNewToy(view));
        commandList.add(new ShowToysList(view));
        commandList.add(new AddNewProcurement(view));
        commandList.add(new SaleToys(view));
        commandList.add(new ShowToyInfo(view));
        commandList.add(new ShowAvailableToys(view));
        commandList.add(new ShowAllProcurements(view));
        commandList.add(new SaveStore(view));
        commandList.add(new LoadStore(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~~~~~~~~~~~~Меню:~~~~~~~~~~~~~~~~~~~~~~" + "\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return stringBuilder.toString();
    }

    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
