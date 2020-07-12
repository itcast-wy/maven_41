package cn.itcast.life;

/**
 * 演示生命周期
 * 在spring容器启动的时候:
 * 1: 调用构造方法
 * 2: 执行init-method
 * 3: 在容器销毁的时候,会调用destroy-method
 * 4: 容器销毁之后,已经获取到的对象可以继续使用
 * 5: 容器销毁之后,再次获取对象就会报错
 */
public class Student  {

    public Student(){
        System.out.println("Student构造方法被调用");
    }

    public void init(){
        System.out.println("容器创建时调用了");
    }

    public void service(){
        System.out.println("stu对象的service方法执行了");
    }

    public void destroy(){
        System.out.println("容器销毁时调用...");
    }
}
