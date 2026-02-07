package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<Word> wordList;

    public WordAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        Word word = wordList.get(position);
        holder.imageViewWord.setImageResource(word.getImageResId());
        holder.textViewEnglish.setText(word.getEnglish());
        holder.textViewArabic.setText(word.getArabic());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewWord;
        TextView textViewEnglish, textViewArabic;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewWord = itemView.findViewById(R.id.imageViewWord);
            textViewEnglish = itemView.findViewById(R.id.textViewEnglish);
            textViewArabic = itemView.findViewById(R.id.textViewArabic);
        }
    }
}
