package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int id;
    private String name;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private String detail;

    public Item(int id, String name, double price, Date createtime, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createtime = createtime;
        this.detail = detail;
    }

    // 存储到数据库的时候,我们是需要提供一个相对路径
    private String pic = "images/a.jpg";
}
