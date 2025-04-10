package com.api.nacionalidades.util;

import com.api.nacionalidades.model.CountryCode;

import java.util.*;


public class CountryCodeLister {
    public List<CountryCode> retrieveCountries() {
        Set<String> isoCountries = Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA3);

        List<CountryCode> countryCodeList = new ArrayList<>();
        for (String countryCode : isoCountries) {
            Locale locale = new Locale("en", countryCode);
            countryCodeList.add(new CountryCode(countryCode, locale.getISO3Language()));
        }
        countryCodeList.sort(Comparator.comparing(CountryCode::getCode));
        return countryCodeList;
    }
}