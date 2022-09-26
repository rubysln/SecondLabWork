package ExerciseOne;

interface CommandString{
    public void execute(String string);
}
interface Command{
    public void execute();
}
class PrintInstanceCommand implements Command{
    private WorkingDirectory wd;
    public PrintInstanceCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(){
        wd.printInstance();
    }
}
class MakeParentInstanceCommand implements Command{
    private WorkingDirectory wd;
    public MakeParentInstanceCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(){
        wd.makeParentInstance();
    }
}
class MakeChildDirectoryCommand implements CommandString{
    private WorkingDirectory wd;
    public MakeChildDirectoryCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(String childDirectory){
        wd.makeChildDirectory(childDirectory);
    }
}
class MakeChildInstanceCommand implements CommandString{
    private WorkingDirectory wd;
    public MakeChildInstanceCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(String childDirectoryInstance){
        wd.makeChildInstance(childDirectoryInstance);
    }
}
class DeleteAllCommand implements Command{
    private WorkingDirectory wd;
    public DeleteAllCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(){
        wd.deleteAll();
    }
}
class PrintFileCommand implements CommandString{
    private WorkingDirectory wd;
    public PrintFileCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(String format){
        wd.printFile(format);
    }
}
class PrintAllCommand implements Command{
    private WorkingDirectory wd;
    public PrintAllCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(){
        wd.printAll();
    }
}
class DoItExistCommand implements CommandString{
    private WorkingDirectory wd;
    public DoItExistCommand(WorkingDirectory wd){
        this.wd = wd;
    }
    @Override
    public void execute(String name){
        wd.doItExist(name);
    }
}