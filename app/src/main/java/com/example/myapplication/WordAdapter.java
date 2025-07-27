package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    private List<Word> wordList;
    private Context context;

    public WordAdapter(Context context, List<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
    }


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word word = wordList.get(position);
        holder.textEnglish.setText(word.getEnglish());
        holder.textArabic.setText(word.getArabic());
        holder.imageWord.setImageResource(word.getImageResId());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        TextView textEnglish, textArabic;
        ImageView imageWord;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textEnglish = itemView.findViewById(R.id.textEnglish);
            textArabic = itemView.findViewById(R.id.textArabic);
            imageWord = itemView.findViewById(R.id.imageWord);
        }
    }
}
