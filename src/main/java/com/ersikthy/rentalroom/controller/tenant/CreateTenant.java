package com.ersikthy.rentalroom.controller.tenant;

import com.ersikthy.rentalroom.model.Tenant;

import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveTenants;
import static com.ersikthy.rentalroom.controller.log.Input.*;
import static com.ersikthy.rentalroom.controller.log.Output.sysLog;
import static com.ersikthy.rentalroom.controller.tenant.Nav.list;

public class CreateTenant {
    private CreateTenant() {};

    public static void addTenant() {
        Scanner scanner = new Scanner(System.in);
        String name = readStr(scanner, "Enter tenant name: " );
        int age = readInt(scanner, "Enter tenant age: ");
        long phone = readLong(scanner, "Enter tenant phone: ");
        String gender = Tenant.selectGender(scanner);

        Tenant tenant = new Tenant(name, age, phone, gender);
        list.add(tenant);
        saveTenants(list);
        sysLog("Added new tenant: " + tenant.getName());
    }
}
