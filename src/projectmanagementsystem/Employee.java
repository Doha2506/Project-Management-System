/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementsystem;

import java.io.*;
import java.util.*;
import static projectmanagementsystem.Login.checkExistenceOfEmployee;
import static projectmanagementsystem.TeamLeader.penFile;

/**
 *
 * @author ali
 */
public class Employee extends Characteristics {
    public static File file = new File("Employees File.txt");
    private String position= "Employee";
    private long entryTime;
    private long exitTime;
   
    private int vacationDaysPerYear = 3;
    
    Employee(){ // no arg-constructor
        
    }
    
    // constructor with specific parameter
    Employee(String name,int id,double salary,String dept){
        // call the constructor of Characteristics and passing paremeter to it
        super(name,id,salary,dept);
        
    }
    
    void setVacationDaysPerYear(int vac){
        vacationDaysPerYear = vac;
    }
    int getVacationPerYear(){
        return vacationDaysPerYear;
    }
    

    void setEntryTime(int entryTime){
        this.entryTime = entryTime;
    }
    
    void setExitTime(int exitTime){
        this.exitTime = exitTime;
    }
    
    void setPosition(String pos){
        this.position = pos;
    }
    String getPosition(){
        return this.position;
    }

    double getWorkingHoursOverMonth(){ // calculate working hours over month.
        double workingHours = exitTime - entryTime;   // working hours in milliseconds over day
        workingHours *= 30;  // working hours in miilisecond over month 
        return workingHours;  
    }
    
    static double computeWorkingHoursOverMonth(double entry,double exit){  // with parameters
        double workingHours = exit - entry;   // working hours in hour over day
        workingHours *= 30;  // working hours in hours over month 
        return workingHours;
    }


    // view working hours over month
    static String getHours(int id,String name) throws IOException{
        String workingHours = null;
        if(checkExistenceOfEmployee(id,name) == true){
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                if(id == input.nextInt()){// read the id 
                    input.next();  // ignore position
                    input.next();  // ignore name
                    input.next(); // ignore department
                    input.next();   // ignore vacation days
                    input.next();  // ignore salary
                    workingHours = input.next();  // saving working hours 
                }
                input.nextLine();
            }
        }
        return workingHours;
    }
    
    // request vacation
     protected static boolean requestVacation(int id,String name) throws IOException{
        if(checkExistenceOfEmployee(id,name) == true){
            String oldContent = "",newContent = "";
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) { 
                int ID = Integer.parseInt(input.next());
                if(id == ID){
                    String pos = input.next();
                    input.next(); // ignore the name because it came as paremter
                    String dept = input.next();
                    int oldVac = input.nextInt();
                    String salary = input.next();
                    String hours = input.next();
                    
                    int newVac = oldVac - 1;
                    
                    //  request vacation
                    if(newVac >= 0){
                        oldContent = Integer.toString(ID) +"\t"+pos+"\t"+name+"\t"+
                            dept+"\t"+Integer.toString(oldVac)+"\t"+salary+"\t"+hours;
                   
                        newContent = Integer.toString(ID) +"\t"+pos+"\t"+name+"\t"+
                            dept+"\t"+Integer.toString(newVac)+"\t"+salary+"\t"+hours;
                    }
                    else
                        return false;
                }
                    input.nextLine();
                }
                input.close();
            
            if(modifyFile( oldContent, newContent)==true){
                sortFile();
                temp.delete();
            }
        }
        return true;
    }
    
    static File temp = new File("tempFile.txt");
    static boolean modifyFile(String oldContent,String newContent) throws IOException {
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
            bw.write(newContent+"\n");

            bw.close();
            input.close();
                 
            return true;
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
         return false;
     }
    
    static void sortFile() throws IOException{
        ArrayList<String> rows = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(temp));

        String s;
        while((s = reader.readLine())!=null)
            rows.add(s);

        Collections.sort(rows);
        
        FileWriter writer = new FileWriter(file);
        for(String cur: rows)
            writer.write(cur+"\n");

       reader.close();
       writer.close();
    }

    
    // view penalties
    
     double computePenalities(int id) throws IOException{
        double salary = 0;
        int day = 0;
        Scanner input = new Scanner(penFile);
        while (input.hasNextLine()) { 
            if(id == input.nextInt()){// read the id 
                salary = input.nextDouble(); // read the main salay and convert it to double 
                day = input.nextInt(); // convert it to string
                break;
            }
            input.nextLine();   // ignore the rest of the line
        }
        input.close();
        double salPerDay = (salary/30);
        double newSal = salary - (salPerDay * day);
        return newSal;
    } 
  
    
    double getMainSalary(int id,String name) throws IOException{
       boolean r = checkExistenceOfEmployee(id,name);
        if(r==true){ 
        Scanner input = new Scanner(penFile);
        while (input.hasNextLine()) {
            if(id == input.nextInt()){// read the id
                return input.nextDouble(); // read the main salay and convert it to double 
            }
            input.nextLine();   // ignore the rest of the line
        }
        input.close();
        }
        return -1;
    }
    
    
    
    
    
    
}
