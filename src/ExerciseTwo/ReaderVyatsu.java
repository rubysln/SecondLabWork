package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReaderVyatsu implements Readers{
    private List<String> facultList = new ArrayList<>();
    private HashMap<String, Integer> points = new HashMap<String, Integer>();
    private HashMap<String, HashMap<String, Integer>> facult = new HashMap<>();
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
                facult.put(line[0], getPoints(line));
            }
        }
    }
    @Override
    public void get(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            facultList.add(scanner.nextLine());
        }
        createEnrolles(facultList);
    }
    public HashMap<String, HashMap<String, Integer>> getUniversityFacults(){
        return facult;
    }
}
