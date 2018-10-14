package Model;

import Controller.Controller;
import Controller.JSONReadFromFile;

public class Company {

    public Company() {
        JSONReadFromFile json = new JSONReadFromFile();
    }
    
    public static void main(String[] args) {
        Company company = new Company();
    }
}
