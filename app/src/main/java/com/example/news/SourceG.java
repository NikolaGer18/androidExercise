package com.example.news;

import java.util.ArrayList;

public class SourceG {
    public static ArrayList<News>generateContactList(int count){
        ArrayList<News> items = new ArrayList<>();
        for (int i = 1; i <= count; i++)
        {
            items.add(new News("Title" + i, "author" + i, "ref" + i, "texsdasdasdasdas"));
        }
        return  items;
    }
}
