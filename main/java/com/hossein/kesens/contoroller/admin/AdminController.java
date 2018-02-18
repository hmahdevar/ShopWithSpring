package com.hossein.kesens.contoroller.admin;

import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by hossein on 4/14/17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String admin(){
        return "redirect:/admin/productInventory";
    }
    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }



}
