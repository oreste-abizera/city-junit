package rw.ac.rca.termOneExam.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import rw.ac.rca.termOneExam.domain.City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityUtilTest {

    private List<City> cities = Arrays.asList(new City("Kigali",30),new City("Rusizi",12));;

    public CityUtilTest() {
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

        @Test
        public void weatherMaxSize_success(){
            for (City city:cities) {
                assertTrue(city.getWeather() <= 40);
            }
        }

    @Test
    public void weatherMaxSize_failure(){
        for (City city:cities) {
            assertTrue(city.getWeather() > 40);
        }
    }

    @Test
    public void weatherMinSize_success(){
        for (City city:cities) {
            assertTrue(city.getWeather() >= 10);
        }
    }

    @Test
    public void weatherMinSize_failure(){
        for (City city:cities) {
            assertTrue(city.getWeather() < 10);
        }
    }

    @Test
    public void containsMusanzeAndKigali_success(){
        boolean MusanzeFound = false;
        boolean KigaliFound = false;
        for (City city:cities) {
            if(city.getName() == "Kigali") KigaliFound = true;
            if(city.getName() == "Musanze") MusanzeFound = true;
        }
        assertTrue(MusanzeFound && KigaliFound);
    }

    @Test
    public void containsMusanzeAndKigali_failure(){
        boolean MusanzeFound = false;
        boolean KigaliFound = false;
        for (City city:cities) {
            if(city.getName() == "Kigali") KigaliFound = true;
            if(city.getName() == "Musanze") MusanzeFound = true;
        }
        assertFalse(MusanzeFound && KigaliFound);
    }

    @Test
    public void testSpying(){
            ArrayList<City> arrayListSpy = Mockito.spy(ArrayList.class);
            City city = new City(10,"Rusizi",34,62);
            arrayListSpy.add(city);
            arrayListSpy.add(city);
            arrayListSpy.add(city);

            when(arrayListSpy.size()).thenReturn(5);
            arrayListSpy.add(city);
            assertEquals(5, arrayListSpy.size());
    }

    @Test
    public void testMocking(){
            City city = new City(10,"Kigali",67,78);
            List<City> mockList = Mockito.mock(List.class);
            when(mockList.size()).thenReturn(4);
            assertEquals(4, mockList.size());

            when(mockList.get(0)).thenReturn(city);
            assertEquals("Kigali", mockList.get(0).getName());
        }
}
