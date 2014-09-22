package cbedoy.conversor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Carlos on 22/09/2014.
 */
public class ConversionAdapter extends ArrayAdapter<ConversionModel>
{
    private List<ConversionModel> conversionModelList;


    public ConversionAdapter(Context context, int resource, List<ConversionModel> objects) {
        super(context, resource, objects);
        conversionModelList = objects;
    }

    @Override
    public int getCount() {
        return conversionModelList.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = new MyView(getContext());
        }
        ((MyView)convertView).setConversionModel(conversionModelList.get(position));
        ((MyView)convertView).reloadData();
        return convertView;
    }

    private class MyView extends LinearLayout{

        private ConversionModel conversionModel;
        private TextView textView;
        public MyView(Context context) {
            super(context);
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            setLayoutParams(params);
            textView = new TextView(getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setTextSize(20);
        }
        public void setConversionModel(ConversionModel conversionModel) {
            this.conversionModel = conversionModel;
        }

        public void reloadData(){
            textView.setText(conversionModel.getFromTitle() + " to "+ conversionModel.getToTitle());
            setTag(conversionModel);
        }
    }
}

