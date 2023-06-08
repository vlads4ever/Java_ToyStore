import com.fasterxml.jackson.databind.ObjectMapper;
import model.toy.*;
import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(java.lang.String[] args) throws IOException {
//        Service service = new Service();
//        System.out.println(service.showAvailableToys());
//
//        System.out.println(service.addNewToy("Матрешка", "Doll", "ZeroPlus", "Wood",
//                50, 50, 100, "Древбыт", 300));
//        System.out.println(service.showToysList());
//
//        System.out.println(service.addNewProcurement(0, "Космос", 5));
//        System.out.println(service.showAvailableToys());
//        System.out.println(service.showToyInfo(0));





        Toys toy = new Toy("Матрешка", ToyType.Doll, AgeRating.ZeroPlus, Material.Wood,
                50, 50, 100, "Древбыт", 300);
        System.out.println(toy);


        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        mapper.writeValue(writer, toy);

        //преобразовываем все записанное во StringWriter в строку
        java.lang.String jsonString = writer.toString();
        System.out.println(jsonString);

        StringReader reader = new StringReader(jsonString);
        Toys toy2 = mapper.readValue(reader, Toy.class);
        System.out.println(toy2);



    }
}
