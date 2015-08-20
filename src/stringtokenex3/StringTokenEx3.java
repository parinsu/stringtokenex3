package stringtokenex3;

import java.util.*;
import java.util.StringTokenizer;
import java.io.File;
import java.util.Scanner;

public class StringTokenEx3 {

    public static void main(String[] args) throws Exception {
        File file = new File("Test_2.txt");

        Scanner input = new Scanner(file);
        System.out.println(input);
        //String splitString;
        StringTokenizer st;
        String delims = " ";
        ArrayList token = new ArrayList();
        while (input.hasNext()) {
            st = new StringTokenizer(input.next(), delims);
            while (st.hasMoreTokens()) {
                token.add(st.nextToken());
            }
        }
        /*for (Object token1 : token) {
            System.out.println(token1);
        }*/
        //checkForInherite(token);
        checkForObjectCreation(token);
        
    }
    protected static void checkForInherite(ArrayList a) {
        int j = 0;
        
        for(int i = 0; i < a.size();i++ )
        {
            if(a.get(i).equals("extends"))
            {
                System.out.println("Found Inherite");
            }
            else
            {
                System.out.println("Not found");
            }
        }
   

    }
    
    protected static void checkForObjectCreation(ArrayList a) {
        //int j = 0;
        String s0,s1,s2,s3;
        for (int i = 3; i < a.size()-3; i++) {
            
            s0 = a.get(i).toString();
            s1 = a.get(i-1).toString();
            s2 = a.get(i+1).toString();
            s3 = a.get(i-3).toString();
            
            /*System.out.println("s0: " + s0);
            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);
            System.out.println("s3: " + s3);
            */
            if (s0.equals("new")&&(s1.equals("=")) && (s2.contains(s3)))
            {
               
                System.out.println("Found Object Creation.");
            }
            //System.out.println(s0);
            
        }
    }
}
