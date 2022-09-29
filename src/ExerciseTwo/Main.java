package ExerciseTwo;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork\\Vyatsu\\Enrolles.txt");
        File Vytsu = new File("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork\\Vyatsu\\Vyatsu.txt");
        Enrollee Artem = new Enrollee("Маклаков Артём Николаевич", file);
        Vyatsu vyatsu = new Vyatsu(Vytsu);
        vyatsu.addEnrollee(Artem);
    }
}
