/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;
import java.util.*;
/**
 *
 * @author ali
 */
class MyStack {
    private ArrayList<String> list = new ArrayList<>(); 
   
    MyStack(){ // no arg-constructor
        
    }
    
    boolean isEmpty(){
        return list.isEmpty();
    }
    
    int getSize(){
        return list.size();
    }
    
    public String peek() {
        return list.get(getSize() - 1);  
    } 
    
    public String pop() { 
        String s = list.get(getSize() - 1); 
        list.remove(getSize() - 1); 
        return s; 
    } 
    
    public void push(String s) {
        list.add(s);   
    } 
    
    @Override 
    public String toString() { 
        return list.toString(); 
    } 
    
    
    
    
    
}
