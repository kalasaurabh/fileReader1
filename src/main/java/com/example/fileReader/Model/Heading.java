package com.example.fileReader.Model;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.util.List;

public class Heading {

    private String name;
    private String syntax;

    private List<XWPFParagraph> paragraps;

    public List<XWPFParagraph> getParagraps() {
        return paragraps;
    }

    public void setParagraps(List<XWPFParagraph> paragraps) {
        this.paragraps = paragraps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public Heading(String name, String syntax, List<XWPFParagraph> paragraps) {
        this.name = name;
        this.syntax = syntax;
        this.paragraps = paragraps;
    }

    public Heading() {

    }
}
