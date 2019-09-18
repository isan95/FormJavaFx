/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polanco.FormJavaFx.Data;

import java.time.LocalDate;
import java.util.Calendar;
import javafx.scene.control.RadioButton;

/**
 *
 * @author POLANCO
 */
public class Client {
    private String cod;
    private String name;
    private String lastName;
    private String motherLastName;
    private String DNI;
    private LocalDate fNacimiento;
    private String status;
    private String mail;
    private String user;
    private String pass;
    private RadioButton sex;

    public Client(String cod, String name, String lastName, String motherLastName, String DNI, LocalDate fNacimiento, String status, String mail, String user, String pass, RadioButton sex) {
        this.cod = cod;
        this.name = name;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.DNI = DNI;
        this.fNacimiento = fNacimiento;
        this.status = status;
        this.mail = mail;
        this.user = user;
        this.pass = pass;
        this.sex = sex;
    }

    public Client(){
        this.cod = null;
        this.name = null;
        this.lastName = null;
        this.motherLastName = null;
        this.DNI = null;
        this.fNacimiento = null;
        this.status = null;
        this.mail = null;
        this.user = null;
        this.pass = null;
        this.sex = null;
    }
    
    

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(LocalDate fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public RadioButton getSex(){
        return sex;
    }

    public void setSex(RadioButton sex){
        this.sex = sex;
    }
    
}
