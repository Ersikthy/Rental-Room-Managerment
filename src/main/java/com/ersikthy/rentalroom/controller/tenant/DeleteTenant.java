package com.ersikthy.rentalroom.controller.tenant;

import com.ersikthy.rentalroom.model.Tenant;

import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveTenants;
import static com.ersikthy.rentalroom.controller.log.Input.*;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.tenant.Nav.list;

public class DeleteTenant {
    public  static boolean removeTenant(Tenant tenant) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = readStr(scanner, "Type confirm to remove or cancel: ").trim();

            if (choice.equalsIgnoreCase("confirm")) {
                list.remove(tenant);
                saveTenants(list);
                println("Remove tenant's name " + tenant.getName() + " successfully!", null);
                println("Returning...", null);
                return true;
            }

            if (choice.equalsIgnoreCase("cancel")) {
                println("Canceling...", null);
                return false;
            }

            warn("\nInvalid! Please type 'confirm' or 'cancel'");
        }
    }
}
