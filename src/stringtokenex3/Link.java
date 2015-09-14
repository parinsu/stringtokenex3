
package stringtokenex3;

public class Link {
      
    private String parent;
    private String child;
    private int id;
    
    public Link(){
        parent = null;
        child = null;
        id = 0;
        
    }
    
    public void setParent(String p){
        parent = p;
    }
    
    public void setChild(String c){
        child = c;
    }
    
    public void setId(int i){
        id = i;
    }
    
    public String getParent(){
        return parent;
    }
    public String getChild(){
        return child;
    }
    
    public int getId(){
        return id;
    } 
    
}
