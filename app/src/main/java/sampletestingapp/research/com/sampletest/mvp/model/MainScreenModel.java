package sampletestingapp.research.com.sampletest.mvp.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import sampletestingapp.research.com.sampletest.App;
import sampletestingapp.research.com.sampletest.other.Item;
import sampletestingapp.research.com.sampletest.other.Storage;

/**
 * Created by dima on 10/16/16.
 */
public class MainScreenModel implements IMainScreenModel {

    @Inject
    protected Storage mStorage;

    public MainScreenModel() {
        App.getmAppComponent().inject(this);
    }

    @Override
    public ArrayList<Item> loadData() {
        return mStorage.getItems();
    }
}
