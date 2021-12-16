package rw.ac.rca.termOneExam.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rw.ac.rca.termOneExam.domain.City;
import rw.ac.rca.termOneExam.dto.CreateCityDTO;
import rw.ac.rca.termOneExam.repository.ICityRepository;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    @Mock
    private ICityRepository cityRepositoryMock;

    @InjectMocks
    private CityService cityService;

    @Test
    public void getAll_success() {
        when(cityRepositoryMock.findAll()).thenReturn(Arrays.asList(new City(10,"Musanze",20,68), new City(11,"Huye",50,122)));
        assertEquals(10,cityService.getAll().get(0).getId());
        assertEquals("Huye",cityService.getAll().get(1).getName());
    }

    @Test
    public void  getOneById_success(){
        City city = new City(10,"Rubavu",20,68);
        when(cityRepositoryMock.findById(10L)).thenReturn(Optional.of(city));
        assertEquals(cityService.getById(10L).get(), city);
    }

    @Test
    public void getOneById_failure(){
        Optional emptyOptional = Optional.empty();
        when(cityRepositoryMock.findById(10L)).thenReturn(emptyOptional);
        assertTrue(cityService.getById(10L).isEmpty());
    }

    @Test
    public void existsByName_success(){
        when(cityRepositoryMock.existsByName("Kigali")).thenReturn(true);
        assertEquals(cityService.existsByName("Kigali"), true);
    }

    @Test
    public void existsByName_failure(){
        when(cityRepositoryMock.existsByName("Kinshasa")).thenReturn(false);
        assertEquals(cityService.existsByName("Kinshasa"), false);
    }


    @Test
    public void save_success(){
        CreateCityDTO cityDTO = new CreateCityDTO();
        cityDTO.setName("Dubai");
        cityDTO.setWeather(20);

        City city = new City(cityDTO.getName(),cityDTO.getWeather());
        when(cityRepositoryMock.save(any(City.class))).thenReturn(city);
        assertNotNull(cityService.save(cityDTO).getId());
        assertEquals(cityDTO.getWeather(), cityService.save(cityDTO).getWeather(),0);
    }

    @Test
    public void save_failure(){
        CreateCityDTO cityDTO = new CreateCityDTO();
        when(cityRepositoryMock.save(any(City.class))).thenReturn(null);
        assertTrue(cityService.save(cityDTO) == null);
        assertNull(cityService.save(cityDTO));
    }


}
