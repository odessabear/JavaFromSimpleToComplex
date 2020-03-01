package generics.company;

import generics.company.employees.Accountant;
import generics.company.employees.ITSpecialist;
import generics.company.employees.Manager;

public class CompanyMain {
    public static void main(String[] args) {

        Company company = new Company();

        Department<Accountant> accounting = new Department<>("Accounting",5);
        Department<Manager> management = new Department<>("Management",2);
        Department<ITSpecialist> itGuys = new Department<>("Management",10);

        Accountant accountant = new Accountant("Alex",1000.0f);
        ITSpecialist it = new ITSpecialist("James",2000.0f);
        Manager manager = new Manager("Michel",4000.0f);

        accounting.addEmployee(accountant);
        itGuys.addEmployee(it);
        management.addEmployee(manager);
    }
}
