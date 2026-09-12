package com.ersikthy.rentalroom.controller.rentalroom;

import com.ersikthy.rentalroom.controller.menu.Menu;
import com.ersikthy.rentalroom.controller.uxfunc.Search;
import com.ersikthy.rentalroom.controller.uxfunc.Sort;
import com.ersikthy.rentalroom.model.RentalRoom;

import java.awt.*;
import java.util.ArrayList;

import static com.ersikthy.rentalroom.controller.data.DataManager.fetchRooms;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.uxfunc.Sort.sortMode;

public class Nav {

    private Nav() {
    }

    public static ArrayList<RentalRoom> roomList = new ArrayList<>(fetchRooms());

    public static ArrayList<RentalRoom> displayRoomList = new ArrayList<>(roomList);
    public static void nav() {
        Menu rrlMenu = new Menu("Rental Room List");
        rrlMenu.setListPrinter(() -> {
            if (displayRoomList.isEmpty()) {
                println("Rental room list is empty!", null);
                return;
            }

            int i = 1;
            for (RentalRoom room : displayRoomList) {
                printf("[%d].Room %s\n", i++, room.getName());
            }
            println("Sort mode: " + sortMode, Color.MAGENTA);
        });

        rrlMenu.addOption("Sort Room", Sort::sortRoom);
        rrlMenu.addOption("Search Room", Search::searchRoom);
        rrlMenu.addOption("Refresh List", () -> {
            displayRoomList = new ArrayList<>(roomList);
        });
        rrlMenu.addOption("View Room Info", ViewRoom::displayInfoAndOption);
        rrlMenu.addOption("Add New Room", CreateRoom::addRoom);

        rrlMenu.displayMenu();
    }

}
