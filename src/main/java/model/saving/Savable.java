package model.saving;

public interface Savable {
    void saveObjectAs(Object object, String path);
    Object loadObjectFrom(String path);
}
