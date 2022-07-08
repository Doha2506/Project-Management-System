
package projectmanagementsystem;


public class PM extends Employee{
    private String report;
    private int counter ;
    PM(){
        //constructor without prameter
    }
         
    PM(String name , int id ,double salary ,String dept , int vac){
        this.setName(name);
        this.setId(id);
        this.setSalary(salary);
        this.setDepartment(dept);
        this.setVacationDaysPerYear(vac);

    }

     public double getCompletionProject(Task t1){
         for(int i=0; i<t1.getSize(); i++){
             if(t1.getCompletionOfTask(i)==100f)
              counter++;
         }
         return((counter/t1.getSize())*100);
     }
      
        
         public void setReport(Employee e,String text) {
        report="Report on employee of id ("+e.getId()+") is ('"+text+"') .";
         }
         
         public String getReport(){
             return report; 
         }

    
    
         
}
