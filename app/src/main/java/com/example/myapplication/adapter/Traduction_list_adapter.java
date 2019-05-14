package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.Traduction;

import java.util.List;

public class Traduction_list_adapter extends BaseAdapter {

    private Context context;
    private List<Traduction> traduction_list;
    private LayoutInflater inflater;

    public Traduction_list_adapter(Context context, List<Traduction> traduction_list ){
        this.context = context;
        this.traduction_list = traduction_list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return traduction_list.size();
    }

    @Override
    public Object getItem(int position) {
        return traduction_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_item,null);

        Traduction current_trad = (Traduction)getItem(position);
        String item1 = current_trad.getItem1();
        String item2 = current_trad.getItem2();

        TextView item1_view =  view.findViewById(R.id.item_1);
        item1_view.setText(item1);

        TextView item2_view =  view.findViewById(R.id.item_2);
        item2_view.setText(item2);
        return view;
    }
}
