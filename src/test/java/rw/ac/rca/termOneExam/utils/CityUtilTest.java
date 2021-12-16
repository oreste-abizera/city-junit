package rw.ac.rca.termOneExam.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import rw.ac.rca.termOneExam.domain.City;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CityUtilTest {

    private City city = new City("Rubavu",5);

    public CityUtilTest() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Test
    public void weatherMaxSize_success(){
        assertTrue(city.getWeather() <= 40);
    }

    @Test
    public void weatherMaxSize_failure(){
        assertTrue(city.getWeather() > 40);
    }

    @Test
    public void weatherMinSize_success(){
        assertTrue(city.getWeather() >= 10);
    }

    @Test
    public void weatherMinSize_failure(){
        assertTrue(city.getWeather() < 10);
    }
}
