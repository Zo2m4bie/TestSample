package sampletestingapp.research.com.sampletest.mvp.model;

import java.util.List;

import javax.inject.Inject;

import sampletestingapp.research.com.sampletest.App;
import sampletestingapp.research.com.sampletest.other.Item;
import sampletestingapp.research.com.sampletest.other.Storage;

/**
 * Created by dima on 10/16/16.
 */
public class SecondaryScreenModel implements ISecondaryScreenModel {

    @Inject
    protected Storage mStorage;

    public SecondaryScreenModel() {
        App.getmAppComponent().inject(this);
    }

    @Override
    public Item loadItem(int id) {
        List<Item> items = mStorage.getItems();
        for(Item item : items){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
