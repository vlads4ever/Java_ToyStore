package model.saving;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.store.ToyStore;
import java.io.*;

public class JSONSerializing implements Savable{
    @Override
    public String saveObjectAs(ToyStore toyStore, String path) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, toyStore);
        String jsonString = writer.toString();
        String result;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(jsonString);
            result = "Успешное сохранение в файл " + path + "\n";
        } catch(IOException e) {
            result = "Ошибка сохранения в файл!" + "\n";
        }
        return result;
    }

    @Override
    public ToyStore loadObjectFrom(String path) {
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

        ToyStore toyStore = new ToyStore(true);
        try (StringReader reader = new StringReader(newJsonString)) {
            toyStore = (ToyStore) mapper.readValue(reader, ToyStore.class);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return toyStore;
    }
}
