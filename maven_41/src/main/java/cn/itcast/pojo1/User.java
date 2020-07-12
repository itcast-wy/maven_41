package cn.itcast.pojo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加无参构造
 * 有参构造
 * toString
 * setter/getter
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String birthday;
    private String sex;
    private String address;
}
