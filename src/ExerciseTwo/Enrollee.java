package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Enrollee implements Observer {
    private String name;
    private LinkedHashMap<String, Integer> points;

    public Enrollee(String name, File file) throws FileNotFoundException {
        this.name = name;
        Readers reader = new Reader(file);
        points = (LinkedHashMap<String, Integer>) reader.get(name);
    }

    @Override
    public void getMessage(Vyatsu vyatsu){
        List<String> facults = vyatsu.pointComparsion(points);
        for(var e: facults){
            System.out.println(e);
        }
    }
    @Override
    public LinkedHashMap<String, Integer> getPoints(){
        return points;
    }
    @Override
    public String getName(){
        return name;
    }
}
