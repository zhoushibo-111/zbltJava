package com.zsb.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

@SpringBootApplication
//配置Mapper包扫描
@MapperScan("com.zsb.base.dao")
public class BaseApplication {
    public static void main(String[]args){
        SpringApplication.run(BaseApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
