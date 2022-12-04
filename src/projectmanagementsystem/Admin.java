/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static projectmanagementsystem.Employee.file;
import static projectmanagementsystem.Employee.temp;
import static projectmanagementsystem.Login.checkExistenceOfEmployee;
import static projectmanagementsystem.Employee.modifyFile;
import static projectmanagementsystem.Employee.sortFile;

/**
 *
 * @author ali
 */
public class Admin extends Employee {
    
    Admin(){ // no-arg constructor
        
    }
    
    
    Admin(String name,int id,double salary,String dept,int vac){ 
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
        this.setDepartment(dept);
        this.setVacationDaysPerYear(vac);
    }
    

//    void deleteFromFile(String filePath,String term) throws IOException{
//       File oldFile = new File(filePath);
//       File newFile = new File("temp.txt");
//       String name = "";String id = ""; String dept = "";
//       String salary = "";String tasks = "";
//        
//      
//            FileWriter fw = new FileWriter("temp.txt",true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            Scanner input = new Scanner(new File(filePath));
//            input.useDelimiter("[\t\n]");
//            while(input.hasNext()){
//                id = input.next();
//                name = input.next();
//                salary = input.next();
//                dept = input.next();
//                tasks = input.next();
//                if(! id.equals(term)){
//                    pw.println(id + "\t" + name + "\t" + salary + "\t" + 
//                            dept + "\t" + tasks);
//                }
//            }
//            input.close();
//            pw.flush();
//            pw.close();
//            oldFile.delete();
//            File dump = new File(filePath);
//            newFile.renameTo(dump);
//        
//       
//        
//    }
     
 
    // add employee
    static void writeEmployee(Employee e) throws IOException{
        boolean result = checkID(e);
        if(result == true){  // if the id is valid
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);   
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n" + e.getId()+"\t"+ e.getPosition()+"\t" + e.getName()+ "\t"+ e.getDepartment() +
                "\t" + e.getVacationPerYear()+ "\t"+ e.getSalary() + "\t" 
                    + e.getWorkingHoursOverMonth() + "\n");
            
            bw.close();
            JOptionPane.showMessageDialog(null,"Added Successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null,"Addition failed", "ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    private static boolean checkID(Employee e) throws IOException {
    if(file.length() == 0)
        return true; // means that the file is empty and you can add employees
    else{
        Scanner input = new Scanner(file);
        
        while (input.hasNextLine()) {
            String id = input.next();   // read the id
            int result = Integer.parseInt(id);  // convert it from string to integer
            if(e.getId() == result){
                JOptionPane.showMessageDialog(null," ID Must be unique", "ERROR",JOptionPane.ERROR_MESSAGE);
                return false;  // means we have an employee of this id
            }
            input.nextLine();   // ignore the rest of the line
        }
        input.close();
    }
    return true;// means that we don't have employee of this id
}
    
    
    // update position
    static boolean updatePosition(int id,String name,String pos) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                int ID = input.nextInt();
                if(id == ID){
                    String position = input.next();
                    input.next(); //ignore the name because it came as paremter
                    String dept = input.next();
                    String Vac = input.next();
                    String salary = input.next();
                    String hours = input.next();
                    String oldContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+salary+"\t"+hours;

                    String newContent = Integer.toString(ID) +"\t"+pos+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+salary+"\t"+hours;

                    if(modifyFile(oldContent,newContent) == true){
                       sortFile();
                       temp.delete();
                       return true;
                    } 
                }
                input.nextLine();
            }
            input.close();
        }
        return false;
    }
         
    // update department
     static boolean updateDepartment(int id,String name,String dept) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                int ID = input.nextInt();
                if(id == ID){
                    String position = input.next();
                    input.next(); //ignore the name because it came as paremter
                    String depart = input.next();
                    String Vac = input.next();
                    String salary = input.next();
                    String hours = input.next();
                    String oldContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                depart+"\t"+Vac+"\t"+salary+"\t"+hours;

                    String newContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+salary+"\t"+hours;

                    if(modifyFile(oldContent,newContent) == true){
                       sortFile();
                       temp.delete();
                       return true;
                    } 
                }
                input.nextLine();
            }
            input.close();
        }
        return false;
    }
    
     
    // update salary
    static boolean updateSalary(int id,String name,double sal) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                int ID = input.nextInt();
                if(id == ID){
                    String position = input.next();
                    input.next(); //ignore the name because it came as paremter
                    String dept = input.next();
                    String Vac = input.next();
                    String salary = input.next();
                    String hours = input.next();
                    String oldContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+salary+"\t"+hours;

                    String newContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+sal+"\t"+hours;

                    if(modifyFile(oldContent,newContent) == true){
                       sortFile();
                       temp.delete();
                       return true;
                    } 
                }
                input.nextLine();
            }
            input.close();
        }
        return false;
    }
    
    
    // upate working ours over month
    static boolean updateWorkingHours(int id,String name,double entry,double exit) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            double newHours = computeWorkingHoursOverMonth(entry,exit);
            System.out.println(newHours);
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                int ID = input.nextInt();
                if(id == ID){
                    String position = input.next();
                    input.next(); //ignore the name because it came as paremter
                    String dept = input.next();
                    String Vac = input.next();
                    String salary = input.next();
                    String hours = input.next();
                    String oldContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+salary+"\t"+hours;

                    String newContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                dept+"\t"+Vac+"\t"+salary+"\t"+Double.toString(newHours);

                    if(modifyFile(oldContent,newContent) == true){
                       sortFile();
                       temp.delete();
                       return true;
                    } 
                }
                input.nextLine();
            }
            input.close();
        }
        return false;
    }
    
    // delete employee
    static boolean deleteEmployee(int id,String name) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            Scanner input = new Scanner(file);
            while(input.hasNextLine()){
                int ID = input.nextInt();
                if(id == ID){
                    String position = input.next();
                    input.next(); //ignore the name because it came as paremter
                    String dept = input.next();
                    String Vac = input.next();
                    String salary = input.next();
                    String hours = input.next();
                    String oldContent = Integer.toString(ID) +"\t"+position+"\t"+name+"\t"+
                                   dept+"\t"+Vac+"\t"+salary+"\t"+hours;

                    if(modifyFile(oldContent) == true){
                        sortFile();
                        temp.delete();
                        return true;
                    } 
                }
                input.nextLine();
            }
            input.close();
        }
        return false;
}
   
     static boolean modifyFile(String oldContent) throws IOException {
        try{ 
            String line = "";
            Scanner input = new Scanner(file);
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

            while(input.hasNextLine()){
                line = input.nextLine();
               if(line.equalsIgnoreCase(oldContent))
                   continue;
                else
                    bw.write(line+"\n");
            }
            
            bw.close();
            input.close();
                 
            return true;
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
         return false;
     }
    
    
    
    
    
    
    
    
}
