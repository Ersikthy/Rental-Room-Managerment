package com.ersikthy.rentalroom.controller.auth;

import com.ersikthy.rentalroom.controller.menu.Menu;

public class Nav {
     private Nav () {};

     public static void authNav() {
          Menu authMenu = new Menu("Auth Menu");

          authMenu.addOption("Login", Login::login);
          authMenu.addOption("Sign Up", SignUp::signUp);

          authMenu.displayMenu();
     }

}
