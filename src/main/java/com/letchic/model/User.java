package com.letchic.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String middleName;
    private String age;
    private String salary;
    private String email;
    private String workAddres;
    private String browserName;
    private String timeZone;

    public String getTimeZone() {

        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkAddres() {
        return workAddres;
    }

    public void setWorkAddres(String workAddres) {
        this.workAddres = workAddres;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public List<String> getuser () {
         List<String> list = new ArrayList();
         list.add(firstName);
         list.add(lastName);
         list.add(middleName);
         list.add(age);
         list.add(salary);
         list.add(email);
         list.add(workAddres);
         return list;
    }

    public String getFileName() {
        return firstName+lastName;
    }


        public String readFromCsvFile(MultipartFile file){

            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String[] fields = null;
                    String s = new String(bytes);

                    fields = s.split(";");
                    if (fields.length!=7) {
                        return "Invalid file!";
                    }

                      firstName=fields[0];
                      lastName=fields[1];
                      middleName=fields[2];
                      age=fields[3];
                      salary=fields[4];
                      email=fields[5];
                      workAddres=fields[6];

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "User added";
        }


}




