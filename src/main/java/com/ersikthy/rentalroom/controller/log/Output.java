package com.ersikthy.rentalroom.controller.log;

import static com.ersikthy.rentalroom.controller.log.format.TextColor.*;
import java.awt.*;

public class Output {
    private Output() {
    }

    public static void print(Object prompt, Color color) {
        System.out.print(painting(prompt, color));
    }

    public static void println(Object prompt, Color color) {
        System.out.println(painting(prompt, color));
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void success(Object prompt) {
        System.out.println( painting("[SUCCESS]: " + prompt, Color.green));
    }
    public static void warn(Object prompt) {
        System.out.println(painting("[WARN]: " + prompt, Color.orange));
    }
    public static void queue(Object prompt) {System.out.println(painting("[QUEUE]: " + prompt, Color.yellow));}
    public static void error(Object prompt) {
        System.out.println(painting("[ERROR]: " + prompt, Color.red));
    }
    public static void sysLog(Object prompt) {
        System.out.println(painting("[SYSTEM]: " + prompt, Color.gray));
    }
}
