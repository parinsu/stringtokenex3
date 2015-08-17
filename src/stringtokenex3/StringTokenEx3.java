
package stringtokenex3;

import java.util.StringTokenizer;
import java.io.File;
import java.util.Scanner;


public class StringTokenEx3 {

 
    public static void main(String[] args) throws Exception {
        File file = new File("Test.txt");
        
        Scanner input = new Scanner(file);
        
        System.out.println("File Length: " + file.length());
        
        /*while(input.hasNext()){
            System.out.println(input.next());
        }*/
        
        String delims = "\\s+";
        String splitString;
        
       /* String splitString = "one,two,,three,four,,five";
        
        System.out.println("StringTokenizer Example: \n");
        StringTokenizer st = new StringTokenizer(splitString, delims);
        
        while(st.hasMoreTokens()){
            System.out.println("StringTokenizer Output: " + st.nextElement());
        }
        
        System.out.println("\n\nSplit Example: \n");
        String[] tokens = splitString.split(delims);
        int tokenCount = tokens.length;
        for(int j = 0; j < tokenCount; j++){
            System.out.println("Split Output: " + tokens[j]);
        }
        System.out.println();
        */
        
        
        
        
    }
    
}