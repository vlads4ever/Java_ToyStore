import model.Service;
import model.saving.Savable;
import model.saving.JSONSerializing;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.*;

public class Main {
    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        Savable serializing = new JSONSerializing();
        Service service = new Service(serializing);
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}
