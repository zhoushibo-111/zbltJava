package com.zsb.hotspot.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName = "zsb_hotspot")
@Data
public class Searchspot implements Serializable {
    @Id
    private String _id;
    //是否索引 就是看该域是否能被搜索 分词 存储
    @Field(index=true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word") //代表索引
    private String title;
    @Field(index=true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;
    private String state;       //审核状态

    public Searchspot(String _id, String title, String content) {
        this._id = _id;
        this.title = title;
        this.content = content;
    }
}
