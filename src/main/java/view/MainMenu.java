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
        this.commandList = new ArrayList<>();
        this.commandList.add(new Exit(view));
        this.commandList.add(new AddNewToy(view));
        this.commandList.add(new ShowToysList(view));
        this.commandList.add(new AddNewProcurement(view));
        this.commandList.add(new AddNewSale(view));
        this.commandList.add(new ShowToyInfo(view));
        this.commandList.add(new ShowAvailableToys(view));
        this.commandList.add(new ShowAllProcurements(view));
        this.commandList.add(new ShowAllSales(view));
        this.commandList.add(new SaveStore(view));
        this.commandList.add(new LoadStore(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~~~~~~~Меню:~~~~~~~~~~~~~~~~~" + "\n");
        for (int i = 0; i < this.commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(this.commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return stringBuilder.toString();
    }

    public void execute(int numCommand) throws IOException, ClassNotFoundException {
        this.commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return this.commandList.size();
    }
}
