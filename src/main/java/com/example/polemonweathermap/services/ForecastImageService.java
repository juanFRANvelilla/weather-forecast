package com.example.polemonweathermap.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ForecastImageService {

    public File getImage(String selectedDate){
        ArrayList<String> data = new ArrayList<>(Arrays.asList(selectedDate.split("-")));

        String year = data.get(0);
        String month = data.get(1);
        String day = data.get(2);


        String path = "src\\main\\resources\\static\\images\\output\\spain\\" + year + "\\" + month + "\\" + day;

        File directory = new File(path);
        if(directory.exists() && directory.isDirectory()){
            File[] fields = directory.listFiles();
            if (fields.length == 1){
                File image = fields[0];
                return image;
            }
        }
        return null;
    }
}
