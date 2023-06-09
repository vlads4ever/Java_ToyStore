package model;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.saving.Savable;
import model.store.Procurement;
import model.store.ToyStore;
import model.toy.*;
import model.toy.enumerables.AgeRating;
import model.toy.enumerables.Material;
import model.toy.enumerables.ToyType;


import java.io.*;
import java.util.Set;

public class Service {
    private Savable serializing;
    private ToyStore<Toy> toyStore;

    public Service(Savable serializing) {
        this.toyStore = new ToyStore<>();
        this.serializing = serializing;
    }

    public java.lang.String addNewToy(String name, ToyType toyType, AgeRating ageRating, Material material,
                                      int length, int width, int height, String manufacturer, double cost){
        Toy toy = new Toy(name, toyType, ageRating, material, length, width, height, manufacturer, cost);
        this.toyStore.addNewToy(toy);
        return "Новый товар создан.";
    }

    public java.lang.String showToyInfo(int id){
        return this.toyStore.getToy(id).toString();
    }

    public java.lang.String showToysList(){
        StringBuilder output = new StringBuilder();
        Set<Toy> toys = toyStore.getToysSet();
        if (toys.size() != 0) {
            for (Toy toy: toys) {
                output.append(java.lang.String.format("id: %d %s %.2f",
                        toy.getId(), toy.getName(), toy.getCost()) + "руб." + "\n");
            }
        } else {
            output.append("Список пуст." + "\n");
        }

        return output.toString();
    }

    public java.lang.String addNewProcurement(int id, java.lang.String supplier, int warehouseQuantity){
        Toy toy = this.toyStore.getToy(id);
        if (toy != null) {
            Procurement procurement = new Procurement<Toy>(toy, supplier, warehouseQuantity);
            this.toyStore.addNewProcurement(procurement);
            return "Поставка проведена.";
        }
        return "Товар с таким id отсутствует.";
    }

    public java.lang.String showAvailableToys(){
        return this.toyStore.getAvailableToys();
    }

    public String saveStore(String path) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, toyStore);
        String jsonString = writer.toString();
        String result;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(jsonString);
            result = "Успешное сохранение в файл " + path;
        } catch(IOException e) {
            result = "Ошибка сохранения в файл!";
        }
        return result;
    }

    public String loadStore(String path) {
        String newJsonString = null;
        String result;
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            newJsonString = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            result = "Ошибка восстановления из файла!";
        } catch (IOException e) {
            result = "Ошибка восстановления из файла!";
        }
        System.out.println(newJsonString);
        ToyStore<Toy> toyStore;
        try (StringReader reader = new StringReader(newJsonString)) {
            toyStore = mapper.readValue(reader, ToyStore.class);
            result = "Успешная загрузка из файла " + path;
        } catch(IOException e) {
            result = "Ошибка восстановления из файла!";
        }
        return result;
    }
}
