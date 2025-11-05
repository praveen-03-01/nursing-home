/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.citynursinghome;

public class Patient {
    private String id;
    private String name;
    private String category;

    public Patient(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }

    public String toFileString() {
        return id + "," + name + "," + category;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + category;
    }
}
