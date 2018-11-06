package model;

import java.io.IOException;
import java.nio.file.Path;

public interface HashMapAbstract {
    void remove(String name);
    boolean find(String name);
    void save(Path saveTo) throws IOException;
    void load(Path from) throws IOException;

}
