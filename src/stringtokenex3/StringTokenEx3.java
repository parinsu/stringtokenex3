
package stringtokenex3;

import java.util.*;
import java.util.StringTokenizer;
import java.io.File;
import java.util.Scanner;


public class StringTokenEx3 {

 
    public static void main(String[] args) throws Exception {
        File file = new File("Test.txt");
        
        Scanner input = new Scanner(file);
        System.out.println(input);
        //String splitString;
        StringTokenizer st;
        String delims = " ";
        ArrayList token = new ArrayList();
        while(input.hasNext())
        {
            st = new StringTokenizer(input.next(),delims);
            while(st.hasMoreTokens())
            {
                token.add(st.nextToken());
            }    
        }
        for (Object token1 : token) {
            System.out.println(token1);
        }
        
        
    }
    
}