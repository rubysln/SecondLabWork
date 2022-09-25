import java.io.File;
import java.io.FilenameFilter;

public class WorkingDirectory {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static WorkingDirectory instance;
    private String directoryName;
    private File file = new File(directoryName);
    private WorkingDirectory(String directoryName) {
        this.directoryName = directoryName;
    }
    // Создание директории
    public static WorkingDirectory getInstance(String directoryName) {
        if (instance == null) {
            instance = new WorkingDirectory(directoryName);
        }
        return instance;
    }
    // Вывод содержимого
    public void printInstance(){
        String[] fileList = file.list();
        for(var e: fileList){
            if(e == fileList[fileList.length - 1]) System.out.printf(ANSI_BLUE + e + ANSI_RESET);
            else System.out.printf(ANSI_BLUE + e + ANSI_RESET + " | ");
        }
    }
    // Метод возвращающий путь родительского каталога
    private String parentName(){
        return file.getParent();
    }
    // Метод перехода к родительскому каталогу
    public WorkingDirectory makeParentInstance(){
        instance = new WorkingDirectory(parentName());
        directoryName = parentName();
        return instance;
    }
    // Метод проверки наличия дочернего каталога
    private boolean isChildDirectory(String childDirectory){
        String[] fileList = file.list();
        for(var e: fileList){
            if(e.equals(childDirectory)) return true;
        }
        return false;
    }
    // Метод создания дочернего каталога
    public boolean makeChildDirectory(String childDirectory){
        String childDirectoryName = directoryName + File.separator + childDirectory;
        file = new File(childDirectoryName);
        return file.mkdir();
    }
    // Метод перехода к дочернему каталогу
    public WorkingDirectory makeChildInstance(String childDirectory){
        file = new File(childDirectory);
            if(isChildDirectory(childDirectory)){
                directoryName = directoryName + File.separator + childDirectory;
                instance = new WorkingDirectory(directoryName);
            }
        return instance;
    }
    // Метод удаления всех подкаталогов вложенных в данный
    public boolean deleteAll(){
        String[] fileList = file.list();
        String oldDirectory = directoryName;
        for(var e:fileList){
            file = new File(directoryName = directoryName + File.separator + e);
            file.delete();
            directoryName = oldDirectory;
        }
        return true;
    }
    // Метод вывода списка файлов определенного формата
    public void printFile(String format){
        File[] listFiles = file.listFiles(new MyNameFilter(format));
        for(var e:listFiles){
            System.out.printf(ANSI_BLUE + e.getName() + ANSI_RESET + " | ");
        }
    }
    // Метод вывода иерархического списка всех каталогов, вложенных в данный
    public void printAll(){
        File[] listFiles = file.listFiles();
        StringBuilder builder = new StringBuilder();
        printAllMethod(listFiles, builder);
    }
    // Рекурсивный метод, реализующий метод иерархического списка
    private void printAllMethod(File[] list, StringBuilder builder){
        for(var e:list){
            System.out.println(builder.toString() + ANSI_BLUE + e.getName() + ANSI_RESET);
            if(e.isDirectory()){
                builder.append('>');
                File[] childFiles = e.listFiles();
                printAllMethod(childFiles, builder);
            }
        }
        builder.delete(0,1);
    }
    // Метод проверки существования подкаталога
    public void doItExist(String name){
        name = name.toLowerCase();
        File[] fileList = file.listFiles();
        System.out.println(doItExistMethod(fileList, name));
    }
    private boolean doItExistMethod(File[] files, String name){
        for(var e:files){
            if(e.isDirectory()){
                if(e.getName().toLowerCase().equals(name)) return true;
                else {
                    File[] fileList = e.listFiles();
                    if(doItExistMethod(fileList, name)) return true;
                }
            }
        }
        return false;
    }
    private class MyNameFilter implements FilenameFilter{
        private String format;
        public MyNameFilter(String format){
            this.format = format.toLowerCase();
        }
        public boolean accept(File dir, String name){
            return name.toLowerCase().endsWith(format);
        }
    }
}
