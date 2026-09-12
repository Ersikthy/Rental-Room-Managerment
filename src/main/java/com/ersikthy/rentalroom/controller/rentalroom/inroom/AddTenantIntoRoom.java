package com.ersikthy.rentalroom.controller.rentalroom.inroom;

import com.ersikthy.rentalroom.model.RentalRoom;
import com.ersikthy.rentalroom.model.Tenant;

import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveRooms;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;
import static com.ersikthy.rentalroom.controller.tenant.Nav.list;
import static com.ersikthy.rentalroom.controller.tenant.ViewTenant.chooseTenant;
import static com.ersikthy.rentalroom.controller.tenant.ViewTenant.foundTenant;

public class AddTenantIntoRoom {
    private AddTenantIntoRoom() {};

    public static boolean capacityCheck(RentalRoom room) {
        return room.getMaxTenant() <= room.getInRoomTenant().size();
    }

    public static void checkIn(RentalRoom room) {
        if (capacityCheck(room)) {
            sysLog("This room has full tenant!");
            return;
        }

        int i = 1;
        for (Tenant tenant : list) {
            printf("[%d]. %s\n", i++, tenant.getName());
        }

        Scanner scanner = new Scanner(System.in);
        if (!chooseTenant(scanner)) {
            return;
        }

        room.getInRoomTenant().add(foundTenant);
       if (!capacityCheck(room)) {
           saveRooms(roomList);
           return;
       }
        room.setStatus(RentalRoom.Status.FUll.getLabel());
        saveRooms(roomList);
    }
}
