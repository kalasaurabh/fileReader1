package com.example.fileReader.Model;

public class Response {

    private String headingName;
    private int occurence;

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


    public Response() {
    }

    @Override
    public String toString() {
        return "Response{" +
                "headingName='" + headingName + '\'' +
                ", occurence=" + occurence +
                '}';
    }
}
