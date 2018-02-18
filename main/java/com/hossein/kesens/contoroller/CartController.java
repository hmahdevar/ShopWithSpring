package com.hossein.kesens.contoroller;

import com.hossein.kesens.model.Cart;
import com.hossein.kesens.model.CartItem;
import com.hossein.kesens.model.product.Product;
import com.hossein.kesens.service.ProductService;
import com.hossein.kesens.service.TempCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by hossein on 5/3/17.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;
    @Autowired
    private TempCartService tempCartService;

    @RequestMapping
    public String get(HttpSession httpSession, Model model) {

        Cart cart = getCartFromSession(httpSession);
        model.addAttribute(cart);
        return "cart";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public
    @ResponseBody
    String addToCart(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        int productId = Integer.parseInt(httpServletRequest.getParameter("productId"));
        int quantity = Integer.parseInt(httpServletRequest.getParameter("quantity"));
        Cart cart = getCartFromSession(httpSession);
        for (CartItem cartItem : cart.getCartItemList()) {
            if (cartItem.getProduct().getProductId() == productId) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return "quantity product" + productId + " increased" + quantity;
            }
        }
        Product product = productService.getProductById(productId);
        CartItem cartItem = new CartItem(product, quantity);
        cart.getCartItemList().add(cartItem);
        httpSession.setAttribute("cart", cart);
        return "added product" + productId + " increased" + quantity;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public
    @ResponseBody
    String removeFromCart(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        int productId = Integer.parseInt(httpServletRequest.getParameter("productId"));
        Cart cart = getCartFromSession(httpSession);
        for (CartItem cartItem : cart.getCartItemList()) {
            if (cartItem.getProduct().getProductId() == productId) {
                cart.getCartItemList().remove(cartItem);
                return "removed";
            }
        }
        return productId + " not found in cart";
    }

    @RequestMapping(value = "/clear")
    public
    @ResponseBody
    String clearCart(HttpSession httpSession) {
        Cart cart = getCartFromSession(httpSession);
        cart.getCartItemList().clear();
        httpSession.removeAttribute("cart");
        return "cleared";
    }

    public Cart getCartFromSession(HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        if (cart == null)
            cart = new Cart();
        return cart;
    }
}
