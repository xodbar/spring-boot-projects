package kz.xodbar.springprojects.lectures.lecture1.task1.db;

import kz.xodbar.springprojects.lectures.lecture1.task1.models.Item;

import java.util.ArrayList;

public class DBManager {
    public static final DBManager MANAGER = new DBManager();
    private final ArrayList<Item> ITEMS;

    private DBManager() {
        ITEMS = new ArrayList<>();
        ITEMS.add(new Item(1L, "Iphone 10", "Lorem Ipsum is simply dummy" +
                " text of the printing and" +
                " typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
                "text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                350.0, 1000));
        ITEMS.add(new Item(2L, "Iphone 11 PRO", "Lorem Ipsum is simply dummy" +
                " text of the printing and" +
                " typesetting industry. Lorem Ipsum has been the industry's standard" +
                " dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                555.0, 750));
        ITEMS.add(new Item(3L, "Iphone 12 PRO MAX", "Lorem Ipsum is simply dummy" +
                " text of the printing and" +
                " typesetting industry. Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                755.0, 500));
        ITEMS.add(new Item(4L, "Iphone 13 MEGA PRO MAX", "Lorem Ipsum is simply dummy text of the" +
                " printing and" +
                " typesetting industry. Lorem Ipsum has been the industry's standard" +
                " dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                850.0, 250));
        ITEMS.add(new Item(5L, "Iphone 14 SUPER MEGA PRO MAX", "Lorem Ipsum is simply dummy text of" +
                " the printing and" +
                " typesetting industry. Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s," +
                " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                1000.0, 150));
    }

    public ArrayList<Item> getAllItems() {
        return ITEMS;
    }

    public DBManager getDatabase() {
        return MANAGER;
    }
}
