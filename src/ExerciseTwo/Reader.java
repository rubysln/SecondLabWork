package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader implements Readers {
    private List<String> list;
    private File file;
    private Scanner scanner;
    public Reader(File file) throws FileNotFoundException{
        this.file = file;
        this.scanner = new Scanner(file);
        list = new ArrayList<>();
        while(scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }
    }
    private LinkedHashMap<String, Integer> getPoints(String[] line){
        LinkedHashMap<String, Integer> points = new LinkedHashMap<>();
        for(int i = 1; i < line.length; i++){
            String[] lineArray = line[i].trim().split(":");
            points.put(lineArray[0], Integer.parseInt(lineArray[1].trim()));
        }
        return points;
    }
    @Override
    public LinkedHashMap<String, Integer> get(String name) throws FileNotFoundException{
        for(var e:list) {
            String[] enrolleeArray = e.split(",");
            for(var j:enrolleeArray) {
                if(j.equals(name)) return getPoints(enrolleeArray);
            }
        }
        return null;
    }

    @Override
    public HashMap<String, HashMap<String, Integer>> getFacults() throws FileNotFoundException {
        HashMap<String, HashMap<String, Integer>> facults = new LinkedHashMap<>();
        for(var e: list){
            if(e != null){
                String[] listLine = e.split(",");
                facults.put(listLine[0], getPoints(listLine));
            }
        }
        return facults;
    }
}
