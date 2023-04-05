package com.example.fileReader.Service;

import com.example.fileReader.Model.Heading;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MSWordReaderService {

    public Map<String, String> readFile(File file){
        Map<String, String> mpValues = new HashMap<>();
        try {
            XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
            List<IBodyElement> bodyElements = doc.getBodyElements();
            List<Heading> headings = new ArrayList<>();
            Heading heading = null;
            int fontSize = 0;
            String syntax = null;
            for(IBodyElement body : bodyElements) {
                if (body instanceof XWPFParagraph) {
                    XWPFParagraph para = (XWPFParagraph) body;
                    for(XWPFRun run : para.getRuns()) {
                        fontSize = run.getFontSize();
                        if (fontSize == 12){
                            if (heading !=null && !StringUtils.isEmpty(syntax)) {
                                heading.setSyntax(syntax.toLowerCase());
                                headings.add(heading);
                                mpValues.put(heading.getName(), heading.getSyntax());
                            }
                            heading = new Heading();
                            heading.setName(para.getText().toUpperCase());
                            syntax = null;
                        } else if (fontSize < 12) {
                            syntax = syntax + " "+para.getText();
                        }
                    }
                }
            }
            heading.setSyntax(syntax.toLowerCase());
            headings.add(heading);
            mpValues.put(heading.getName(), heading.getSyntax());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mpValues;
    }
}
