package com.ersikthy.rentalroom.controller.rentalroom.inroom;

import com.ersikthy.rentalroom.controller.menu.Menu;
import com.ersikthy.rentalroom.model.Tenant;

import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.rentalroom.ViewRoom.foundRoom;


public class Nav {
    private Nav() {};

    public static void nav () {
        Menu VTIRMenu = new Menu("In Room Tenant");

        VTIRMenu.setListPrinter(() -> {
            if (foundRoom.getInRoomTenant().isEmpty()) {
                sysLog("No tenant in room!");
                return;
            }
            int i = 1;
            for (Tenant tenant : foundRoom.getInRoomTenant()) {
                printf("[%d].%s\n", i++, tenant.getName());
            }
        });

        VTIRMenu.addOption("Add Tenant into room", () -> AddTenantIntoRoom.checkIn(foundRoom));
        VTIRMenu.addOption("Move Tenant out room", () -> {
        if (RemoveTenant.checkOut(foundRoom)) {
            RemoveTenant.foundTenant = null;
            VTIRMenu.requestBack();
        }
        });

        VTIRMenu.displayMenu();
    }
}
