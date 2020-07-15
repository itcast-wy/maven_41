package cn.itcast.xml.service;

public interface AccountService {

    //转账
    public void transfer(String inName,String outName, double money);
}
