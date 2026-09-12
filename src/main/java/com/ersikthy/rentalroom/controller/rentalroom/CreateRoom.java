package com.ersikthy.rentalroom.controller.rentalroom;

import com.ersikthy.rentalroom.controller.log.Input;
import com.ersikthy.rentalroom.model.RentalRoom;

import static com.ersikthy.rentalroom.controller.data.DataManager.saveRooms;
import static com.ersikthy.rentalroom.controller.rentalroom.Nav.roomList;
import static com.ersikthy.rentalroom.controller.log.Output.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreateRoom {
    private CreateRoom () {}

    public static void addRoom() {
        Map<String, Integer> utilityRates = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name = Input.readStr(scanner, "Enter room name: ");
        int price = Input.readInt(scanner, "Enter room price: ");
        utilityRates.put("Electricity", Input.readInt(scanner, "Enter price of electricity per kmW: "));
        utilityRates.put("Water", Input.readInt(scanner, "Enter price of water per m3: "));
        double area = Input.readDouble(scanner, "Enter room area: ");
        int maxTenant = Input.readInt(scanner, "Enter room max-tenant: ");
        String address = Input.readStr(scanner, "Enter room address: ");
        int deposit = Input.readInt(scanner, "Enter room deposit: ");
        String description = Input.readStr(scanner, "Enter room description: ");
        String status = RentalRoom.selectStatus(scanner);
        String roomType = RentalRoom.selectRoomType(scanner);

        RentalRoom room = new RentalRoom(
                name,
                maxTenant,
                area,
                status,
                roomType,
                price,
                utilityRates,
                description,
                address,
                deposit
                );
        roomList.add(room);
        saveRooms(roomList);
        sysLog("Added new room: " + room.getName());
    }
}
