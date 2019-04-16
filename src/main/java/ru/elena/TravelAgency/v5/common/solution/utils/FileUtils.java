package main.java.ru.elena.TravelAgency.v5.common.solution.utils;

import java.io.File;

public final class FileUtils {
    private FileUtils() {
    }

    public static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return !file.exists() || file.isDirectory();
    }
}
