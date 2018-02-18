package com.hossein.kesens.contoroller;

import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.ContextService;
import com.hossein.kesens.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by hossein on 4/14/17.
 */
@Controller
public class ProductController {
    @Autowired
    private ContextService contextService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String getProduct(@PathVariable(value = "productId") int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute(product);
        model.addAttribute("contextService",contextService);
        return "product";
    }

    @RequestMapping(value = "/productList")
    public String productList(Model model) {
        List<Product> productList = productService.getProductList();
        model.addAttribute("productList",productList);
        model.addAttribute("contextService",contextService);
        return "productList";
    }
}
