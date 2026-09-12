package com.ersikthy.rentalroom.controller.auth;

import java.util.ArrayList;
import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.data.DataManager.fetchAdmin;
import static com.ersikthy.rentalroom.controller.log.Input.readStr;
import static com.ersikthy.rentalroom.controller.log.Output.error;
import static com.ersikthy.rentalroom.controller.log.Output.sysLog;
import static com.ersikthy.rentalroom.controller.menu.MainNav.mainNav;

import com.ersikthy.rentalroom.model.Admin;

public class Login {
     private Login() {
     }

     public static ArrayList<Admin> adminList = new ArrayList<>(fetchAdmin());

     public static void login() {

          Scanner scanner = new Scanner(System.in);

          String adminName = readStr(scanner, "Enter your admin name: ");
          String password = readStr(scanner, "Enter your password: ");

          Admin matchedAdmin = null;

          for (Admin admins : adminList) {
               if (adminName.equalsIgnoreCase(admins.getAdminName())) {
                    matchedAdmin = admins;
                    break;
               }
          }

          if (matchedAdmin == null) {
               error("Incorrect name");
          } else if (!password.equalsIgnoreCase(matchedAdmin.getPassword())) {
               error("Incorrect password");
          } else{
               sysLog("Login Successfully! Hello admin");
               mainNav();
          }

     }
}
