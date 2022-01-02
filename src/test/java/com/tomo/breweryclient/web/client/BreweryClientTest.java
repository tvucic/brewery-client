package com.tomo.breweryclient.web.client;

import com.tomo.breweryclient.web.model.BeerDto;
import com.tomo.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest
{
    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById()
    {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveNewBeer()
    {
        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI location = breweryClient.saveNewBeer(beerDto);
        assertNotNull(location);
        System.out.println(location);;

    }
    @Test
    void testUpdateBeer()
    {
        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer()
    {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
    @Test
    void getCustomerById()
    {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer()
    {
        // given
        CustomerDto customerDto = CustomerDto.builder().name("John Doe").build();
        URI location = breweryClient.saveNewCustomer(customerDto);
        assertNotNull(location);
        System.out.println(location);;
    }

    @Test
    void updateCustomer()
    {
        // given
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer()
    {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}