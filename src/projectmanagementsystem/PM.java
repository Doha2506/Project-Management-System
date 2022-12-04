/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.io.*;
import java.util.*;
import static projectmanagementsystem.Task.tasksFile;

/**
 *
 * @author abdo ali
 */
public class PM extends Employee {
    PM(){
        
    }
    PM(String name,int id,double salary,String dept){ // no arg-constructor
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
        this.setDepartment(dept);
    }
    
    double viewCompletionOfProject() throws IOException{
        double sum = 0;int cnt = 0;
        Scanner input = new Scanner(tasksFile);
        while(input.hasNextLine()){
            input.next();
            input.next();
            sum += input.nextDouble();
            cnt++;
            input.nextLine();
        }
        double percentage = (sum/(cnt*100))*100;
        return percentage;
    }
    
    
    
}
