/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;
//import java.util.Stack;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import static projectmanagementsystem.Employee.file;
import static projectmanagementsystem.Employee.temp;

/**
 *
 * @author ali
 */
public class Task {
    
    String task;
    public static File tasksFile = new File("tasksFile.txt");
    
    Task(){ // no arg-constructor
        
    }
    Task(String task){  // constructor with specific arguments
        this.task = task; 
    }
   
    String getTask(){
        return task;
    }
    
    static void writeTask(String s,int id) throws IOException{
        int counter = 0; boolean repeated = false;
        if(tasksFile.length() == 0){  // if the task file is empty
            FileWriter fw = new FileWriter(tasksFile.getAbsoluteFile(), true);   
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(id + "\t" + s + "\t0" + "\n");  // add the task 
            bw.close();
            JOptionPane.showMessageDialog(null,"Added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
        }
        else{   // if the task file not empty and has tasks 
            Scanner input = new Scanner(tasksFile);
                while (input.hasNextLine()) {
                    int ID = input.nextInt();  // read the id
                    if(id == ID){
                        counter++;  // count the number of tasks to this employee     
                    }
                    String taskName = input.next();  // take the task in string
                    if(taskName.equals(s)){ // compare it with the task that come from user
                        repeated = true;
                        JOptionPane.showMessageDialog(null,"This Employee already has this task", "ERROR",JOptionPane.ERROR_MESSAGE);
                        // if true say that he can't add the same task
                        break;
                    }
                    input.nextLine(); // ignore the rest of the line
                }
            input.close();

            if(counter < 5 && repeated == false){  // if the number of tasks less than 5
                FileWriter fw = new FileWriter(tasksFile.getAbsoluteFile(), true);   
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(id + "\t" + s + "\t0" + "\n");
                bw.close();
                JOptionPane.showMessageDialog(null,"Added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(counter >= 5){
                JOptionPane.showMessageDialog(null,"This Employee has enough tasks", "ERROR",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null,"Addition Faild", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"Addition Faild", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    
    // check if the employee is exist in the company
    protected static boolean checkExistenceOfEmployee(int id) throws IOException { 
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            if(id ==  input.nextInt()){ // read the id
                input.close();
                return true;  // means we have an employee of this id
            }
            input.nextLine();   // ignore the rest of the line
        }
        input.close();
        JOptionPane.showMessageDialog(null,"We don't have employee with this ID", "ERROR",JOptionPane.ERROR_MESSAGE);
        return false;  // means that we don't have employee of this id
    }
    
    
    
    
    
    protected static boolean checkTask(int id,String name,double per) throws IOException{
        Scanner input = new Scanner(tasksFile);
        while (input.hasNextLine()) {
            int ID = input.nextInt();
            if(id == ID){  // if hte correct id
                String taskName = input.next();
                if(name.equals(taskName)){ // if the correct task name
                    double percentage = input.nextDouble();
                    String oldContent = Integer.toString(ID) + "\t" + taskName 
                        +"\t" + Double.toString(percentage);
                    String newContent = Integer.toString(ID) + "\t" + taskName 
                        +"\t" +Double.toString(per);
                    
                    if(modifyTasksFile(oldContent,newContent) == true){
                        sortTasksFile();
                        temp.delete();
                        return true;
                    }
                    else
                        return false;
                }
            }
            input.nextLine();
        }
        input.close();
        return false;
    }
    
    
    private static boolean modifyTasksFile(String oldContent,String newContent) throws IOException {
        try{ 
            String line = "";
            Scanner input = new Scanner(tasksFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            while(input.hasNextLine()){
                line = input.nextLine();
                if(line.equalsIgnoreCase(oldContent))
                   continue;
                else
                    bw.write(line+"\n");
            }
            bw.write(newContent+"\n");

            bw.close();
            input.close();
                 
            return true;
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
     }
    
    
    
    private static void sortTasksFile() throws IOException{
        ArrayList<String> rows = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(temp));

        String s;
        while((s = reader.readLine())!=null)
            rows.add(s);

        Collections.sort(rows);
        
        FileWriter writer = new FileWriter(tasksFile);
        for(String cur: rows)
            writer.write(cur+"\n");

       reader.close();
       writer.close();
    }
    
    
    
    
    

    
   
}
