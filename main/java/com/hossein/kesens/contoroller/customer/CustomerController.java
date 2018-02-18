package com.hossein.kesens.contoroller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hossein on 4/25/17.
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/")
    public String cart(){
        return "customer/cart";
    }
}
