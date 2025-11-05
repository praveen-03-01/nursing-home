/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.citynursinghome;

public class Consultant {
    private String name;
    private String specialization;

    public Consultant(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }

    public String toFileString() {
        return name + "," + specialization;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Specialization: " + specialization;
    }
}