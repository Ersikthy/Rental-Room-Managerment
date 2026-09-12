package com.ersikthy.rentalroom.controller.tenant;

import static com.ersikthy.rentalroom.controller.data.DataManager.fetchTenants;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import com.ersikthy.rentalroom.controller.menu.Menu;
import com.ersikthy.rentalroom.model.Tenant;

import java.util.ArrayList;

public class Nav {
    private Nav() {}

    public static ArrayList<Tenant> list = new ArrayList<> (fetchTenants());

    public static void displayListAndOption() {
        Menu tlMenu = new Menu("Tenant List");

        tlMenu.setListPrinter(() -> {
            if (list.isEmpty()) {
                println("Tenant list is empty!", null);
                return;
            }

            int i = 1;
            for (Tenant tenant : list) {
                printf("[%d]. %s\n", i++, tenant.getName());
            }
        });

        tlMenu.addOption("View Tenant Info", ViewTenant::displayInfoAndOption);
        tlMenu.addOption("Create New Tenant", CreateTenant::addTenant);
        tlMenu.displayMenu();
    }
}
