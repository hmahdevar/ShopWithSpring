package com.hossein.kesens.contoroller.admin;

import com.hossein.kesens.model.product.AttributeItem;
import com.hossein.kesens.service.AttributeItemService;
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
 * Created by hossein on 5/9/17.
 */
@Controller

public class AttributeItemController {
    @Autowired
    private AttributeItemService attributeItemService;
    @Autowired
    private ContextService contextService;
    @RequestMapping("/admin/attributeItemInventory")
    public String attributeItemInventory(Model model){
        model.addAttribute("attributeItemList",attributeItemService.getAllAttributeItems());
        model.addAttribute("contextService",contextService);
        return "/admin/attributeItemInventory";
    }

    @RequestMapping("/admin/addAttributeItem")
    public String addAtttributeItem(Model model){
        AttributeItem attributeItem = new AttributeItem();
        model.addAttribute(attributeItem);
        model.addAttribute("contextService",contextService);
        return "/admin/addAttributeItem";
    }
    @RequestMapping(value = "/admin/addAttributeItem",method = RequestMethod.POST)
    public String addAttributeItem(@Valid @ModelAttribute AttributeItem attributeItem, BindingResult result){
        if (result.hasErrors()) {
            return "redirect:/admin/addAttribute";
        }
        attributeItemService.addAttributeItem(attributeItem);
        return "redirect:/admin/attributeItemInventory";
    }

    @RequestMapping(value = "/admin/removeAttributeItem/{attributeItemId}")
    public String deleteAttributeItem(@PathVariable (value = "attributeItemId") int attributeItemId) {
        attributeItemService.removeAttributeItemById(attributeItemId);
        return "redirect:/admin/attributeItemInventory";
    }
    @RequestMapping(value = "/admin/editAttributeItem/{attributeItemId}")
    public String editAttributeItem(@PathVariable (value = "attributeItemId") int attributeItemId,Model model) {
        AttributeItem attributeItem = attributeItemService.getAttributeItemById(attributeItemId);
        model.addAttribute(attributeItem);
        model.addAttribute("contextService",contextService);
        return "/admin/addAttributeItem";
    }
}
