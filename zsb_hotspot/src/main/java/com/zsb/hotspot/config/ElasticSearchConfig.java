//package com.zsb.hotspot.config;
//
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//
//@Configuration
//public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {
//    @Bean
//    public RestHighLevelClient restHighLevelClient(){
//        ClientConfiguration configuration = ClientConfiguration.builder(
//        )
//                .connectedTo("123.57.103.18:9200")
//                //.withConnectTimeout(Duration.ofSeconds(5))
//                //.withSocketTimeout(Duration.ofSeconds(3))
//                //.useSsl()
//                //.withDefaultHeaders(defaultHeaders)
//                //.withBasicAuth(username, password)
//                // ... other options
//                .build();
//        RestHighLevelClient client = RestClients.create(configuration).rest();
//        return client;
//    }
//
//    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        return null;
//    }
//}
//
