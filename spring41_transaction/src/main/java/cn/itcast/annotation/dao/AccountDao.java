package cn.itcast.annotation.dao;

public interface AccountDao {

    /**
     * 转入
     * @param inName
     * @param money
     */
    public void transferIn(String inName,double money);

    /**
     * 转出
     * @param outName
     * @param money
     */
    public void transferOut(String outName,double money);
}