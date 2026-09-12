package com.ersikthy.rentalroom.controller.uxfunc;

import com.ersikthy.rentalroom.controller.menu.Menu;
import com.ersikthy.rentalroom.model.RentalRoom;

import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.log.Input.readStr;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.displayRoomList;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;

public class Search {
     private Search() {}
     public static void searchRoom() {

          Menu fRoom = new Menu("Search Mode");

          fRoom.addOption("Search empty room", () -> {
               displayRoomList.clear();
               for (RentalRoom room : roomList) {
                    if (room.getStatus().equalsIgnoreCase("Available")) {
                         displayRoomList.add(room);
                    }
               }
               fRoom.requestBack();
          });
          fRoom.addOption("Search cheap room", () -> {
               displayRoomList.clear();
               for (RentalRoom room : roomList) {
                    if (room.getPricing() <= 2500000) {
                         displayRoomList.add(room);
                    }
               }
               fRoom.requestBack();
          });
          fRoom.addOption("Search large room", () -> {
               displayRoomList.clear();
               for (RentalRoom room : roomList) {
                    if (room.getArea() > 30.00) {
                         displayRoomList.add(room);
                    }
               }
               fRoom.requestBack();
          });
          fRoom.addOption("Search medium room", () -> {
               displayRoomList.clear();
               for (RentalRoom room : roomList) {
                    if (room.getArea() == 30.00) {
                         displayRoomList.add(room);
                    }
               }
               fRoom.requestBack();
          });
          fRoom.addOption("Search by name", () -> {
               displayRoomList.clear();

               Scanner scanner = new Scanner(System.in);
               String input = readStr(scanner, "Enter room name: ");

               for (RentalRoom room : roomList) {
                    if (room.getName().toLowerCase().contains(input)) {
                         displayRoomList.add(room);
                    }
               }
               fRoom.requestBack();
          });

          fRoom.displayMenu();




     }
}
