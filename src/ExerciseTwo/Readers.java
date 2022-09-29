package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public interface Readers {
    public HashMap<String, Integer> get(String name) throws FileNotFoundException;
    public HashMap<String, HashMap<String, Integer>> getFacults() throws FileNotFoundException;
}
