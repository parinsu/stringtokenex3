
package stringtokenex3;

import java.util.StringTokenizer;


public class StringTokenEx3 {

 
    public static void main(String[] args) {
        
        String delims = ",";
        String splitString = "one,two,,three,four,,five";
        
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
    }
    
}