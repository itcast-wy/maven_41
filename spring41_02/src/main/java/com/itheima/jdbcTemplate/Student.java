package com.itheima.jdbcTemplate;

import lombok.Data;
import lombok.NoArgsConstructor;

// 相当于@Getter @Setter @NoArgsConstructor @ToString
@Data
public class Student {
    private String sid;
    private String sname;
    private String schoolName;
    private String score;
}
