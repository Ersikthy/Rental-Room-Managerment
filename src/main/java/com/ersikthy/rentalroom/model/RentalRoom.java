package com.ersikthy.rentalroom.model;

import com.ersikthy.rentalroom.controller.log.Input;

import java.util.*;

import static com.ersikthy.rentalroom.controller.log.Output.*;

public class RentalRoom {
    private String id;
    private String name;
    private int maxTenant;
    private double area;
    private String status = "Available";
    private int pricing;
    private int deposit;
    private String roomType;
    private Map<String, Integer> utilityRates = new HashMap<>();
    private String description;
    private String address;
    private ArrayList<Tenant> inRoomTenant = new ArrayList<>();

    public RentalRoom() {
    }

     public enum RoomType {
        TIER_1("Tier 1"),
        TIER_2("Tier 2"),
        TIER_3("Tier 3");

        private final String label;

        RoomType(String label) {this.label = label;}

        public String getLabel() {
            return label;
        }
    }

    public static String selectRoomType(Scanner scanner) {
        println("Select Room Type:", null);
        println("[1].Tier 1", null);
        println("[2].Tier 2", null);
        println("[3].Tier 3", null);

        while (true) {
            int choice = Input.readInt(scanner, "Enter choice (1-3): ");

            switch (choice) {
                case 1 -> {
                    return RoomType.TIER_1.getLabel();
                }
                case 2 -> {
                    return RoomType.TIER_2.getLabel();
                }
                case 3 -> {
                    return RoomType.TIER_3.getLabel();
                }
            }
        }
    }

    public enum Status {
        AVAILABLE("Available"),
        FUll("Full"),
        QUEUE("Queue"),
        MAINTENANCE("Maintenance");

        private final String label;

        Status(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    public static String selectStatus(Scanner scanner) {
        println("Select Room Status: ", null);
        println("[1].Available", null);
        println("[2].Rented out", null);
        println("[3].Maintenance", null);

        while (true) {
            int choice = Input.readInt(scanner, "Enter choice (1-3): ");

            switch (choice) {
                case 1 -> {
                    return Status.AVAILABLE.getLabel();
                }
                case 2 -> {
                    return Status.FUll.getLabel();
                }
                case 3 -> {
                    return Status.MAINTENANCE.getLabel();
                }
                default -> warn("Invalid choice! Select 1, 2 or 3");
            }
        }
    }

    public RentalRoom(
            String name,
            int maxTenant,
            double area,
            String status,
            String roomType,
            int pricing,
            Map<String, Integer> utilityRates,
            String description,
            String address,
            int deposit) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.maxTenant = maxTenant;
        this.area = area;
        this.status = status;
        this.roomType = roomType;
        this.pricing = pricing;
        this.description = description;
        this.address = address;
        this.deposit = deposit;
        this.utilityRates = utilityRates;

    }

    public ArrayList<Tenant> getInRoomTenant() {
        return inRoomTenant;
    }

    public void setInRoomTenant(ArrayList<Tenant> inRoomTenant) {
        this.inRoomTenant = inRoomTenant;
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

    public int getMaxTenant() {
        return maxTenant;
    }

    public void setMaxTenant(int maxTenant) {
        this.maxTenant = maxTenant;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPricing() {
        return pricing;
    }

    public void setPricing(int pricing) {
        this.pricing = pricing;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public Map<String, Integer> getUtilityRates() {
        return utilityRates;
    }

    public void setUtilityRates(Map<String, Integer> utilityRates) {
        this.utilityRates = utilityRates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Room{ _id: '" + id + "', name= '" + name + "', maxTenant= '" + maxTenant + "', description= '" + description + "', area= '" + area + "', pricing= '" + pricing + "', status= '" + status + "', location= '" + address + "'}";
    }
}
