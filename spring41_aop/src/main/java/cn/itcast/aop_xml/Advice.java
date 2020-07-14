package cn.itcast.aop_xml;

//增强类
public class Advice {

    public void writeLog(){
        System.out.println("记录日志");
    }

    public void before() {
        System.out.println("----before----");
        // 开启事务
        // 日志的记录
        // 记录程序的当前时间
    }

    public void after() {
        System.out.println("----after----");
        // 提交事务
        // 日志的记录
        // 记录程序的当前时间,计算程序的运行时间
    }


    public void work() {
        System.out.println("----Advice的work----");
        // 提交事务
        // 日志的记录
        // 记录程序的当前时间,计算程序的运行时间
    }
}
