/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author doha
 */
public class functions {
    
    private String Name;
    private int Salary;
    private int ID;
    private String Tasks;
    private String Fundays;
    private String Panelties;
    
/*    public static void functions(int id,int salary,String name);
    {        
        ID=id;
        Salary=salary;
        Name=name;
        
    }
 */  
    
public class Admin {
    public void view(Employee employee) {
        System.out.println(employee.toString());
    }

    public void update(Employee employee, int id, double salary, ArrayList<Employee> emps) {
        int index = emps.indexOf(employee);
        employee.setId(id);
        employee.setSalary(salary);
        emps.listIterator(index).set(employee);
    }
}
    
    public static void View()
    {
        
    }
    
    public static void Update()
    {
        
    }
    
    public static void Delete()
    {
        
    }
    
    public static void Add()
    {
        
    }
}


