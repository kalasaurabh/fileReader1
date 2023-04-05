package com.example.fileReader.Service;

import com.example.fileReader.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FileReaderService {

    @Value("${folder.location}")
    private String fileLocation;

    @Value("${buzz.words}")
    private String[] valuesArray;

    @Value("${file.header}")
    private String[] headers;

    @Value("${file.output}")
    private String outputLocation;
    @Autowired
    private MSWordReaderService msWordReaderService;

    public void readFile() {
        List<File> files = null;
        try {
            List<Map<String, String>> mpValues= Files.list(Paths.get(fileLocation))
                    .map(Path::toFile)
                    .filter(File::isFile).map(msWordReaderService::readFile)
                    .collect(Collectors.toList());
            List<Response> responseList = calculateOccurance(mpValues,valuesArray,headers);
            writeToFile(responseList,outputLocation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Response> calculateOccurance(List<Map<String, String>> mpValues, String[] array, String[] headings) {
        Response response = null;
        List<Response> responseList = new ArrayList<>();
        for (String str : array) {
            for (String header : headings) {
                if (response !=null && response.getHeadingName()!=null) {
                    responseList.add(response);
                }
                response = new Response();
                for(Map<String, String> mp : mpValues) {
                    if (mp.get(header)!=null && mp.get(header).contains(str)) {
                        response.setHeadingName(header + " "+str);
                        response.setOccurence(response.getOccurence()+1);
                    }
                }
            }
        }
        if (response !=null && response.getHeadingName()!=null) {
            responseList.add(response);
        }
        return responseList;
    }

    public void writeToFile(List<Response> responseList, String fileLocation) {
        File file = new File(fileLocation);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter writer = new PrintWriter(fos);
            responseList.forEach(rec -> writer.println(rec));
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
