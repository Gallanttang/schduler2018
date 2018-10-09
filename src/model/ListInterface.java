package model;

import java.io.IOException;
import java.nio.file.Path;

public abstract class ListInterface {
    protected abstract void remove(String name);
    protected abstract boolean find(String name);

    abstract void save(Path saveTo) throws IOException;
    abstract void load(Path from) throws IOException;
}
