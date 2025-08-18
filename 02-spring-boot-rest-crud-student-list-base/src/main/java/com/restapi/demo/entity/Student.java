package com.restapi.demo.entity;
/* step 1:
create new package
    ->create java pojo class
    ->give field and default and parameterised constructor
    ->apply getter and setter methods to convert json to pojo and pojo to json
 */
/* Step 2:
    create new restcontroller StudentRestController
    ->create method  to return list
        -> add students using list
 */
public class Student {
    private String firstName;

    private String lastName;

    public Student(){

    }

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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
}
