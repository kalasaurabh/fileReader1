package com.example.fileReader.controller;

import com.example.fileReader.Service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileReader {

    @Autowired
    private FileReaderService fileReaderService;

    @GetMapping("/file")
    public String getName() {
        fileReaderService.readFile();
        return "Hello";
    }

}

