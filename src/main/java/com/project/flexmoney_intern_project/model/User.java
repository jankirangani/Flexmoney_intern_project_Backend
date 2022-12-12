package com.project.flexmoney_intern_project.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "joiningDate")
    private String joiningDate;
    @Column(name = "lastDate")
    private String lastDate;

    @Column(name="batch")
    private String batch;

    @Column(name="payment")
    private String payment;

    public User() {
    }

    public User(String firstName, String lastName, Integer age, String joiningDate,String batch,String payment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.joiningDate = joiningDate;
        this.batch = batch;
        this.payment = payment;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate() {
        Integer year = Integer.parseInt(joiningDate.substring(0,4));
        Integer month = Integer.parseInt(joiningDate.substring(5,7));
        Integer date = Integer.parseInt(joiningDate.substring(8));

        if(month ==12){
            month =1;
            year+=1;

        }
        else {
            month+=1;
        }

        String Fmonth;
        if(month < 10){
            Fmonth ="0" +Integer.toString(month);
        }else{
            Fmonth = Integer.toString(month);
        }
        String Fdate;
        if(date < 10){
            Fdate ="0" +Integer.toString(date);
        }else{
            Fdate = Integer.toString(date);
        }

        String Fyear = Integer.toString(year);

        String finalDate = Fyear+'-'+Fmonth+'-'+Fdate;
        this.lastDate = finalDate;

    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", joiningDate='" + joiningDate + '\'' +
                ", lastDate='" + lastDate + '\'' +
                ", batch='" + batch + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id);
    }

    @Override
    public int hashCode() {
        return  (int) (Id ^ (Id >>> 32));
    }
}
