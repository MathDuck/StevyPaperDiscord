package me.math.stevydiscordpaper.logging;

import me.math.stevydiscordpaper.utils.Util;

import java.io.*;

public class Logger {
    public static void println() {
        output(Util.completeDate() + " ");
    }

    public static void println(Object format) {
        output(Util.completeDate() + " >> " + format.toString());
    }

    public static void printDebug(Object format) {
        output("[DEBUG] [" + Util.completeDate() + "] >> " + format.toString());
    }

    public static void printError(Object format) {
        output("[ERROR] " + Util.completeDate() + " >> " + format.toString());
    }

    public static void printError(Object format, Throwable exception) {
        output("[ERROR] " + Util.completeDate() + " >> " + format.toString() + " / Exeception: " + exception);
    }

    private static void output(String string) {
        output(string, true);
    }

    private static void output(String string, boolean log) {
        if (log) {
            System.out.println(string);
        }
    }

    public static void exception(Exception e) {

        println("---------------------------------------------");
        println("Exception has occured!");
        println("---------------------------------------------");
        e.printStackTrace();
        println("---------------------------------------------");

        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        output(exceptionAsString, false);

        writeToFile("log/exception.log", "---------------------------------------------");
        writeToFile("log/exception.log", " " + Util.completeDate() + " - Exception has occured!");
        writeToFile("log/exception.log", exceptionAsString);
    }

    private static void writeToFile(String dir, String string) {
        File file = new File(dir);
        try {

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        } catch (Exception e1) {
        }

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true)));
            writer.println(string);
            writer.flush();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
