package io.github.LeviSouza.clientes.util;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalCenverter {

    public BigDecimal converter(String value){

        if(value==null){return null;}

        value = value.replace(".","").replace(",",".");
        return new BigDecimal(value);
    }
}
