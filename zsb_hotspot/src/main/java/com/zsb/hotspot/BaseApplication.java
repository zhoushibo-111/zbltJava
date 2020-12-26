package com.zsb.hotspot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;
import util.IdWorker;
@SpringBootApplication
//Mapper扫描注解
@EnableOpenApi
@EnableEurekaClient
@MapperScan("com.zsb.hotspot.dao")
//@EnableElasticsearchRepositories(basePackages = "com.zsb.hotspot.dao")
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }



    @Bean

    public IdWorker idWorker(){

        return new IdWorker(1,1);

    }

}
