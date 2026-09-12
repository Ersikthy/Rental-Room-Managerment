package com.ersikthy.rentalroom.controller.rentalroom;

import com.ersikthy.rentalroom.controller.menu.Menu;
import com.ersikthy.rentalroom.controller.rentalroom.inroom.Nav;
import com.ersikthy.rentalroom.model.RentalRoom;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.*;

public class ViewRoom {
    private ViewRoom() {
    }

    public static RentalRoom foundRoom = null;

    public static boolean chooseRoom(Scanner scanner) {

        print("Enter room name to see detail: ", null);
        String name = scanner.nextLine().trim();

        for (RentalRoom room : roomList) {
            if (room.getName().equalsIgnoreCase(name)) {
                foundRoom = room;
                return true;
            }
        }
        warn("Room with name" + name + " not found!");
        foundRoom = null;
        return false;

    }

        public static void displayRoom() {
        if(foundRoom == null) return;

        NumberFormat vnMoney = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        println("\n====================================", null);
        print("         ROOM DETAILS (", null);
        print("ID: " + foundRoom.getId(), Color.gray);
        println(")", null);
        println("====================================", null);
        println("Name        : " + foundRoom.getName(), null);
        println("Status      : " + foundRoom.getStatus(), null);
        println("Deposit     :" + vnMoney.format(foundRoom.getDeposit()) + "VND", null);
        println("Price/month : " + vnMoney.format(foundRoom.getPricing()) + " VND", null);
        println("Utility Rates: ", null);
        for (Map.Entry<String, Integer> entry : foundRoom.getUtilityRates().entrySet()) {
            println("               - " + entry.getKey() + ": " + vnMoney.format(entry.getValue()) + "VND", null);
        }
        println("Area        : " + foundRoom.getArea() + " m2", null);
        println("Max Tenants : " + foundRoom.getMaxTenant() + "       (In room: " + foundRoom.getInRoomTenant().size() + "/" + foundRoom.getMaxTenant() + ")", null);
        println("Address     : " + foundRoom.getAddress(), null);
        println("Description : " + foundRoom.getDescription(), null);
        println("====================================\n", null);
    }

    public static void displayInfoAndOption() {
        Scanner scanner = new Scanner(System.in);

        if (!chooseRoom(scanner)) {
            return;
        }

        Menu vriMenu = new Menu("");
        vriMenu.setListPrinter(ViewRoom::displayRoom);
        vriMenu.addOption("Edit  Room Info", () -> EditRoom.updateRoom(foundRoom));
        vriMenu.addOption("View tenant in room", Nav::nav);
        vriMenu.addOption("Delete Room", () -> {
            if (DeleteRoom.removeRoom(foundRoom)) {
                foundRoom = null;
                vriMenu.requestBack();
            }
        });

        vriMenu.displayMenu();
    }
}
