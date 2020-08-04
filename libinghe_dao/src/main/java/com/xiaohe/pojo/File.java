package com.xiaohe.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class File {
    private Integer id;
    private String file_name;
    private String content;
    private String upload_name;
    @JsonFormat(pattern = "yyyy-MM-dd ",locale = "zh",timezone = "GMT+8")
    private Date upload_date;
    private Integer type_id;
    private Type type;

}
