package com.ersikthy.rentalroom.controller.menu;

import com.ersikthy.rentalroom.controller.rentalroom.Nav;

import static com.ersikthy.rentalroom.controller.log.Output.*;

public class MainNav {
    private MainNav() {
    }

    public static void mainNav() {

        Menu mainMenu = new Menu("RRM Menu");
        mainMenu.addOption("RentalRoom List", Nav::nav);
        mainMenu.addOption("Tenant List", com.ersikthy.rentalroom.controller.tenant.Nav::displayListAndOption);
        mainMenu.addOption("Setting", () -> sysLog("Opening..."));

        mainMenu.displayMenu();
    }
}
