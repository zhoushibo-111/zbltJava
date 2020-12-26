package com.zsb.hotspot.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Date;
@Data
public class Comment {
    @Id
    private String _id;

    private String hotspotid;

    private String content;

    private String userid;

    private String parentid;

    private Date publishdate;

    private Integer thumbup;
}
