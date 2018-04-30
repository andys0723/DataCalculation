package com.andys0723.Config;


import com.andys0723.Model.Stock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:stockPrice.props")
@ComponentScans(value = { @ComponentScan("com.andys0723") })
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public List<Stock> stocks(){
        List<Stock> stocks = new ArrayList<>();
        return stocks;
    }


    @Bean
    public List<String> ZeroInterpretation(@Value("${file.interpretion.zero}") final String specialInter){
        List<String> ZeroInterpretation = new ArrayList<>();
        String[] strings = specialInter.split(",");
        for(String string: strings){
            ZeroInterpretation.add(string);
        }
        System.out.println(ZeroInterpretation);
        return ZeroInterpretation;
    }

}
