package cn.itcast.aop_annotation;

public interface Person {

    public void work();

    public void addPerson();  // 前置增强该方法

    public void deletePerson();  //后置增强该方法

    public void updatePerson();  //异常增强

    public void queryPerson();  //环绕增强

    public void batchDeletePerson();  //最终增强
}