package com.robert.ssipl.controllers;

import com.robert.ssipl.model.Country;
import com.robert.ssipl.services.countryServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by robert on 26/10/16.
 */
@RestController
public class countryController {
    countryServices countryService = new countryServices();

    @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Country> getCountries() {
        List<Country> listOfCountries = countryService.getAllCountries();
        return listOfCountries;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable int id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);

    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCountry(@PathVariable("id") int id) {
        countryService.deleteCountry(id);

    }
}