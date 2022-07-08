package projectmanagementsystem;
//import java.util.Stack;

import java.io.*;
import java.util.*;
import javax.swing.JTextField;

public class Task {
    
    int ID;
    String TaskName;
    float TaskPercentage;

    public int getID() {
        return ID;
    }

    public String getTaskName() {
        return TaskName;
    }

    public float getTaskPercentage() {
        return TaskPercentage;
    }

    public ArrayList<Double> getCompletionOfTasks() {
        return CompletionOfTasks;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTaskName(String TaskName) {
        this.TaskName = TaskName;
    }

    public void setTaskPercentage(float TaskPercentage) {
        this.TaskPercentage = TaskPercentage;
    }

    public void setCompletionOfTasks(ArrayList<Double> CompletionOfTasks) {
        this.CompletionOfTasks = CompletionOfTasks;
    }

    public Task(int ID, String TaskName, float TaskPercentage, String task) {
        this.ID = ID;
        this.TaskName = TaskName;
        this.TaskPercentage = TaskPercentage;
        this.task = task;
    }
    
    // array to save the percentage of competion of tasks
    private ArrayList<Double> CompletionOfTasks = new ArrayList<>();
    String task;
    public Task(){ // no arg-constructor
        
    }
    Task(String task,int id){  // constructor with specific arguments
        this.task = task; 
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    public String getTask() {
        return task;
    }
    
    public int viewTasks (){
        return 0;            
    }
      
    public boolean checkTasks () {
             
        for (int i =0; i <arrTasks.getSize; i++)
                    
        if (arrTasks.get(i)==100)
          return true;
         
        return false;    
    }



   public boolean checkTasks(JTextField jTextFieldID, JTextField jTextFieldName, String text)throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    float getCompletionOfTask(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class arrTasks {

        private static int getSize;

        private static int get(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public arrTasks() {
        }
    }

    private static class tasks {

        public tasks() {
        }
    }
    
  
    
    
    
}
