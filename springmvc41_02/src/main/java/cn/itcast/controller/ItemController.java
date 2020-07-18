package cn.itcast.controller;

import cn.itcast.pojo.Item;
import cn.itcast.pojo.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * 1. 类上加 @Controller
 * 2. 方法的返回值ModelAndView
 * 3. 方法上加入地址配置
 *
 *
 */
@Controller
@RequestMapping("/")
public class ItemController {

    /*@RequestMapping("/itemList")
    public ModelAndView itemList(){
        // 获取数据
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹"));
        list.add(new Item(2,"奔驰S650",350,new Date(),"可以看"));
        list.add(new Item(3,"挖土机",80,new Date(),"可以开"));
        list.add(new Item(4,"小米扫地机器人",3500,new Date(),"可以坐"));
        // 构建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        // 设置数据 类似 req.setAttribute("itemList",list)
        mv.addObject("itemList",list);
        // 设置jsp的路径
        mv.setViewName("itemList");
        // 返回mv
        return mv;
    }*/

    /**
     * ============不推荐!!!=========
     * 需求: 保存更新 , 页面跳转到success.jsp页面
     * 目的: 返回值类型为void
     */
    /*@RequestMapping("/itemList")
    public void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹"));
        list.add(new Item(2,"奔驰S650",350,new Date(),"可以看"));
        list.add(new Item(3,"挖土机",80,new Date(),"可以开"));
        list.add(new Item(4,"小米扫地机器人",3500,new Date(),"可以坐"));
        //缺少ModelAndView , 如何封装数据 ,
        request.setAttribute("itemList",list);
        //如何跳转页面
        request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request,response);
    }*/

    /**
     * 返回值是JSP的地址,因为我们配置了视图解析器的前缀和后缀,所以只需要写jsp的文件名就可以了
     * 参数Model,直接往里边设置值即可
     */
    @RequestMapping("/itemList")
    public String itemList(Model model){

        System.out.println("-------ItemController---itemList()-----------");

        // 获取数据
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹"));
        list.add(new Item(2,"奔驰S650",350,new Date(),"可以看"));
        list.add(new Item(3,"挖土机",80,new Date(),"可以开"));
        list.add(new Item(4,"小米扫地机器人",3500,new Date(),"可以坐"));

        // 设置数据
        model.addAttribute("itemList",list);
        // 返回jsp地址
        return "itemList";
    }


    /**
     * 如果是基本类型,可以直接以参数的方式去接收,方法的参数名必须和url中的参数名保持一致
     * 如果参数名不对应呢?
     * 我们可以使用@RequestParam注解
     * @RequestParam(value="id",required = true,defaultValue = "1") int myId
     * value: 指的是url中的哪个参数名要赋值给该方法的参数 id -> myId
     * required: 该参数是否是必须的
     * defaultValue: 当没有传参的时候,给予的默认值
     */
    @RequestMapping("/itemEdit")
//    public ModelAndView itemEdit(int id){
    public ModelAndView itemEdit(@RequestParam(value="id",required = true,defaultValue = "1") int myId){
        System.out.println("id:"+myId);
        // 模拟数据
        Item item  = new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹","/images/a.jpg");

        // 构建mv
        ModelAndView mv = new ModelAndView();
        mv.addObject("item",item);
        mv.setViewName("itemEdit");
        return mv;
    }


    /**
     * queryItem.action
     * 包装类类型 属性.属性的方式进行绑定
     */
    @RequestMapping("/queryItem")
    public String queryItem(int id){

//        return "redirect:/itemEdit.action?id=2";
        return "forward:/itemEdit.action";
    }



    @RequestMapping("/updateItem.action")
    public String updateItem(MultipartFile pictureFile) throws Exception {
        //原始文件名称
        String pictureFile_name = pictureFile.getOriginalFilename();
        //上传图片
        File uploadPic = new java.io.File("E:/bigdata_ws3/springmvc41_02/src/main/webapp/images/"+pictureFile_name);
        //向磁盘写文件
        pictureFile.transferTo(uploadPic);

        // ... 存到数据库中 只需要写上相对路径即可 /images/xxx.jpg 即可
        return "success";
    }

    /**
     * 前端提交过来的是json
     * 我们返回给前端的也是json
     * @param item
     * @return
     */
    @RequestMapping("/jsonDemo.action")
    @ResponseBody
    public Item jsonDemo(@RequestBody Item item)  {

        return new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹");
    }


    @RequestMapping("/jsonDemo2.action")
    @ResponseBody
    public String abc()  {

//        return new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹");
        return "hello world";
    }




}
