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
        Savable serializing = new Serializing(serializing);
        Service service = new Service();
        System.out.println(service.showAvailableToys());

        System.out.println(service.addNewToy("Матрешка", "Doll", "ZeroPlus", "Wood",
                50, 50, 100, "Древбыт", 300));
        System.out.println(service.showToysList());

        System.out.println(service.addNewProcurement(0, "Космос", 5));
        System.out.println(service.showAvailableToys());
        System.out.println(service.showToyInfo(0));







        Toys toy = new Toy("Матрешка", ToyType.Doll, AgeRating.ZeroPlus, Material.Wood,
                50, 50, 100, "Древбыт", 300);
        System.out.println(toy);


        //писать результат сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        //это объект Jackson, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сериализация: 1-куда, 2-что
        mapper.writeValue(writer, toy);

        //преобразовываем все записанное в StringWriter в строку
        String jsonString = writer.toString();
        System.out.println(jsonString);

        // Записываем текст из переменной в файл
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Toy.json"))) {
            bufferedWriter.write(jsonString);
            System.out.println("Сохранено в файл");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }


        // Извлекаем текст из файла в текстовую переменную
        String newJsonString = null;
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Toy.json"))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            newJsonString = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(newJsonString);

        // Создаем объект из JSON в текстовой переменной
        Toys toy2;
        try (StringReader reader = new StringReader(newJsonString)) {
            toy2 = mapper.readValue(reader, Toy.class);
        }
        System.out.println(toy2);
    }
}
