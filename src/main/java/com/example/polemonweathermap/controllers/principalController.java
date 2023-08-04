package com.example.polemonweathermap.controllers;

import com.example.polemonweathermap.services.ForecastImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class principalController {

    @Autowired
    private ForecastImageService forecastImageService;

    @GetMapping
    public String show(){
        return "index";
    }



    @GetMapping(value = "/forecast", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<FileSystemResource> handleForecast(@RequestParam("datePicker") String dateString) {
        File image = forecastImageService.getImage(dateString);
        if (image == null) {
            return ResponseEntity.notFound().build();
        } else {
            FileSystemResource imageResource = new FileSystemResource(image);
            return ResponseEntity.ok().body(imageResource);
        }
    }



}
