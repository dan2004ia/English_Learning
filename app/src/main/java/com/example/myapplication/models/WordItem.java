package com.example.myapplication.models;

public class WordItem {

    private String englishWord;
    private String arabicMeaning;
    private int  imageResId;

    public WordItem(String englishWord, String arabicMeaning,  int imageResId ) {
        this.englishWord = englishWord;
        this.arabicMeaning = arabicMeaning;
        this.imageResId = imageResId;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getArabicMeaning() {
        return arabicMeaning;
    }
    public int getImageResId() {
        return  imageResId;
    }
}
