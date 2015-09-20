package stringtokenex3;

import java.util.*;
import java.io.*;

public class StringTokenEx3 {

    private static final String FILE_HEADER = "Parent, Child, , ID, Relation";

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
        ArrayList<Link> inherite = new ArrayList();

        // Define token
        StringTokenizer st;
        String delims = " ";

        // Define file to store inherite and reliazation relation
        FileWriter fileWriter;
        fileWriter = new FileWriter("Relation.csv");
        fileWriter.append(FILE_HEADER);
        fileWriter.append(NEW_LINE_SEPARATOR);

        // Walkthrough each file
        for (File f : files) {
            Scanner input = new Scanner(f);

            // Breakdown string to tokens
            while (input.hasNext()) {
                st = new StringTokenizer(input.next(), delims);
                while (st.hasMoreTokens()) {
                    token.add(st.nextToken());
                }
            }

            checkForRelation(token, inherite);

            // Write data to file            
            for (Link inherites : inherite) {
                fileWriter.append(inherites.getParent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(inherites.getChild());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Integer.toString(inherites.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(inherites.getRelation());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            // Clear ArrayList
            inherite.clear();
            token.clear();

        }

        // Record and close file
        fileWriter.flush();
        fileWriter.close();
    }

    // Method for checking relation
    public static void checkForRelation(ArrayList a, ArrayList<Link> l3) {
        Link lo;
        String s0, s1, s2;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("extends")) {
                lo = new Link();
                inhid++;
                lo.setParent(a.get(i - 1).toString());
                System.out.println(lo.getParent());
                lo.setChild(a.get(i + 1).toString());
                System.out.println(lo.getChild());
                lo.setId(inhid);
                System.out.println(lo.getId());
                lo.setRelation("Inheritance");
                System.out.println(lo.getRelation());
                l3.add(lo);
            }

            if (a.get(i).toString().equals("new")) {
                lo = new Link();
                s1 = a.get(i + 1).toString();
                s2 = a.get(i - 3).toString();
                inhid++;

                lo.setParent(s2);
                System.out.println(lo.getParent());
                lo.setChild(s1);
                System.out.println(lo.getChild());
                lo.setId(inhid);
                System.out.println(lo.getId());
                lo.setRelation("Relaization");
                System.out.println(lo.getRelation());
                l3.add(lo);

            }
        }
    }
}
