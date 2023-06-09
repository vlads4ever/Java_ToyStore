package model.saving;

import model.store.ToyStore;
import model.toy.Toy;

import java.io.IOException;

public interface Savable {
    String saveObjectAs(ToyStore toyStore, String path) throws IOException;
    ToyStore<Toy> loadObjectFrom(String path);
}
