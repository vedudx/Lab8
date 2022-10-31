package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {


    private CustomList list;


    public CustomList MockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }


    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);}


    @Test
    public void testHasCity() {
        list = MockCityList();

        City city = new City("Estevan", "SK");
        list.addCity(city);

        assertTrue(list.hasCity(city));

        // test for a city which isn't there
        assertFalse(list.hasCity(new City("testCity", "testProvince")));
    }

    @Test
    void testDeleteCity()
    {
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Yellowknife", "Northwest Territories");
        list.addCity(city);
        assertEquals(listSize+1, list.getCount());
        list.deleteCity(city);
        assertEquals(listSize, list.getCount());

        // test deleting invalid city
        assertThrows( IllegalArgumentException.class, () -> {
            list.deleteCity(new City("testCity", "testProvince")); });

        assertEquals(listSize, list.getCount());
    }

    @Test
    void testCountCities()
    {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        int listSize = list.getCount();
        list.addCity(city);
        assertEquals(listSize+1, list.countCities());
        list.delete(city);
        assertEquals(1, list.countCities());
        City city2 = new City("testCity", "testProvince");
        list.addCity(city2);
        assertEquals(2, list.countCities());
    }


}
