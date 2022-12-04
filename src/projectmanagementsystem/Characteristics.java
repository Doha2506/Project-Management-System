/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

/**
 *
 * @author ali
 */
public class Characteristics {
    private String name;
    private int id;
    private double salary;
    private String department;
    
    
    
    Characteristics(){ //no arg-consructor
     // intialize name to null , id to 0 , salary to 0
    }
    // constructor with specific arguments 
    Characteristics(String name,int id,double salary,String dept){
        this.name = name;
        this.id = id;
        this.salary = salary;
        department = dept;
    }
    
    void setName(String name){
        this.name = name;
    }
    
    String getName(){
        return name;
    } 
    
    void setId(int id){
        this.id = id;
    }
    int getId(){
        return id;
    }
    
    void setSalary(double salary){
        this.salary = salary;
    }
    
    double getSalary(){
        return salary;
    }
    
    void setDepartment(String dept){
        department = dept;
    }
    
    String getDepartment(){
        return department;
    }
    
    
    
    
    
    
}
