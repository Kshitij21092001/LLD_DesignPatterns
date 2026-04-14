package ProxyDesignPattern;

public class EmployeeDBImpl implements EmployeeDB {
    @Override
    public void createEmployee(String client,Employee obj) throws Exception {
        System.out.println("Created new row in Employee table");
    }

    @Override
    public void deleteEmployee(String client, int employeeID) throws Exception {
        System.out.println("Deleted row in Employee table");
    }

    @Override
    public Employee getEmployee(String client, int employeeID) throws Exception {
        System.out.println("Retrieved row in Employee table");
        return new Employee();
    }
}
