package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.AgencyRepository;
import com.app.dao.CityRepository;
import com.app.dao.CountryRepository;
import com.app.dao.StateRepository;
import com.app.pojos.Agency;
import com.app.pojos.City;
import com.app.pojos.Country;
import com.app.pojos.State;

@Service
@Transactional
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyRepository agencyRepo;

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private StateRepository stateRepo;

    @Autowired
    private CountryRepository countryRepo;

    @Override
    public String addAgencyDetails(Agency agency) {
        // Retrieve City by name from the repository
        City city = cityRepo.findByCityName(agency.getCity().getCityName());
        if (city == null) {
            return "City not found";
        }
        agency.setCity(city);

        // Retrieve State by name from the repository
        State state = stateRepo.findByStateName(agency.getState().getStateName());
        if (state == null) {
            return "State not found";
        }
        agency.setState(state);

        // Retrieve Country by name from the repository
        Country country = countryRepo.findByCountryName(agency.getCountry().getCountryName());
        if (country == null) {
            return "Country not found";
        }
        agency.setCountry(country);

        Agency persistentAgency = agencyRepo.save(agency);
        return "User registered with ID " + persistentAgency.getId();
    }
}
