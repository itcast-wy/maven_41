package cn.itcast.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 - 里面有一个属性username ,
 - 有一个play的方法;
 */
@Getter
@Setter
@AllArgsConstructor
public class UserService {

    public UserService() {
//        System.out.println("UserService构造方法被调用");
    }

    private String username;

    public void play(){
        System.out.println("----------play方法: ----------username:"+username);
    }

}
