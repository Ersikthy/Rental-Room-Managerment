package com.ersikthy.rentalroom.controller.rentalroom;

import com.ersikthy.rentalroom.controller.log.Input;
import com.ersikthy.rentalroom.model.RentalRoom;

import java.lang.reflect.Field;
import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveRooms;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;

public class EditRoom {
    private EditRoom() {}

    static Field foundLabel = null;

    public static boolean chooseLabel(Scanner scanner) {
        print("Enter label name to edit (e.g. name, pricing, area, description, location): ", null);
        String choice = scanner.nextLine().trim();
        Field[] fields = RentalRoom.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(choice)) {
                if (field.getName().equalsIgnoreCase("id")) {
                    warn("Cannot edit Room ID!");
                    foundLabel = null;
                    return false;
                }
                println("Label selected: " + field.getName(), null);
                foundLabel = field;
                return true;
            }
        }

        warn("Label with name " + choice + " not found!");
        foundLabel = null;
        return false;
    }

    public static void updateRoom(RentalRoom room) {

        Scanner scanner = new Scanner(System.in);
        if (!chooseLabel(scanner)) {
            return;
        }

        try {
            foundLabel.setAccessible(true);
            String typeName = foundLabel.getType().getSimpleName();

            Object newValue = Input.readType(scanner, typeName, "Enter new value: ");

            if (newValue != null) {
                foundLabel.set( room, newValue);
                saveRooms(roomList);
                success("Updated room " + foundLabel.getName() + " successfully!\n");
            }
        } catch (IllegalAccessException e) {
            error("Failed to access property: " + e.getMessage() + "\n");
        }
    }

}
