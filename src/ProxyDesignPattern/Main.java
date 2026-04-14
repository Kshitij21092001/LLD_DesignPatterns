package ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        try{
            EmployeeDB employeeDB = new EmployeeDBProxy();
            employeeDB.createEmployee("ADMIN",new Employee());
            System.out.println("Success");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
