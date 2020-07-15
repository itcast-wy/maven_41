package cn.itcast.aop_xml;

public interface User {

    public void work();

    public void addUser();  // 前置增强该方法

    public void deleteUser();  //后置增强该方法

    public void updateUser();  //异常增强

    public void queryUser();  //环绕增强

    public void batchDeleteUser();  //最终增强
}
