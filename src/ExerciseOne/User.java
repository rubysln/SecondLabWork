package ExerciseOne;

// Invoker
public class User {
    Command printInstance;
    Command makeParentInstace;
    CommandString makeChildDirectory;
    CommandString makeChildInstance;
    Command deleteAll;
    CommandString printFile;
    Command printAll;
    CommandString doItExist;

    public User(Command printInstance, Command makeParentInstace, CommandString makeChildDirectory, CommandString makeChildInstance, Command deleteAll, CommandString printFile, Command printAll, CommandString doItExist) {
        this.printInstance = printInstance;
        this.makeParentInstace = makeParentInstace;
        this.makeChildDirectory = makeChildDirectory;
        this.makeChildInstance = makeChildInstance;
        this.deleteAll = deleteAll;
        this.printFile = printFile;
        this.printAll = printAll;
        this.doItExist = doItExist;
    }
    public void printInstance(){
        printInstance.execute();
    }
    public void makeParentInstace(){
        makeParentInstace.execute();
    }
    public void makeChildDirectory(String childDirectory){
        makeChildDirectory.execute(childDirectory);
    }
    public void makeChildInstance(String childDirectoryName){
        makeChildInstance.execute(childDirectoryName);
    }
    public void deleteAll(){
        deleteAll.execute();
    }
    public void printFile(String format){
        printFile.execute(format);
    }
    public void printAll(){
        printAll.execute();
    }
    public void doItExist(String name){
        doItExist.execute(name);
    }
}
