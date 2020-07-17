package cn.itcast.controller;

import cn.itcast.pojo.Item;
import cn.itcast.pojo.QueryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1. 类上需要@Controller注解
 * 2. 在类中开发Handler方法,类似doGet/doPost
 * 3. 在Handler上需要返回ModelAndView(模型数据+视图地址)
 * 4. 需要在Handler上配置@RequestMapping("地址")
 * 5. 需要指定模型数据在jsp的key,编写jsp即可
 */
@Controller
// 类上加@RequestMapping("/item"),那么在请求方法的时候一定要加上/item前缀
@RequestMapping("/item")
public class ItemController {

    /*
    * @RequestMapping("/itemList.action")
    * @RequestMapping("/itemList")
    * 上述两种方式都是ok的,后缀名可以省略,建议是不加
    * 路径中建议以 / 开头,不要省略
    */
//    @RequestMapping(value="/itemList",method = RequestMethod.GET)
//    @RequestMapping(value="/itemList",method = RequestMethod.POST)
//    @RequestMapping(value="/itemList",method = {RequestMethod.POST,RequestMethod.GET})
    // 在Spring4.3之后,推出了更加简单的注解 @GetMapping("/itemList") 等价于  @RequestMapping(value="/itemList",method = RequestMethod.GET)
    @PostMapping("/itemList")
    @GetMapping("/itemList")
    public ModelAndView itemList(){

        //模拟假数据Model
        List<Item> modelData = new ArrayList<Item>();
        modelData.add(new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹"));
        modelData.add(new Item(2,"奔驰S650",350,new Date(),"可以看"));
        modelData.add(new Item(3,"挖土机",80,new Date(),"可以开"));
        modelData.add(new Item(4,"小米扫地机器人",3500,new Date(),"可以坐"));
        modelData.add(new Item(5,"小米显示器",599,new Date(),"可以看"));

        // 定义jsp的地址View
//        String jspLocation = "/WEB-INF/jsp/itemList.jsp";
        String jspLocation = "itemList";

        // 构建 ModelAndView
        ModelAndView mv = new ModelAndView();
        mv.addObject("itemList",modelData);
        mv.setViewName(jspLocation);

        // 返回视图
        return mv;
    }




    /**
     * 当用户访问 /itemEdit.action路径的时候接收参数id,并跳转到itemEdit.jsp
     * 可以使用 HttpServletRequest 来接收参数, SpringMVC会自动的给这个方法的request参数赋值
     *
     * Handler的参数列表上可以直接使用以下任意类型,顺序不固定,个数也不固定
     * HttpServletRequest, HttpServletResponse , HttpSession
     */
    /*@RequestMapping("/itemEdit")
    public ModelAndView itemEdit(HttpServletRequest request){

        // 获取id
        String id = request.getParameter("id");
        // 模拟数据
        Item item  = new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹");

        // 构建mv
        ModelAndView mv = new ModelAndView();
        mv.addObject("item",item);
        mv.setViewName("itemEdit");
        return mv;
    }*/


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
        Item item  = new Item(1,"华为Mate20",9999,new Date(),"可以挡子弹");

        // 构建mv
        ModelAndView mv = new ModelAndView();
        mv.addObject("item",item);
        mv.setViewName("itemEdit");
        return mv;
    }

    /**
     * 多参数绑定,参数名和表单name一致即可
     * @param item
     * @return
     */
    /*@RequestMapping("/updateItem")
    public ModelAndView updateItem(int id, String name, double price, String detail){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        System.out.println("price:"+price);
        System.out.println("detail:"+detail);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("itemList");
        return mv;
    }
*/

    /**
     * 如果参数类型是Pojo的,表单的name或者url的参数如果和pojo中的属性名保持一致,即可直接绑定
     * @param item
     * @return
     */
    @RequestMapping("/updateItem")
    public ModelAndView updateItem(Item item){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("itemList");
        return mv;
    }


    /**
     * queryItem.action
     * 包装类类型 属性.属性的方式进行绑定
     */
    @RequestMapping("/queryItem")
    public ModelAndView queryItem(QueryVo queryVo,int[] ids){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("itemList");
        return mv;
    }


    /**
     * 数组形式接收参数
     * ids
     */
    /*@RequestMapping("/queryItem")
    public ModelAndView queryItem(int[] ids){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("itemList");
        return mv;
    }*/



    @RequestMapping("/batchUpdate")
    public ModelAndView batchUpdate(QueryVo queryVo,List<Item> list){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;
    }





}
