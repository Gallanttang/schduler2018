package model;

import java.io.IOException;
import java.nio.file.Path;

public abstract class HashMapAbstract {
    protected abstract void remove(String name);
    protected abstract boolean find(String name);
    protected abstract void save(Path saveTo) throws IOException;
    protected abstract void load(Path from) throws IOException;

}
