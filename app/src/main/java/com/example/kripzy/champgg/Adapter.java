package com.example.kripzy.champgg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;




public class Adapter extends BaseAdapter implements Filterable{
    Context c;
    ArrayList<Champions> Champion;
    ArrayList<Champions>filterlist;
    CustomFiler filter;


    public Adapter(Context ctx, ArrayList<Champions> Champion){
        this.c=ctx;
        this.Champion=Champion;
        this.filterlist=Champion;
    }

    @Override
    public int getCount() {
        return Champion.size();
    }

    @Override
    public Object getItem(int position) {
        return Champion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Champion.indexOf(getItem(position));
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.model, null);
        }
        TextView nameTxt = (TextView) convertView.findViewById(R.id.textView);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        nameTxt.setText(Champion.get(position).getChampion());
        img.setImageResource(Champion.get(position).getChampimg());

//ADDED LINES
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(Champion.get(position).getChampion().equalsIgnoreCase("Aatrox")){
                    Intent newActivity = new Intent(c, Aatrox.class);
                    c.startActivity(newActivity);

                }else if(Champion.get(position).getChampion().equalsIgnoreCase("Ahri")){
                    Intent newActivity2 = new Intent(c, Ahri.class);
                    c.startActivity(newActivity2);


                }else if(Champion.get(position).getChampion().equalsIgnoreCase("Akali")){
                    Intent newActivity3 = new Intent(c, Akali.class);
                    c.startActivity(newActivity3);

                }
            }
        });

        return convertView;
    }

    @Override
    public Filter getFilter() {

        if (filter == null)
        {
            filter=new CustomFiler();
        }
        return filter;
    }

    class CustomFiler extends Filter
    {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results=new FilterResults();

            if (constraint != null && constraint.length() > 0)
            {
                constraint=constraint.toString().toUpperCase();

                ArrayList<Champions> filters = new ArrayList<Champions>();

                for(int i = 0;i<filterlist.size();i++){

                    if (filterlist.get(i).getChampion().toUpperCase().contains(constraint))
                    {
                        Champions p= new Champions (filterlist.get(i).getChampion(),filterlist.get(i).getChampimg());
                        filters.add(p);
                    }
                }
                results.count=filters.size();
                results.values=filters;
            }else{
                results.count=filterlist.size();
                results.values=filterlist;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Champion = (ArrayList<Champions>) results.values;
            notifyDataSetChanged();
        }
    }
}