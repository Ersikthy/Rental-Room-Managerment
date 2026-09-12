package com.ersikthy.rentalroom.controller.uxfunc;

import com.ersikthy.rentalroom.controller.menu.Menu;
import com.ersikthy.rentalroom.model.RentalRoom;

import java.util.Comparator;

import static com.ersikthy.rentalroom.controller.rentalroom.Nav.displayRoomList;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;

public class Sort {
     public static String sortMode = "None";

     public enum SortMode{
          NAMEa_z("Name (A-Z)"),
          NAMEz_a("Name (Z-A)"),
          PRICINGl_h("Pricing (L-H)"),
          PRICINGh_l("Pricing (H-L)"),
          AREAl_s("Area (L-S)"),
          AREAs_l("Area (S-L)");

          private final String label;

          SortMode(String label) {
               this.label = label;
          }

          public String getLabel() {
               return label;
          }
     }


     public static void sortRoom(){
          Menu sRoom = new Menu("Sort Mode");

          sRoom.addOption("Sort by name (A-Z)", () -> {
               sortMode = SortMode.NAMEa_z.getLabel();
               displayRoomList.sort(Comparator.comparing(RentalRoom::getName, String.CASE_INSENSITIVE_ORDER));
               sRoom.requestBack();
          });
          sRoom.addOption("Sort by name (Z-A)", () -> {
               sortMode = SortMode.NAMEz_a.getLabel();
               displayRoomList.sort(Comparator.comparing(RentalRoom::getName, String.CASE_INSENSITIVE_ORDER).reversed());
               sRoom.requestBack();
          });
          sRoom.addOption("Sort by pricing (L-H)", () -> {
               sortMode = SortMode.PRICINGl_h.getLabel();
               displayRoomList.sort(Comparator.comparing(RentalRoom::getPricing));
               sRoom.requestBack();
          });
          sRoom.addOption("Sort by pricing (H-L)", () -> {
               sortMode = SortMode.PRICINGh_l.getLabel();
               displayRoomList.sort(Comparator.comparing(RentalRoom::getPricing).reversed());
               sRoom.requestBack();
          });
          sRoom.addOption("Sort by area (L-S)", () -> {
               sortMode = SortMode.AREAl_s.getLabel();
               displayRoomList.sort(Comparator.comparing(RentalRoom::getArea).reversed());
               sRoom.requestBack();
          });
          sRoom.addOption("Sort by area (S-L)", () -> {
               sortMode = SortMode.AREAs_l.getLabel();
               displayRoomList.sort(Comparator.comparing(RentalRoom::getArea));
               sRoom.requestBack();
          });

          sRoom.displayMenu();
     }

}
