package cn.itcast.demo;

import cn.itcast.life.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class StudentTest {

    @Test
    public void service(){
        // 通过Spring来加载对象,不能直接new!!!
        // 1. 加载出Spring的Context对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean01.xml");
        // 2. 获取 Student
        Student student = context.getBean("student", Student.class);
        // 3. 调用方法
        student.service();
        // 4. 手动关闭Spring容器
        context.close();
        // student对象已经获取到了,可以继续使用
        student.service();

        // 再次使用context获取bean,就会报错,因为此时spring容器已经关闭了
        Student student1 = context.getBean("student", Student.class);
        // 也是报错的!!!
        student1.service();

    }



}
