package com.example.fileReader.Model;

public class Response {

    private String headingName;
    private int occurence;
    private int document;

    public String getHeadingName() {
        return headingName;
    }

    public void setHeadingName(String headingName) {
        this.headingName = headingName;
    }

    public int getOccurence() {
        return occurence;
    }

    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public Response() {
    }

    @Override
    public String toString() {
        return "Response{" +
                "headingName='" + headingName + '\'' +
                ", occurence=" + occurence +
                ", document=" + document +
                '}';
    }
}
