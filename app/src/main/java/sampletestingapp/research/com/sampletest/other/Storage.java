package sampletestingapp.research.com.sampletest.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 10/16/16.
 */
public class Storage {

    private ArrayList<Item> mItems = new ArrayList<>();
    {
        mItems.add(new Item(1, "First"));
        mItems.add(new Item(2, "Second"));
        mItems.add(new Item(3, "Third"));
        mItems.add(new Item(4, "Fourth"));
        mItems.add(new Item(5, "Fifth"));
        mItems.add(new Item(6, "The sixth"));
    }

    public ArrayList<Item> getItems() {
        return mItems;
    }
}
