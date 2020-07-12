package cn.itcast.di;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String address;
    private Date birthday;

    public Person(String name1, int age1, String address, Date birthday) {
        this.name = name1;
        this.age = age1;
        this.address = address;
        this.birthday = birthday;
    }
}
