package com.hossein.kesens.contoroller.admin;

import com.hossein.kesens.model.product.Attribute;
import com.hossein.kesens.model.product.AttributeItem;
import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.AttributeService;
import com.hossein.kesens.service.ContextService;
import com.hossein.kesens.service.AttributeItemService;
import com.hossein.kesens.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by hossein on 5/10/17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ContextService contextService;
    @Autowired
    private AttributeService attributeService;

    @Autowired
    private AttributeItemService attributeItemService;

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> productList = productService.getProductList();
        model.addAttribute("contextService", contextService);
        model.addAttribute(productList);
        return "admin/productInventory";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("contextService", contextService);
        List<AttributeItem> attributeItemList = attributeItemService.getAllAttributeItems();
        model.addAttribute("attributeItemList", attributeItemList);
        model.addAttribute(product);
        return "admin/addProduct";
    }


    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute Product product, BindingResult result
            , Model model) {
        model.addAttribute("contextService", contextService);
        if (result.hasErrors()) {
            return "/admin/addProduct";
        }
        for (Attribute attribute : product.getAttributeList()) {
            attribute.setProduct(product);
            if (attribute.getAttributeItemName() == "") {
                product.getAttributeList().remove(attribute);
            }

        }
        productService.addProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute(product);
        model.addAttribute("contextService", contextService);
        return "admin/addProduct";
    }


    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute Product product, BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/admin/editProduct";
        }
        productService.updateProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/removeProduct/{productId}")
    public String deleteProduct(@PathVariable(value = "productId") int productId) {
        productService.removeProductById(productId);
        return "redirect:/admin/productInventory";
    }



    @RequestMapping(value = "/removeAttribute", method = RequestMethod.POST)
    public
    @ResponseBody
    String removeAttribute( HttpServletRequest httpServletRequest) {
        int attributeId = Integer.parseInt(httpServletRequest.getParameter("attributeId"));
        attributeService.removeAttributeById(attributeId);
        return "deleted";
    }
}
