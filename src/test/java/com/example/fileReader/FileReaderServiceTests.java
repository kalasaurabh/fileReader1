package com.example.fileReader;

import com.example.fileReader.Model.Response;
import com.example.fileReader.Service.FileReaderService;
import com.example.fileReader.Service.MSWordReaderService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileReaderServiceTests {

    @Test
    public void testOccurance() {
        List<Map<String, String>> values = new ArrayList<>();
        File file = new File(("C:\\Users\\Saurabh_Kala\\Downloads\\fileReader\\fileReader\\src\\test\\java\\com\\example\\fileReader\\mine.docx"));
        Map<String, String> map =  new MSWordReaderService().readFile(file);
        values.add(map);
        File file2 = new File(("C:\\Users\\Saurabh_Kala\\Downloads\\5_50\\5_50\\AS.docx"));
        Map<String, String> map2 =  new MSWordReaderService().readFile(file2);
        values.add(map2);
        String[] buzzWords = {"java","azure"};
        String[] headings = {"SUMMARY","SKILLS","WORK EXPERIENCE","EDUCATION","CERTIFICATES"};

        List<Response> responseList = new FileReaderService().calculateOccurance(values,buzzWords,headings);
        String output = "C:\\Users\\Saurabh_Kala\\Downloads\\5_50\\output.txt";
        new FileReaderService().writeToFile(responseList,output);
    }



}
