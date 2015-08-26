package stringtokenex3;

import java.util.*;
import java.util.StringTokenizer;
import java.io.File;
import java.util.Scanner;

public class StringTokenEx3 {

    public static void main(String[] args) throws Exception {
        File file = new File("C.java");

        Scanner input = new Scanner(file);
        System.out.println(input);
        StringTokenizer st;
        String delims = " ";
        ArrayList token = new ArrayList();
        while (input.hasNext()) {
            st = new StringTokenizer(input.next(), delims);
            while (st.hasMoreTokens()) {
                token.add(st.nextToken());
            }
        }

        checkForInherite(token);
        checkForObjectCreation(token);
        
    }
    public static void checkForInherite(ArrayList a) {
        int j = 0;
        
        for(int i = 0; i < a.size();i++ )
        {
            if(a.get(i).equals("extends"))
            {
                //System.out.println("Found Inherite");
                
            }

        }
   

    }
    
    public static void checkForObjectCreation(ArrayList a) {
        //int j = 0;
        String s0,s1,s2,s3;
        for (int i = 3; i < a.size()-3; i++) {
            
            s0 = a.get(i).toString();
            s1 = a.get(i-1).toString();
            s2 = a.get(i+1).toString();
            s3 = a.get(i-3).toString();
            
            if (s0.equals("new") && (s2.contains(s3)))
            {
               
                System.out.println("Found Object Creation.");
            }
            
        }
    }
}
