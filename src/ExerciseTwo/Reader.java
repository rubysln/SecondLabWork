package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Reader implements Readers {
    private List<String> enrolleeList = new ArrayList<>();
    private HashMap<String, Integer> points = new HashMap<String, Integer>();
    private HashMap<String, HashMap<String, Integer>> enrollee = new HashMap<>();
    private File file;
    private Scanner scanner;
    private HashMap<String, Integer> getPoints(String[] line){
        for(int i = 1; i < line.length; i++){
            String[] lineArray = line[i].trim().split(":");
            points.put(lineArray[0], Integer.parseInt(lineArray[1].trim()));
        }
        return points;
    }
    private void createEnrolles(List<String> enrolleeList){
        for(var e:enrolleeList){
            if(e != null){
            String[] line = e.split(",");
            enrollee.put(line[0], getPoints(line));
            }
        }
    }
    @Override
    public void get(File file) throws FileNotFoundException{
        this.file = file;
        this.scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            enrolleeList.add(scanner.nextLine());
        }
        createEnrolles(enrolleeList);
    }
    public HashMap<String, Integer> getEnrollee(String name){
        List<HashMap<String, Integer>> enrolleer = new ArrayList<>();
        if(enrollee.containsKey(name)){
            return enrollee.get(name);
        }
        else return null;
    }
}
