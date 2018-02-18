package com.hossein.kesens.contoroller;


import com.hossein.kesens.model.Cart;
import com.hossein.kesens.model.access.Users;
import com.hossein.kesens.model.customer.Customer;
import com.hossein.kesens.model.product.Attribute;
import com.hossein.kesens.model.product.AttributeItem;
import com.hossein.kesens.model.product.Category;
import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.AccessService;
import com.hossein.kesens.service.ContextService;
import com.hossein.kesens.service.CustomerService;
import com.hossein.kesens.service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hossein on 3/13/17.
 */
@Controller
@Transactional
public class HomeController {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;


    @Autowired
    AccessService accessService;

    @Autowired
    private ContextService contextService;

    @RequestMapping("/")
    public String home(Model model) {

        Product product = productService.getProductById(14);
        model.addAttribute(product);
        model.addAttribute("contextService",contextService);
        return "product";
    }

    public Product getSampleProduct() {
        Product product = new Product();
        product.setName("علی");
        product.setSummaryDescription("متن خلاصه");
        product.setPrice(100);
        product.setQuantity(10);
        Category category = new Category();

        product.addCategory(category);
        productService.addProduct(product);
        return product;
    }
}
