package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
}
