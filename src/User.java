public class User {
    Command printInstance;
    Command makeParentInstace;
    Command makeChildDirectory;
    Command makeChildInstance;
    Command deleteAll;
    Command printFile;
    Command printAll;
    Command doItExist;

    public User(Command printInstance, Command makeParentInstace, Command makeChildDirectory, Command makeChildInstance, Command deleteAll, Command printFile, Command printAll, Command doItExist) {
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
    public void makeChildDirectory(){
        makeChildDirectory.execute();
    }
    public void deleteAll(){
        deleteAll.execute();
    }
    public void printFile(){
        printFile.execute();
    }
    public void printAll(){
        printAll.execute();
    }
    public void doItExist(){
        doItExist.execute();
    }
}
