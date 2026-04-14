package ProxyDesignPattern;

public interface EmployeeDB {
    public void createEmployee(String client,Employee obj) throws Exception;
    public void deleteEmployee(String client,int employeeID) throws Exception;
    public Employee getEmployee(String client,int employeeID) throws Exception;
}
