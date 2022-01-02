package com.tomo.breweryclient.web.client;

import com.tomo.breweryclient.web.model.BeerDto;
import com.tomo.breweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "app.brewery", ignoreUnknownFields = false)
public class BreweryClient
{
    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String apihost;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid)
    {
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto)
    {
      return restTemplate.postForLocation(apihost + BEER_PATH_V1 + "/", beerDto);
    }

    public void updateBeer(UUID uuid ,BeerDto beerDto)
    {
        restTemplate.put(apihost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid)
    {
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid);
    }

    public CustomerDto getCustomerById(UUID uuid)
    {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto)
    {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1 + "/", customerDto);
    }

    public void updateCustomer(UUID uuid ,CustomerDto customerDto)
    {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + "/" + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid)
    {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/" + uuid);
    }

    public void setApihost(String apihost)
    {
        this.apihost = apihost;
    }
}
