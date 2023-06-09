package model.saving;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.store.ToyStore;
import model.toy.Toy;

import java.io.*;

public class Serializing implements Savable{
    @Override
    public String saveObjectAs(ToyStore toyStore, String path) throws IOException {
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

    @Override
    public ToyStore<Toy> loadObjectFrom(String path) {
        String newJsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            newJsonString = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ToyStore<Toy> toyStore = new ToyStore<>(true);
        try (StringReader reader = new StringReader(newJsonString)) {
            toyStore = (ToyStore<Toy>) mapper.readValue(reader, ToyStore.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return toyStore;
    }
}
