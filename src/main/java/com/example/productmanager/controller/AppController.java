package com.example.productmanager.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.productmanager.entity.Product;
import com.example.productmanager.service.ProductService;

@Controller //@Controller必须配合模版来使用。对应在resources目录的templates目录下的文件
public class AppController {
    @Autowired  //自动生成ProductService service
    private ProductService service;

    @RequestMapping("/")    //由于有了@Controller，通过return "index"，这里对应了的是index.html
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts); //对应index.html的${listProducts}

        return "index";
    }

    @RequestMapping("/new")   //对应 接口"/new"
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product); //把product对象，再对应到model中的product

        return "new_product";   //通过return "new_product"，然后把model放到new_product.html中
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) //对应 接口"/save" 方法是POST发送
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/";    //传递数据到 http://localhost:8080/
    }

    @RequestMapping("/edit/{id}")   //对应html的接口 th:href="@{'/edit/'"
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) { //把/edit/{id}的id，放到这函数的id变量中
        ModelAndView mav = new ModelAndView("edit_product");    //对应templates/edit_product.html，并打开edit_product
        Product product = service.get(id);  //通过id，来创建Product对象
        mav.addObject("product", product); //把刚才的product对象，插进ModelAndView中。相当于就是product对象，放到edit_product.html页面中

        return mav; //执行ModelAndView的操作
    }

    @RequestMapping("/delete/{id}") //对应html的接口 th:href="@{'/delete/'"
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";    //传递数据到 http://localhost:8080/
    }
}