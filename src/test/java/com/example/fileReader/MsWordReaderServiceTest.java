package com.example.fileReader;


import com.example.fileReader.Service.MSWordReaderService;
import org.junit.jupiter.api.Test;

import java.io.File;

public class MsWordReaderServiceTest {

    @Test
    public void testMe(){
        File file = new File(("C:\\Users\\Saurabh_Kala\\Downloads\\fileReader\\fileReader\\src\\test\\java\\com\\example\\fileReader\\mine.docx"));
        new MSWordReaderService().readFile(file);
    }
}
