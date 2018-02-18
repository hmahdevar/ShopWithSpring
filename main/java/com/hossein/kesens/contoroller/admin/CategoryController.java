package com.hossein.kesens.contoroller.admin;

import com.hossein.kesens.model.product.Category;
import com.hossein.kesens.service.CategoryService;
import com.hossein.kesens.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by hossein on 5/10/17.
 */
@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ContextService contextService;
    @RequestMapping("/admin/categoryInventory")
    public String categoryInventory(Model model){
        model.addAttribute("categoryList",categoryService.getAllCategorys());
        model.addAttribute("contextService",contextService);
        return "/admin/categoryInventory";
    }

    @RequestMapping("/admin/addCategory")
    public String addAtttributeItem(Model model){
        Category category = new Category();
        model.addAttribute(category);
        model.addAttribute("contextService",contextService);
        return "/admin/addCategory";
    }
    @RequestMapping(value = "/admin/addCategory",method = RequestMethod.POST)
    public String addCategory(@Valid @ModelAttribute Category category, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/admin/addAttribute";
        }
        categoryService.addCategory(category);
        return "redirect:/admin/categoryInventory";
    }

    @RequestMapping(value = "/admin/removeCategory/{categoryId}")
    public String deleteCategory(@PathVariable(value = "categoryId") int categoryId) {
        categoryService.removeCategoryById(categoryId);
        return "redirect:/admin/categoryInventory";
    }
    @RequestMapping(value = "/admin/editCategory/{categoryId}")
    public String editCategory(@PathVariable (value = "categoryId") int categoryId,Model model) {
        Category category = categoryService.getCategoryById(categoryId);
        model.addAttribute(category);
        model.addAttribute("contextService",contextService);
        return "/admin/addCategory";
    }
}
