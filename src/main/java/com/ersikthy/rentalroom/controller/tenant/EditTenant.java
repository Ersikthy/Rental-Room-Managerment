package com.ersikthy.rentalroom.controller.tenant;

import com.ersikthy.rentalroom.model.Tenant;

import java.lang.reflect.Field;
import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveTenants;
import static com.ersikthy.rentalroom.controller.log.Input.readType;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.tenant.Nav.list;

public class EditTenant {
    private EditTenant() {
    }

    ;

    static Field foundLabel = null;

    public static boolean chooseLabel(Scanner scanner) {
        print("Enter label name to edit(e.g name, age, phone, gender): ", null);
        String choice = scanner.nextLine().trim();
        Field[] fields = Tenant.class.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(choice)) {
                if (field.getName().equalsIgnoreCase("id")) {
                    warn("Cannot edit Tenant ID!");
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

    public static void updateTenant(Tenant tenant) {

        Scanner scanner = new Scanner(System.in);
        if(!chooseLabel(scanner)) {
            return;
        }

        try {
            foundLabel .setAccessible(true);

            String typeName = foundLabel.getType().getSimpleName();

            Object newValue = readType(scanner, typeName, "Enter new value: ");

            if (newValue != null) {
                foundLabel.set(tenant, newValue);
                saveTenants(list);
                success("Updated tenant " + foundLabel.getName() + " successfully!\n");
            }
        } catch (IllegalAccessException e) {
            error("Failed to access property: " + e.getMessage() + "\n");
        }
    }
}
