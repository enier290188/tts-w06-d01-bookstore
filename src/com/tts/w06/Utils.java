package com.tts.w06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Utils {
    public static void loadStringsToArray(ArrayList<String> arrList) throws IOException {
        Path path = Paths.get("src/com/tts/w06/BookTitles.txt");
        arrList.clear();

        // The stream file will also be closed here
        try (Stream<String> lines = Files.lines(path)) {
            Object[] arr = lines.toArray();

            for (Object t : arr) {
                arrList.add(t.toString());
            }
        }
    }
}
