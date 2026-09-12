package com.ersikthy.rentalroom.model;

import java.util.Scanner;
import java.util.UUID;

import static com.ersikthy.rentalroom.controller.log.Input.*;
import static com.ersikthy.rentalroom.controller.log.Output.*;

public class Tenant {
    private final String id;
    private String name;
    private long phone;
    private int age;
    private String gender;

    public Tenant (
            String name,
            int age,
            long phone,
            String gender
    ) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public enum Gender{
        MALE("Male"),
        FEMALE("Female"),
        GAY("Gay"),
        LES("Les");

        private final String label;

        Gender (String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public  static String selectGender(Scanner scanner) {
        println("Select Tenant Gender: ", null);
        println("[1].Male", null);
        println("[2].Female", null);
        println("[3].Gay", null);
        println("[4].Les", null);

        while (true) {
            int choice = readInt(scanner, "Enter choice (1-4): ");
            switch (choice) {
                case 1 -> {
                    return Gender.MALE.getLabel();
                }

                case 2 -> {
                    return Gender.FEMALE.getLabel();
                }

                case 3 -> {
                    return Gender.GAY.getLabel();
                }

                case 4 -> {
                    return Gender.LES.getLabel();
                }

                default -> warn("Invalid choice! Select 1, 2, 3 or 4");
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id + "." + name + " " + age + " " + phone + " " + gender;
    }
}
