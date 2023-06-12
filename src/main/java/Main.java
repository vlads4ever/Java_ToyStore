import com.fasterxml.jackson.databind.ObjectMapper;
import model.Service;
import model.saving.Savable;
import model.saving.Serializing;
import model.toy.*;
import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;

import java.io.*;

public class Main {
    public static void main(java.lang.String[] args) throws IOException {
        Savable serializing = new Serializing();
        Service service = new Service(serializing);

//        System.out.println(service.addNewToy("Матрешка", ToyType.Doll, AgeRating.ZeroPlus, Material.Wood,
//                50, 50, 100, "Древбыт", 300));
//        System.out.println(service.addNewToy("Кукла", ToyType.Doll, AgeRating.ZeroPlus, Material.Wood,
//                50, 50, 100, "Древбыт", 350));
//        System.out.println(service.addNewProcurement(0, "Кукарача", 5));
//        System.out.println(service.addNewProcurement(1, "Мамзель", 6));
//
//        System.out.println(service.showToysList());
//        System.out.println(service.showAvailableToys());
//        System.out.println(service.showAllProcurements());
//
//        System.out.println(service.saveStore("ToyStore.json"));



        System.out.println(service.loadStore("ToyStore.json"));

        System.out.println(service.showToysList());
        System.out.println(service.showAvailableToys());

        System.out.println(service.saleToys(0, 3));
        System.out.println(service.showAvailableToys());

        System.out.println(service.addNewProcurement(0, "Моветон", 5));
        System.out.println(service.showAvailableToys());

        System.out.println(service.addNewToy("Машинка", ToyType.ToyCar, AgeRating.ThreePlus, Material.Metal,
        50, 50, 100, "Древбыт", 300));
        System.out.println(service.showToysList());
        System.out.println(service.showAllProcurements());
    }
}
