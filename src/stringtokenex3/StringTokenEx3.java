package stringtokenex3;

import java.util.*;
import java.io.*;

public class StringTokenEx3 {

    private static final String FILE_HEADER = "Parent,Child";
    private static final String FILE_HEADER2 = "Caller,Callee";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static int inhid = 0;
    public static int relid = 0;
    

    public static void main(String[] args) throws Exception {

        // Define directory
        String target_dir = "./test_dir";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        ArrayList token = new ArrayList();
        ArrayList<InhLink> inherite = new ArrayList();
        ArrayList<RelLink> obj_create = new ArrayList();

        // Define token
        StringTokenizer st;
        String delims = " ";
        
        // Define file to store inherite and reliazation relation
        FileWriter fileWriter, fileWriter2;
        fileWriter = new FileWriter("Inheritance.csv");
        fileWriter2 = new FileWriter("Relization.csv");
        fileWriter.append(FILE_HEADER);
        fileWriter.append(NEW_LINE_SEPARATOR);
        fileWriter2.append(FILE_HEADER2);
        fileWriter2.append(NEW_LINE_SEPARATOR);

        // Walkthrough each file
        for (File f : files) {
            Scanner input = new Scanner(f);

            // Break string to tokens
            while (input.hasNext()) {
                st = new StringTokenizer(input.next(), delims);
                while (st.hasMoreTokens()) {
                    token.add(st.nextToken());
                }
            }
            
            checkForInherite(token, inherite);
                        
            for (InhLink inherites : inherite) {
                fileWriter.append(inherites.getParent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(inherites.getChild());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Integer.toString(inherites.getId()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            
            inherite.clear();
            
            checkForObjectCreation(token, obj_create);

            for (RelLink objs : obj_create) {
                fileWriter2.append(objs.getParent());
                fileWriter2.append(COMMA_DELIMITER);
                fileWriter2.append(objs.getChild());
                fileWriter2.append(COMMA_DELIMITER);
                fileWriter2.append(Integer.toString(objs.getId()));
                fileWriter2.append(NEW_LINE_SEPARATOR);
            }
            
            obj_create.clear();
            token.clear();
        
        }
        
        fileWriter.flush();
        fileWriter2.flush();
        fileWriter.close();
        fileWriter2.close();
    }

    // Check Inheritance method
    public static void checkForInherite(ArrayList a, ArrayList<InhLink> l) {
        
        InhLink lo;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("extends")) {
                lo = new InhLink();
                inhid++;
                lo.setParent(a.get(i - 1).toString());
                System.out.println(lo.getParent());
                lo.setChild(a.get(i + 1).toString());
                System.out.println(lo.getChild());
                lo.setId(inhid);
                System.out.println(lo.getId());
                l.add(lo);
            }
        }
    }

    // Check realization method
    public static void checkForObjectCreation(ArrayList a, ArrayList<RelLink> l2) {
 
        String s0, s1, s2;
        RelLink lo2;
        for (int i = 0; i < a.size(); i++) {
            s0 = a.get(i).toString();

            if (s0.equals("new")) {
                lo2 = new RelLink();
                s1 = a.get(i+1).toString();
                s2 = a.get(i-3).toString();
                relid++;
                
                lo2.setParent(s2);
                System.out.println(lo2.getParent());
                lo2.setChild(s1);
                System.out.println(lo2.getChild());
                lo2.setId(relid);
                System.out.println(lo2.getId());
                l2.add(lo2);

            }
        }
    }
}
