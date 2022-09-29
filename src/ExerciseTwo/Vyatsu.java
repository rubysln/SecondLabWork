package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Vyatsu implements Observed{
    private HashMap<String, HashMap<String, Integer>> facults;
    private HashMap<String, HashMap<String, Integer>> enrollers = new HashMap<>();
    @Override
    public void addEnrollee(Observer observer){
        enrollers.put(observer.getName(),observer.getPoints());
    }
    @Override
    public void removeEnrollee(Observer observer){
        enrollers.remove(observer.getName(), observer.getPoints());
    }
    public Vyatsu(File file) throws FileNotFoundException {
        Readers reader = new Reader(file);
        facults = reader.getFacults();
    }
    public boolean pointComparsion(Observer observer){

    }
}

