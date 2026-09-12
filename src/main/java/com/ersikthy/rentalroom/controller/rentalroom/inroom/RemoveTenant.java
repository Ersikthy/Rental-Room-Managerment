package com.ersikthy.rentalroom.controller.rentalroom.inroom;

import com.ersikthy.rentalroom.model.RentalRoom;
import com.ersikthy.rentalroom.model.Tenant;

import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveRooms;
import static com.ersikthy.rentalroom.controller.log.Input.readStr;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;
import static com.ersikthy.rentalroom.controller.rentalroom.ViewRoom.foundRoom;
import static com.ersikthy.rentalroom.controller.rentalroom.inroom.AddTenantIntoRoom.capacityCheck;

public class RemoveTenant {
    private RemoveTenant() {
    }

    ;

    public static Tenant foundTenant = null;

    public static boolean chooseTenant(Scanner scanner) {
        print("Enter tenant name: ", null);
        String name = scanner.nextLine().trim();

        for (Tenant tenant : foundRoom.getInRoomTenant()) {
            if (tenant.getName().equalsIgnoreCase(name)) {
                foundTenant = tenant;
                return true;
            }
        }
        warn("Tenant name: " + name + " not in this room!");
        foundTenant = null;
        return false;
    }

    public static boolean checkOut(RentalRoom room) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            if (!chooseTenant(scanner)) {
                return false;
            }

            String choice = readStr(scanner, "Type confirm to remove or cancel: ").trim();

            if (choice.equalsIgnoreCase("confirm")) {
                room.getInRoomTenant().remove(foundTenant);
                if (!capacityCheck(room)) {
                    room.setStatus(RentalRoom.Status.AVAILABLE.getLabel());
                }
                saveRooms(roomList);
                println("Remove tenant's name " + foundTenant.getName() + " successfully!", null);
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
