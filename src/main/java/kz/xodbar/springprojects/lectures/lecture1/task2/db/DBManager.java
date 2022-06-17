package kz.xodbar.springprojects.lectures.lecture1.task2.db;

import kz.xodbar.springprojects.lectures.lecture1.task2.models.Item;

import java.util.ArrayList;

public class DBManager {
    public static final DBManager MANAGER = new DBManager();
    private final ArrayList<Item> ITEMS;
    private Long id;

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

        id = 6L;
    }

    public ArrayList<Item> getAllItems() {
        return ITEMS;
    }

    public Item getItemById(Long id) {
        for (Item item : getAllItems())
            if (item.getId().equals(id))
                return item;

        return null;
    }

    public void addItem(Item item) {
        try {
            ITEMS.add(new Item((long)(ITEMS.size()+1), item.getName(),
                    item.getDescription(), item.getPrice(), item.getAmount()));
            id++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editItem(Item item) {
        if (item.getId() != null && item.getId() > 0 && item.getId() <= id) {
            int index = 0;
            for (Item it : getAllItems()) {
                if (it.getId().equals(item.getId())) {
                    getAllItems().set(index, item);
                    break;
                } else index++;
            }
        }
    }

    public void deleteItem(Long id) {
        if (id > 0 && id <= this.id) {
            int index = 0;
            for (Item item : getAllItems()) {
                if (item.getId().equals(id)) {
                    ITEMS.remove(index);
                    break;
                } else index++;
            }
        }
    }

    public DBManager getDatabase() {
        return MANAGER;
    }
}
