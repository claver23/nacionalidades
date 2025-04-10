package com.api.nacionalidades.util;

import com.api.nacionalidades.model.CountryCode;

import java.util.*;


public class CountryCodeLister {
    public List<CountryCode> retrieveCountries() {
        String[] isoCountries = Locale.getISOCountries();

        List<CountryCode> countryCodeList = new ArrayList<>();
        for (String alpha2Code : isoCountries) {
            try {
                Locale locale = new Locale("", alpha2Code);
                String alpha3Code = locale.getISO3Country();
                String countryName = locale.getDisplayCountry(Locale.ENGLISH);
                if (!countryName.isEmpty()) {
                    countryCodeList.add(new CountryCode(alpha2Code, alpha3Code, countryName));
                }
            } catch (Exception e) {
                System.err.println("Hubo un error con el código: " + alpha2Code);
            }
        }
        countryCodeList.sort(Comparator.comparing(CountryCode::getAlpha3Code));
        return countryCodeList;
    }
}