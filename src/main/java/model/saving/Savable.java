package model.saving;

import model.store.ToyStore;
import model.toy.Toy;
import model.toy.Toys;

import java.io.IOException;

public interface Savable {
    String saveObjectAs(ToyStore toyStore, String path) throws IOException;
    ToyStore loadObjectFrom(String path);
}
