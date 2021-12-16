package rw.ac.rca.termOneExam.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import rw.ac.rca.termOneExam.domain.City;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class CityUtilTest {

    private double weather;

    public CityUtilTest(double weather) {
        this.weather = weather;
    }

    public CityUtilTest() {
    }

    public double getWeather() {
        return weather;
    }

    public void setWeather(double weather) {
        this.weather = weather;
    }

    @Test
    public void weatherSize_success(){
        assertTrue(weather <= 40);
    }

    @Test
    public void weatherSize_failure(City city){
        assertTrue(weather > 40);
    }
}
