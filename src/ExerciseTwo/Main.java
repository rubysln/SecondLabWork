package ExerciseTwo;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork\\Vyatsu\\Enrolles.txt");
        File Vytsu = new File("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork\\Vyatsu\\Vyatsu.txt");
        Readers enrolles = new Reader();
        Readers facults = new ReaderVyatsu();
        enrolles.get(file);
        facults.get(Vytsu);
    }
}
