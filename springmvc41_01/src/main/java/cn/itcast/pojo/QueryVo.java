package cn.itcast.pojo;

import lombok.Data;

import java.util.List;

@Data
public class QueryVo {
    private Item item;
    private List<Item> list;
    private int[] ids;


}
