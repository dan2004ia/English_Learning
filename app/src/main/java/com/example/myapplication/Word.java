package com.example.myapplication;

public class Word {
    private String english;
    private String arabic;
    private int imageResId;

    public Word(String english, String arabic, int imageResId) {
        this.english = english;
        this.arabic = arabic;
        this.imageResId = imageResId;
    }

    public String getEnglish() {
        return english;
    }

    public String getArabic() {
        return arabic;
    }

    public int getImageResId() {
        return imageResId;
    }

}
