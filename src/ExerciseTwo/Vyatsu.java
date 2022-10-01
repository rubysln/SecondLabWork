package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Vyatsu implements Observed{
    private HashMap<String, HashMap<String, Integer>> facults;
    private LinkedHashMap<String, LinkedHashMap<String, Integer>> enrollers = new LinkedHashMap<>();
    @Override
    public void addEnrollee(Observer observer){
        enrollers.put(observer.getName(), (LinkedHashMap<String, Integer>) observer.getPoints());
    }
    @Override
    public void removeEnrollee(Observer observer){
        enrollers.remove(observer.getName(), observer.getPoints());
    }
    public Vyatsu(File file) throws FileNotFoundException {
        Readers reader = new Reader(file);
        facults = reader.getFacults();
    }
    public List<String> pointComparsion(HashMap<String, Integer> points){
        List<String> namesFaculst = new ArrayList<>();
        for(var e: facults.keySet()){
                if(pointComparsionMethod(facults.get(e), points)) namesFaculst.add(e);
        }
        return namesFaculst;
    }
    private boolean pointComparsionMethod(HashMap<String, Integer> facultPoints, HashMap<String, Integer> enrolleePoints){
        List<Boolean> result = new ArrayList<>();
        Set facultSubject = facultPoints.keySet();
        Set enrolleeSubject = enrolleePoints.keySet();
        for(var e:facultSubject){
            for(var j : enrolleeSubject){
                if(e.equals(j)){
                    if(facultPoints.get(e) <= enrolleePoints.get(j)){
                        result.add(true);
                    }
                    else return false;
                }
            }
        }
        if(result.size() < facultPoints.size()) return false;
        return true;
    }
}

