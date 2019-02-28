import java.io.File;
import java.io.IOException;
import java.util.*;

public class PathScanner  {
    
    String toGiveToGUI = "";
    //StringBuffer toGiveToGUIBuffer = null;
    
    public void Pathscanner(String fp) throws NullPointerException {
        
        
        File filepath = new File(fp);
        Collection<File> cf = listFileTree(filepath);
        String result = Arrays.toString(cf.toArray());
        String[] resultList = result.split(",");
        Arrays.sort(resultList);
        for (int i = 0; i < resultList.length; i++) {
            
            String temp = resultList[i].replace("[","");
            String temp2 = temp.replace("]","");
            String temp3 = temp2.replace(" ","");
            resultList[i] = temp3;
        }
    
        ArrayList<String> foldersPresent = new ArrayList<>();
        for (String s : resultList) {
            File folderToAdd = new File(s);
            foldersPresent.add(folderToAdd.getParent());
        }
        
        Set<String> set = new HashSet<String>();
    
        for (String str : foldersPresent) {
            if (!set.contains(str)) {
                set.add(str);
                //toGiveToGUI = toGiveToGUI + "\n" + str;
                //toGiveToGUIBuffer.append("\n").append(str);
            }
        }
        //now we have a set with all the folders and no duplicate
        //we need to order it, but can't order HashSet
        List<String> list = new ArrayList<String>(set);
        Collections.sort(list,new MyComparator());
    
        //now the list is properly sorted, we can start adding files to output
        for (String str: list)
        {
            //Print(str);
            toGiveToGUI = toGiveToGUI + "\n" + str;
            //toGiveToGUIBuffer.append("\n" + str);
            File dirToCheck = new File(str);
            getAllFiles(dirToCheck);
        }
        
        
    }
    
    public void getAllFiles(File curDir) {
        
        if (curDir.listFiles() != null) {
            File[] filesList = curDir.listFiles();
            assert filesList != null;
            for (File f : filesList) {
                if (f.isFile()) {
                    toGiveToGUI = toGiveToGUI + "\n \t  " + f.getName() + " @ " + f.length() / 1024 + " Kb";
                }
            }
        }
    }
    
        
    private static Collection<File> listFileTree(File dir) {
        
            Set<File> fileTree = new HashSet<File>();
            
            if(dir==null||dir.listFiles()==null){
                return fileTree;
            }
            for (File entry : Objects.requireNonNull(dir.listFiles())) {
                if (entry.isFile()) fileTree.add(entry);
                else fileTree.addAll(listFileTree(entry));
            }
            return fileTree;
        }
        
    
    public void Print(String k) {
        System.out.println(k);
    }
    
    public void PrintStringArray(ArrayList<String> al) {
        for (String str : al) {
            Print(str);
        }
    }
    
    public void PrintFileArray(ArrayList<File> al)
    {
        for (Object o : al) {
            Print(o.toString());
        }
    }
    
}
