public interface Command {
    public void execute();
}
class PrintInstanceCommand implements Command{
    private WorkingDirectory wd;
    public PrintInstanceCommand(WorkingDirectory wd){
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
class MakeChildDirectoryCommand implements Command{
    private WorkingDirectory wd;
    private String childDirectory;
    public MakeChildDirectoryCommand(String childDirectory, WorkingDirectory wd){
        this.childDirectory = childDirectory;
        this.wd = wd;
    }
    @Override
    public void execute(){
        wd.makeChildInstance(childDirectory);
    }
}
class MakeChildInstanceCommand implements Command{
    private WorkingDirectory wd;
    private String childDirectory;
    public MakeChildInstanceCommand(String childDirectory, WorkingDirectory wd){
        this.childDirectory = childDirectory;
        this.wd = wd;
    }
    @Override
    public void execute(){
        wd.makeChildInstance(childDirectory);
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
class PrintFileCommand implements Command{
    private WorkingDirectory wd;
    private String format;
    public PrintFileCommand(String format, WorkingDirectory wd){
        this.format = format;
        this.wd = wd;
    }
    @Override
    public void execute(){
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
class DoItExistCommand implements Command{
    private WorkingDirectory wd;
    private String name;
    public DoItExistCommand(String name, WorkingDirectory wd){
        this.wd = wd;
        this.name = name;
    }
    @Override
    public void execute(){
        wd.doItExist(name);
    }
}