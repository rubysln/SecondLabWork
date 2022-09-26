package ExerciseOne;

import java.io.File;
import java.io.FilenameFilter;

public class WorkingDirectory {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static WorkingDirectory instance;
    private String directoryName;
    private File file;
    private WorkingDirectory(String directoryName) {
        this.directoryName = directoryName;
    }

    public static WorkingDirectory getInstance(String directoryName) {
        if (instance == null) {
            instance = new WorkingDirectory(directoryName);
        }
        return instance;
    }
    public void printInstance(){
        file = new File(directoryName);
        String[] fileList = file.list();
        for(var e: fileList){
            if(e == fileList[fileList.length - 1]) System.out.printf(ANSI_BLUE + e + ANSI_RESET);
            else System.out.printf(ANSI_BLUE + e + ANSI_RESET + " | ");
        }
    }
    private String parentName(){
        file = new File(directoryName);
        return file.getParent();
    }

    public WorkingDirectory makeParentInstance(){
        if(instance != null){
            instance = new WorkingDirectory(parentName());
            directoryName = parentName();
        }
        return instance;
    }

    private boolean isChildDirectory(String childDirectory){
        file = new File(directoryName);
        String[] fileList = file.list();
        for(var e: fileList){
            if(e.equals(childDirectory)) return true;
        }
        return false;
    }
    public boolean makeChildDirectory(String childDirectory){
        String oldDirectoryName = directoryName;
        directoryName = directoryName + '\\' + childDirectory;
        file = new File(directoryName);
        directoryName = oldDirectoryName;
        return file.mkdir();
    }
    public WorkingDirectory makeChildInstance(String childDirectory){
        file = new File(childDirectory);
        if(instance != null){
            if(isChildDirectory(childDirectory)){
                directoryName = directoryName + File.separator + childDirectory;
                instance = new WorkingDirectory(directoryName);
            }
        }
        return instance;
    }
    public boolean deleteAll(){
        file = new File(directoryName);
        String[] fileList = file.list();
        String oldDirectory = directoryName;
        for(var e:fileList){
            file = new File(directoryName = directoryName + File.separator + e);
            file.delete();
            directoryName = oldDirectory;
        }
        return true;
    }
    public void printFile(String format){
        file = new File(directoryName);
        File[] listFiles = file.listFiles(new MyNameFilter(format));
        for(var e:listFiles){
            System.out.printf(ANSI_BLUE + e.getName() + ANSI_RESET + " | ");
        }
    }
    public void printAll(){
        file = new File(directoryName);
        File[] listFiles = file.listFiles();
        StringBuilder builder = new StringBuilder();
        printAllMethod(listFiles, builder);
    }
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
    public void doItExist(String name){
        name = name.toLowerCase();
        file = new File(directoryName);
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
