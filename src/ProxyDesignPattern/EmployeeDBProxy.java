package ProxyDesignPattern;

import java.util.Objects;

public class EmployeeDBProxy implements  EmployeeDB {
    public EmployeeDB employeeDB;

    public EmployeeDBProxy() {
        this.employeeDB = new EmployeeDBImpl();
    }

    @Override
    public void createEmployee(String client,Employee obj) throws Exception {
        if(Objects.equals(client, "ADMIN")){
            employeeDB.createEmployee(client,obj);
            return;
        }

        throw new Exception("Access denied");
    }

    @Override
    public void deleteEmployee(String client,int employeeID) throws Exception {
        if(Objects.equals(client, "ADMIN")){
            employeeDB.deleteEmployee(client,employeeID);
            return;
        }

        throw new Exception("Access denied");
    }

    @Override
    public Employee getEmployee(String client,int employeeID) throws Exception {
        if(Objects.equals(client, "ADMIN")){
            return employeeDB.getEmployee(client,employeeID);
        }

        throw new Exception("Access denied");
    }
}
