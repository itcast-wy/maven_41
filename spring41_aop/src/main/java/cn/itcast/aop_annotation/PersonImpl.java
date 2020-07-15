package cn.itcast.aop_annotation;

import org.springframework.stereotype.Component;

@Component
public class PersonImpl implements Person {

    public void work() {
        System.out.println("我爱加班!!");
    }

    public void addPerson() {
        System.out.println("添加用户");
    }

    public void deletePerson() {
        System.out.println("删除用户");

    }

    public void updatePerson() {
        System.out.println("修改用户");
        int i = 1/0;
    }

    public void queryPerson() {
        System.out.println("查询用户");
    }

    public void batchDeletePerson() {
        System.out.println("批量删除用户");
        int i = 1/0;
    }
}
