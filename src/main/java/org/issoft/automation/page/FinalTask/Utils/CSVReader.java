package org.issoft.automation.page.FinalTask.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    public static List<String> CSVReader(String scvFile) {
        String line = "";
        String scvSplitBy = ",";
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(scvFile))) {
            while ((line = reader.readLine()) != null) {
                data = Arrays.asList(line.split(scvSplitBy));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }
}
