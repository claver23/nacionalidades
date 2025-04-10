package com.api.nacionalidades.expose;

import com.api.nacionalidades.NacionalidadesApplication;
import com.api.nacionalidades.model.CountryCode;
import com.api.nacionalidades.util.CountryCodeLister;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryCodeController {

    @GetMapping(path = "/")
    public List<CountryCode> listCuntryCodes(){
        CountryCodeLister cdl = new CountryCodeLister();
        return cdl.retrieveCountries();
    }
}
