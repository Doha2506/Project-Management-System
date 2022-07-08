/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static projectmanagementsystem.Employee.file;


/**
 *
 * @author ali
 */
public class TeamLeader extends Employee{
    public static File penFile = new File("Penalities.txt"); 
    
    TeamLeader(){
        
    }
    
    TeamLeader(String name,int id,double salary,String dept){ // no arg-constructor
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
        this.setDepartment(dept);

    }
    
    File file2 = new File("Penalities.txt"); 
    void setPenaltiess (int id , int value)throws IOException{
        PrintWriter output = new PrintWriter(file2); 
         if(value <=31)
         {
            JOptionPane.showMessageDialog(null,"value valid","success",JOptionPane.INFORMATION_MESSAGE);
            if(searchId(id) == true)
            {
                double salary = getMainSalary(id);
                output.print((id +"\t"+salary+"\t"+value));
                output.close();
                JOptionPane.showMessageDialog(null,"id exist","success",JOptionPane.INFORMATION_MESSAGE);
            }
            else
               JOptionPane.showMessageDialog(null,"id can't exist","error",JOptionPane.ERROR_MESSAGE);
              
        }
        else
            JOptionPane.showMessageDialog(null,"value unvalid","error",JOptionPane.ERROR_MESSAGE);
               
     }
                    
    double getMainSalary(int id) throws FileNotFoundException
    {
            double salaryy = 0;
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
            int id2 = input.nextInt();
                  if(id == id2)
                  {
                       input.next();
                       input.next();
                       input.next();
                       input.next();
                       salaryy = input.nextDouble();
                  }
                  input.nextLine();
              }
              input.close();
              return salaryy;
    }
         
         
      boolean searchId(int id)throws IOException,FileNotFoundException
         {
          Scanner input = new Scanner(file);
              while (input.hasNext()) {
                  int id2 = input.nextInt();
                  if(id == id2)
                  {
                     return true; 
                  }
                  input.nextLine();
              }
              input.close();
         return false;
         }
      
      
     File file3 = new File("tasksFile.txt");
      boolean setTask2(int id,String task)throws IOException,FileNotFoundException
      {
       if(searchId(id) == true){
              if(file3.length() == 0){
              PrintWriter output = new PrintWriter(file3);
              output.println(id +"\t"+task+"\t"+ "0");
              output.close();}
             
             else{ 
              int counter = 0;
              Scanner input = new Scanner(file3);
              while(input.hasNext()){
              int id2 = input.nextInt();
               if(id == id2){
                counter++;
                }
                input.next();
                input.nextLine();             
              }  input.close();
               if(counter > 5)
               {
                 return false;
               }      
                FileWriter fw =new FileWriter(file3.getAbsoluteFile(),true);
                BufferedWriter output=new BufferedWriter(fw);
                output.write(id +"\t"+task+"\t" + "0");
                output.newLine();
                output.close();    
             }
            
      JOptionPane.showMessageDialog(null,"id exist","success",JOptionPane.INFORMATION_MESSAGE);
       }
        else
       {
            JOptionPane.showMessageDialog(null,"id can't exist","error",JOptionPane.ERROR_MESSAGE);
       }
       return true;
      }
    
     
       int setNoTasks()throws FileNotFoundException
       {
            int counter = 0;
            Scanner input = new Scanner(file3);
            while(input.hasNext()){
            input.nextInt();
            counter++;
            input.nextLine();
            }
           input.close();
           return counter;
       }
     
       String[] viewCompletedTasks()throws FileNotFoundException
       {
           int size = setNoTasks();
           String array[] = new String[size];
           Scanner input = new Scanner(file3);
           double c = 0;
           int i = 0;
           while (input.hasNext()) {
                  input.nextInt();
                  String s = input.next();
                  c = input.nextDouble();
                  input.nextLine();
                  if(i < array.length){
                  if(c == 100f)
                  {
                      array[i] = s;
                      i++;
                  }
              }
            }
             input.close();
             return array;
    
       }
          
      
      File file4 = new File("reports.txt");
      
      String[] getReport()throws IOException,FileNotFoundException
      {
                
              Scanner input = new Scanner(file4);
              int id;
               String array[] = new String[10];
                 int i = 0;
              while (input.hasNext()) {
                int x = input.nextInt();
                String y = input.next();
                String b = Integer.toString(x);
                 if(i < array.length){
                    array[i] = b +"                  "+ y + "                 "  ;
                     i++;
                 }
            }
        
             input.close();
             return array; 
      }
        
}

    
       
    

