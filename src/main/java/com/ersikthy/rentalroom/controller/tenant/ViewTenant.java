package com.ersikthy.rentalroom.controller.tenant;

import com.ersikthy.rentalroom.model.Tenant;

import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.tenant.EditTenant.updateTenant;
import static com.ersikthy.rentalroom.controller.tenant.Nav.list;
import com.ersikthy.rentalroom.controller.menu.Menu;

import java.awt.*;
import java.util.Scanner;

public class ViewTenant {
    private ViewTenant() {
    }

    public static Tenant foundTenant = null;

    public static boolean chooseTenant(Scanner scanner) {
        print("Enter tenant name: ", null);
        String name = scanner.nextLine().trim();

        for (Tenant tenant : list) {
            if (tenant.getName().equalsIgnoreCase(name)) {
                foundTenant = tenant;
                return true;
            }
        }
        warn("Tenant name: " + name + " not found!");
        foundTenant = null;
        return false;
    }

    public static void displayTenant () {
        if (foundTenant == null) return;


        println("\n====================================", null);
        print("         TENANT DETAILS (", null);
        print("ID: " + foundTenant.getId(), Color.gray);
        println(")", null);
        println("====================================", null);
        println("Name        : " + foundTenant.getName(), null);
        println("Age      : " + foundTenant.getAge(), null);
        println("Gender       : " + foundTenant.getGender(), null);
        println("Phone: " + foundTenant.getPhone(), null);
        println("====================================\n", null);
    }

    public static void displayInfoAndOption () {
        Scanner scanner = new Scanner(System.in);

        if (!chooseTenant(scanner)) {
            return;
        }

        Menu vtMenu = new Menu("");
        vtMenu.setListPrinter(ViewTenant::displayTenant);
        vtMenu.addOption("Edit tenant info", () -> updateTenant(foundTenant));
        vtMenu.addOption("Delete tenant info", () -> {
            if (DeleteTenant.removeTenant(foundTenant)) {
                foundTenant = null;
                vtMenu.requestBack();
            }
        });
        vtMenu.addOption("Check contract", () -> sysLog("Coming soon..."));
        vtMenu.displayMenu();
    }
}
