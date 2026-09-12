package com.ersikthy.rentalroom.controller.auth;

import com.ersikthy.rentalroom.model.Admin;

import java.util.Scanner;

import static com.ersikthy.rentalroom.controller.auth.Login.adminList;
import static com.ersikthy.rentalroom.controller.data.DataManager.saveAdmin;
import static com.ersikthy.rentalroom.controller.log.Input.*;
import static com.ersikthy.rentalroom.controller.log.Output.*;
import static com.ersikthy.rentalroom.controller.menu.MainNav.mainNav;

public class SignUp {
     private SignUp() {};

     public static void signUp() {
          Scanner scanner = new Scanner(System.in);
          String adminName = readStr(scanner, "Enter administrator's name: ");
          String password = readStr(scanner, "Enter password: ");
          String confirmPassword = readStr(scanner, "Enter password again: ");

          if (!password.equalsIgnoreCase(confirmPassword)){
               error("Incorrect confirm password");
               return;
          }

          mainNav();
          Admin admin = new Admin(adminName, password);
          adminList.add(admin);
          saveAdmin(adminList);
          sysLog("Create new account's name " + adminName + " successfully!");
     }

}
