/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.citynursinghome;

import java.io.*;
import java.util.ArrayList;

public class Database {
    private static final String PATIENT_FILE = "patients.txt";
    private static final String CONSULTANT_FILE = "consultants.txt";
    private static final String USER_FILE = "user.txt";

    public ArrayList<Patient> loadPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATIENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    patients.add(new Patient(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            // File might not exist initially
        }
        return patients;
    }

    public void savePatients(ArrayList<Patient> patients) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATIENT_FILE))) {
            for (Patient p : patients) {
                bw.write(p.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }   

    public ArrayList<Consultant> loadConsultants() {
    ArrayList<Consultant> consultants = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(CONSULTANT_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                consultants.add(new Consultant(parts[0].trim(), parts[1].trim()));
            }
        }
    } catch (IOException e) {
        // Initialize with default consultants if file doesn't exist
        consultants.add(new Consultant("Dr. Smith", "Cardiology"));
        consultants.add(new Consultant("Dr. Jones", "Neurology"));
        saveConsultants(consultants);
    }
    return consultants;
}

    public void saveConsultants(ArrayList<Consultant> consultants) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CONSULTANT_FILE))) {
            for (Consultant c : consultants) {
                bw.write(c.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving consultants: " + e.getMessage());
        }
    }

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            // File might not exist initially
            // Could add default users here if needed
        }
        return users;
    }

    public void saveUsers(ArrayList<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User u : users) {
                bw.write(u.getUsername() + "," + u.getPassword() + "," + u.getRole());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    // Method to save a single user (for createUser functionality)
    public void saveUser(User user) {
        ArrayList<User> users = loadUsers();
        users.add(user);
        saveUsers(users);
    }
    
    public User authenticate(String username, String password) {
    ArrayList<User> users = loadUsers();
    
    for (User user : users) {
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return user; // Return the authenticated user
        }
    }
    return null; // Return null if authentication fails
    }
}