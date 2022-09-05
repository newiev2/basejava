package com.bulavin.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {

    public static void main(String[] args) {
        String filePath = "./src/com/bulavin/webapp";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/bulavin/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        // search with recursion
        recursionSearch(file);
    }

    private static void recursionSearch(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println("File: " + f.getName());
            } else if (f.isDirectory()) {
                System.out.println("Directory: " + f.getName());
                recursionSearch(f);
            }
        }
    }
}
