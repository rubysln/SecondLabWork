package ExerciseOne;

public class Main {
    public static void main(String[] args) {
        WorkingDirectory wd = WorkingDirectory.getInstance("C:\\Users\\ruby\\Desktop\\Java\\SecondLabWork\\ExerciseOne.WorkingDirectory");
        User user = new User(
                new PrintInstanceCommand(wd),
                new MakeParentInstanceCommand(wd),
                new MakeChildDirectoryCommand(wd),
                new MakeChildInstanceCommand(wd),
                new DeleteAllCommand(wd),
                new PrintFileCommand(wd),
                new PrintAllCommand(wd),
                new DoItExistCommand(wd)
        );
    }
}