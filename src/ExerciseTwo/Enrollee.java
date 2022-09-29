package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

public class Enrollee implements Observer {
    private String name;
    private HashMap<String, Integer> points;

    public Enrollee(String name, File file) throws FileNotFoundException {
        this.name = name;
        Readers reader = new Reader(file);
        points = reader.get(name);
    }
    @Override
    public void getMessage(){

    }
    @Override
    public HashMap<String, Integer> getPoints(){
        return points;
    }
    @Override
    public String getName(){
        return name;
    }
}
