package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public interface Readers {
    public void get(File file) throws FileNotFoundException;
}
