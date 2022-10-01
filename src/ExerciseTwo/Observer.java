package ExerciseTwo;

import java.util.HashMap;
import java.util.List;

public interface Observer {
    public HashMap<String, Integer> getPoints();
    public String getName();
    public void getMessage(Vyatsu vyatsu);
}
