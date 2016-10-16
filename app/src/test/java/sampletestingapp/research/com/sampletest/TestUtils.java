package sampletestingapp.research.com.sampletest;

import java.util.ArrayList;

import sampletestingapp.research.com.sampletest.other.Item;

/**
 * Created by dima on 10/16/16.
 */
public class TestUtils {

    private ArrayList<Item> sItems = new ArrayList<>();
    {
        sItems.add(new Item(1, "First"));
        sItems.add(new Item(2, "Second"));
        sItems.add(new Item(3, "Third"));
        sItems.add(new Item(4, "Fourth"));
        sItems.add(new Item(5, "Fifth"));
        sItems.add(new Item(6, "The sixth"));
    }

    public TestUtils() {
    }

    public ArrayList<Item> getItems(){
        return sItems;
    }

}
