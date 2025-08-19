package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends BaseAdapter {

    private List<Word> wordList;
    private Context context;

    public WordAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;

    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Object getItem(int position) {
        return wordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_word, parent, false);
        }

        ImageView imageResId = convertView.findViewById(R.id.imageResId );
        TextView textEnglish = convertView.findViewById(R.id.tvEnglishWord);
        TextView textArabic = convertView.findViewById(R.id.tvArabicMeaning);

        Word word = wordList.get(position);
        imageResId.setImageResource(word.getImageResId());
        textEnglish.setText(word.getEnglish());
        textArabic.setText(word.getArabic());

        return convertView;
    }
}
