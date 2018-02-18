package com.hossein.kesens.contoroller;

import com.hossein.kesens.model.Cart;
import com.hossein.kesens.model.CartItem;
import com.hossein.kesens.model.customer.Customer;
import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.CartItemService;
import com.hossein.kesens.service.CartService;
import com.hossein.kesens.service.CustomerService;
import com.hossein.kesens.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hossein on 4/25/17.
 */
@Controller
@RequestMapping("/cartResources")
public class CartResources {
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/{cartId}")
    public
    @ResponseBody
    Cart getCartById(@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    //chand ta az ye mahsole add koni
    //bayad ye add deige bara tedad mahsole begire
    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addToCart(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByEmail(activeUser.getUsername());
        Product product = productService.getProductById(productId);
        List<CartItem> cartItemList = customer.getCart().getCartItemList();
        for (int i = 0; i < customer.getCart().getCartItemList().size(); i++) {
            if (productId == cartItemList.get(i).getProduct().getProductId()) {
                CartItem cartItem = cartItemList.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
                cartItemService.addCartItem(cartItem);
            }
        }
        CartItem cartItem = new CartItem(product);
        cartItem.setCart(customer.getCart());
        customer.getCart().getCartItemList().add(cartItem);
        cartItemService.addCartItem(cartItem);
    }


}
