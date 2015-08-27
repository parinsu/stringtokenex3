package stringtokenex3;

import java.util.*;
import java.io.*;

public class StringTokenEx3 {

    private static final String FILE_HEADER = "Parent,Child";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void main(String[] args) throws Exception {

        File file = new File("C.java");

        Scanner input = new Scanner(file);
        System.out.println(input);
        StringTokenizer st;
        String delims = " ";
        ArrayList token = new ArrayList();
        ArrayList<Link> inherite = new ArrayList();
        while (input.hasNext()) {
            st = new StringTokenizer(input.next(), delims);
            while (st.hasMoreTokens()) {
                token.add(st.nextToken());
            }
        }

        checkForInherite(token, inherite);
        //checkForObjectCreation(token);

        FileWriter fileWriter;
        fileWriter = new FileWriter("Example.csv");
        fileWriter.append(FILE_HEADER);
        fileWriter.append(NEW_LINE_SEPARATOR);
        for (Link inherites : inherite) {
            fileWriter.append(inherites.getParent());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(inherites.getChild());
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void checkForInherite(ArrayList a, ArrayList<Link> l) {
        int j = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals("extends")) {
                System.out.println("Found Inherite");
                Link lo = new Link();
                lo.setParent(a.get(i - 1).toString());
                System.out.println(lo.getParent());
                lo.setChild(a.get(i + 1).toString());
                System.out.println(lo.getChild());
                l.add(lo);
            }
        }
    }

    public static void checkForObjectCreation(ArrayList a) {
        //int j = 0;
        String s0, s1, s2, s3;
        for (int i = 3; i < a.size() - 3; i++) {
            s0 = a.get(i).toString();
            s1 = a.get(i - 1).toString();
            s2 = a.get(i + 1).toString();
            s3 = a.get(i - 3).toString();

            if (s0.equals("new") && (s2.contains(s3))) {
                System.out.println("Found Object Creation.");
            }

        }
    }
}
