package Model;

import Controller.Controller;

public class Company {

    public Company() {
        Controller controller = new Controller();
        controller.initCompany();
    }
    
    public static void main(String[] args) {
        Company company = new Company();
    }
}
