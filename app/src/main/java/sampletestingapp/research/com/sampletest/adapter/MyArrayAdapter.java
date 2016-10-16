package sampletestingapp.research.com.sampletest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sampletestingapp.research.com.sampletest.R;
import sampletestingapp.research.com.sampletest.other.Item;

/**
 * Created by dima on 10/16/16.
 */
public class MyArrayAdapter extends ArrayAdapter<Item> {

    private ArrayList<Item> mItems;

    public MyArrayAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public int getCount() {
        return (mItems == null) ? 0 : mItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewHolder holder = new ViewHolder();
            convertView = (View) inflater.inflate(R.layout.item, null);
            ButterKnife.inject(holder, convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.mText.setText(getItem(position).getTitle());
        return convertView;
    }

    public ArrayList<Item> getItems() {
        return mItems;
    }

    @Override
    public Item getItem(int position) {
        return mItems.get(position);
    }

    public void setItems(ArrayList<Item> items) {
        mItems = items;
    }

    public class ViewHolder{
        @InjectView(R.id.text)
        public TextView mText;
    }
}
