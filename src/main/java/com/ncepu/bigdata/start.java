package com.ncepu.bigdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@CrossOrigin(origins = "*")
//@MapperScan("com.ncepu.bigdata.mapper")
class start {
    @Bean
    public Converter<String, Date> addNewConvert(){
        return new Converter<String,Date>(){
            @Override
            public Date convert(String source){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
                Date date=null;
                try {
                    date = sdf.parse( source);
                }catch(Exception e){
                    e.printStackTrace();
                }
                return date;
            }
        };
    }

    public static void main(String[] args){
        SpringApplication.run(start.class,args);
    }
}
