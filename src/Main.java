import java.awt.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        WorkingDirectory wd = WorkingDirectory.getInstance("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork");
        User user = new User(
                new PrintInstanceCommand(wd),
                new MakeParentInstanceCommand(wd),
                new MakeChildDirectoryCommand("ChildDirectory", wd),
                new MakeChildInstanceCommand("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork\\WorkingDirectory\\ChildDirectory", wd),
                new DeleteAllCommand(wd),
                new PrintFileCommand(".jar", wd),
                new PrintAllCommand(wd),
                new DoItExistCommand("ChildDirectory", wd)
        );
    }
}