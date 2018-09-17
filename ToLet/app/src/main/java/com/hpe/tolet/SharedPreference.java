package com.hpe.tolet;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.hpe.tolet.Fragments.GetSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SharedPreference {
    public static final String PREFS_NAME = "QUIZ_APP";
    public static final String SP_QUIZID = "SPQuizID";

    public SharedPreference() {
        super();
    }


    public void saveFavorites(Context context, List<GetSet> spQuizList) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
        Gson gson = new Gson();
        String jsonQuiz = gson.toJson(spQuizList);
        editor.putString(SP_QUIZID, jsonQuiz);
        editor.commit();
    }

    public void addFavorite(Context context, GetSet product) {
        List<GetSet> favorites = getFavorites(context);
        if (favorites == null)
            favorites = new ArrayList<GetSet>();
        favorites.add(product);
        saveFavorites(context, favorites);
    }

    public void removeFavorite(Context context, Integer pIndex) {
        Log.d("spQuizList","sizePrefName "+String.valueOf(pIndex));
        List<GetSet> favorites = getFavorites(context);
        if (favorites != null) {
            favorites.remove(pIndex);
            Log.d("spQuizList","sizeDelPref "+favorites.size());
            saveFavorites(context, favorites);
            Log.d("spQuizList","sizePref "+favorites.size());
        }
    }
    public void updateFavorite(Context context, GetSet product) {
        List<GetSet> favorites = getFavorites(context);
        if (favorites != null) {
           // favorites(product);
            saveFavorites(context, favorites);
        }
    }
        public List<GetSet> getFavorites(Context context) {
            SharedPreferences settings;
            List<GetSet> favorites;

            settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

            if (settings.contains(SP_QUIZID)) {
                String jsonFavorites = settings.getString(SP_QUIZID, null);
                Gson gson = new Gson();
                GetSet[] favoriteItems = gson.fromJson(jsonFavorites, GetSet[].class);

                favorites = Arrays.asList(favoriteItems);
                favorites = new ArrayList<GetSet>(favorites);
            } else {
                return null;
            }
            Log.d("spQuizList","sizegetPref "+favorites.size());
            return (List<GetSet>) favorites;
        }
    }