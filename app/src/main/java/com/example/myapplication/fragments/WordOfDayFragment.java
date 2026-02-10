package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

public class WordOfDayFragment extends Fragment {

    private TextView tvQuote, tvAuthor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_of_day, container, false);

         tvQuote = view.findViewById(R.id.tvWordOfDay);
        tvAuthor = view.findViewById(R.id.tvMeaning);

         fetchQuoteFromDummyJSON();

        return view;
    }

    private void fetchQuoteFromDummyJSON() {
         String url = "https://dummyjson.com/quotes/random";

         RequestQueue queue = Volley.newRequestQueue(getContext( ));

         JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                             String quoteText = response.getString("quote");
                            String authorName = response.getString("author");

                             tvQuote.setText("\"" + quoteText + "\"");
                            tvAuthor.setText("- " + authorName);
                        } catch (JSONException e) { e.printStackTrace(); }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 tvQuote.setText("Keep learning every day!");
                tvAuthor.setText("- English App");
            }
        });

         queue.add(request);
    }
}
