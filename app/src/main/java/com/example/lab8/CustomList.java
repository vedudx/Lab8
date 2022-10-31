package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     *
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     *
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Checks if city is in cityList
     * @param city is the city object that needs to be checked
     * @return True if city is in the list, false otherwise
     */
    public boolean hasCity(City city)
    {
        if(cities.contains(city)){
            return true;
        }
        return false;
    }


    /**
     * Deletes the city if it is in citylist
     * throws exception if it is not
     * @param city is the city object that needs to be deleted
     */
    public void delete(City city){
        if (hasCity(city))
        {
            cities.remove(city);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }



}
