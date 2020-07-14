package cn.itcast.di;

import lombok.Data;

import java.util.*;

/**
 * 采用的是set方式注入
 */
@Data
public class ComplexBean {
    private String[] arr;
    private List<Person> list;
    private Set<Integer> set;
    private Map<String,Person> map;
    private Properties properties;
}
