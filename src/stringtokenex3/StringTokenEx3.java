package stringtokenex3;

import java.util.*;
import java.io.*;

public class StringTokenEx3 {

    private static final String FILE_HEADER = "Parent,Child";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER2 = "Caller, Callee";

    public static void main(String[] args) throws Exception {

        // Define directory
        String target_dir = "./test_dir";
        File dir = new File(target_dir);
        File[] files = dir.listFiles();
        ArrayList token = new ArrayList();
        ArrayList<Link> inherite = new ArrayList();
        ArrayList<Link> obj_create = new ArrayList();
        StringTokenizer st;
        String delims = " ";

        //Walkthrough each file
        for (File f : files) {
            Scanner input = new Scanner(f);
                       
            while (input.hasNext()) {
                st = new StringTokenizer(input.next(), delims);
                while (st.hasMoreTokens()) {
                    token.add(st.nextToken());
                }
            }

            checkForInherite(token, inherite);
            

            FileWriter fileWriter;
            fileWriter = new FileWriter("Example.csv");
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Link inherites : inherite) {
                fileWriter.append(inherites.getParent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(inherites.getChild());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(inherites.getId());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();
            
            checkForObjectCreation(token,obj_create);
            
            fileWriter = new FileWriter("Object_create.csv");
            fileWriter.append(FILE_HEADER2);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Link objs : obj_create) {
                fileWriter.append(objs.getParent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(objs.getChild());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(objs.getId());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();
        }
    }

    public static void checkForInherite(ArrayList a, ArrayList<Link> l) {
        //int j = 0;
        Link lo;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("extends")) {
                //System.out.println("Found Inherite");
                lo = new Link();
                lo.setParent(a.get(i - 1).toString());
                System.out.println(lo.getParent());
                lo.setChild(a.get(i + 1).toString());
                System.out.println(lo.getChild());
                //lo.setId(FILE_HEADER);
                l.add(lo);
            }
        }
    }

    public static void checkForObjectCreation(ArrayList a,ArrayList<Link> l) {
        //int j = 0;
        String s0, s1, s2, s3;
        Link lo;
        for (int i = 3; i < a.size() - 3; i++) {
            s0 = a.get(i).toString();
            //s1 = a.get(i - 1).toString();
            s1 = a.get(i + 1).toString();
            s2 = a.get(i - 3).toString();

            if (s0.equals("new") && (s1.contains(s2))) {
                lo = new Link();
                lo.setParent(s2);
                System.out.println(lo.getParent());
                lo.setChild(s1);
                System.out.println(lo.getChild());
                //lo.setId(FILE_HEADER);
                l.add(lo);
                //System.out.println("Found Object Creation.");
            }

        }
    }
}
