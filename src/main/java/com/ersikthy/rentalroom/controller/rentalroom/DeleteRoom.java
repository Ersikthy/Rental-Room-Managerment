package com.ersikthy.rentalroom.controller.rentalroom;

import com.ersikthy.rentalroom.controller.log.Input;
import com.ersikthy.rentalroom.model.RentalRoom;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveRooms;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;

import static com.ersikthy.rentalroom.controller.log.Output.*;

import java.util.Scanner;

public class DeleteRoom {
    public static boolean removeRoom(RentalRoom room) {
        if (!room.getInRoomTenant().isEmpty()) {
            warn("This room is currently occupied! Please check the tenant in the room before deleting it.");
            return false;
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = Input.readStr(scanner, "Type confirm to remove or cancel: ").trim();

            if (choice.equalsIgnoreCase("confirm")) {
                roomList.remove(room);
                saveRooms(roomList);
                println("Remove room's name " + room.getName() + " successfully!", null);
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
