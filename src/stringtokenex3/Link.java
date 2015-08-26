/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringtokenex3;

/**
 *
 * @author Wind
 */
public class Link {
    private String parent;
    private String child;
    
    public Link(){
        parent = null;
        child = null;
    }
    
    public void setParent(String p){
        parent = p;
    }
    public void setChild(String c){
        child = c;
    }
    public String getParent(){
        return parent;
    }
    public String getChild(){
        return child;
    }
    
}
