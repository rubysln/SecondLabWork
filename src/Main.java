import java.io.*;

public class Main {
    public static void main(String[] args) {
        WorkingDirectory wd = WorkingDirectory.getInstance("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork");
        wd.printAll();
        wd.doItExist("secondlabwork");
        wd.doItExist("secondlabwor");
    }
}