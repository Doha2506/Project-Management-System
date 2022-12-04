/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import static projectmanagementsystem.Employee.file;
import static projectmanagementsystem.Login.checkExistenceOfEmployee;

/**
 *
 * @author abdo ali
 */
public class TeamLeader extends Employee {
    public static File penFile = new File("Penalities.txt"); 
    
    TeamLeader(){
        
    }
    
    TeamLeader(String name,int id,double salary,String dept){ // no arg-constructor
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
        this.setDepartment(dept);

    }
    
    protected boolean setPen(int id,String name,int value) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            double salary = getMainSalary(id);
            if(value <=31){
                if(penFile.length() == 0){ // if first time
                    FileWriter fw = new FileWriter(penFile.getAbsoluteFile(), true);   
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(id + "\t" + salary + "\t"+ value + "\n");  // add the task 
                    bw.close();
                    return true;
                }
                else{
                    Scanner input = new Scanner(penFile);
                    while(input.hasNextLine()){   // search for old penalties and chanege it
                        int ID = input.nextInt();
                        if(id == ID){
                            input.nextDouble(); // ignore salary because we already save it
                            int val = input.nextInt();
                            String oldContent = id + "\t" + salary + "\t" + val;
                            String newContent = id + "\t" + salary + "\t" + value;
                            if(modifyPenFile(oldContent,newContent) == true){
                                sortPenFile();
                                temp.delete();
                                return true;
                            }
                            else
                                JOptionPane.showMessageDialog(null,"ERROR !!", "ERROR",JOptionPane.ERROR_MESSAGE);

                        }
                        input.nextLine();
                    }
                    input.close();
                    // if not found any old penalties , write the new penalties
                    FileWriter fw = new FileWriter(penFile.getAbsoluteFile(), true);   
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(id +"\t"+ salary + "\t"+ value+"\n");
                    bw.close();
                    sortPenFile2();
                    return true;
                    
                }
            } 
            else
                JOptionPane.showMessageDialog(null,"Invalid Value", "ERROR",JOptionPane.ERROR_MESSAGE);

            
        }
       
        return false; // if id is not valid
    }
    
    
   private double getMainSalary(int id) throws IOException{
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
            if(id == input.nextInt()){
                input.next();
                input.next();
                input.next();
                input.next();
                return input.nextDouble(); // return salary
            }
            input.nextLine();
        }
        return -1;
    }
    
    private static boolean modifyPenFile(String oldContent,String newContent) throws IOException {
        try{ 
            String line = "";
            Scanner input = new Scanner(penFile);
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
    
    private static void sortPenFile() throws IOException{
        ArrayList<String> rows = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(temp));

        String s;
        while((s = reader.readLine())!=null)
            rows.add(s);

        Collections.sort(rows);
        
        FileWriter writer = new FileWriter(penFile);
        for(String cur: rows)
            writer.write(cur+"\n");

       reader.close();
       writer.close();
    }
    private static void sortPenFile2() throws IOException{
        ArrayList<String> rows = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(penFile));

        String s;
        while((s = reader.readLine())!=null)
            rows.add(s);

        Collections.sort(rows);
        
        FileWriter writer = new FileWriter(penFile);
        for(String cur: rows)
            writer.write(cur+"\n");

       reader.close();
       writer.close();
    }
    
    
}
