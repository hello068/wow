package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/list")
	public ModelAndView list(){
		
		// itemlList : item 테이블의 모든 정보를 Item 객체로생성하여 List 형태 저장
		
		List<Item> itemList = itemService.getItemList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", itemList);
		return mav;
	}
	
	@RequestMapping("item/detail")
	public ModelAndView detail(Integer id){
		
		Item item = itemService.getItemList(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		
		return mav;
	}
	
	@RequestMapping("item/create")
	public ModelAndView create(){
		
		ModelAndView mav = new ModelAndView("item/add");
		mav.addObject(new Item());
		return mav;
	}
	
	@RequestMapping("item/register")
	public ModelAndView register(@Valid Item item, BindingResult bindingResult, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView("item/add");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		itemService.entryItem(item, request);
		mav.setViewName("redirect:/item/list.shop");
		return mav;
	}
	
	@RequestMapping("item/edit")
	public ModelAndView edit(Integer id){
		return detail(id);
	}
	
	@RequestMapping("item/update")
	public ModelAndView update(@Valid Item item,  BindingResult bindingResult, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("item/edit");
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		itemService.update(item, request);
		mav.setViewName("redirect:list.shop");
		return mav;
	}
	
	@RequestMapping("item/confirm")
	public ModelAndView confirm(Integer id){
		
		Item item = itemService.getItemList(id);
		ModelAndView mav = new ModelAndView("item/delete");
		mav.addObject("item", item);
		return mav;
	}
	
	@RequestMapping("item/delete")
	public String delete(Integer id){
		
		itemService.delete(id);
		return "redirect:list.shop";
	}

}















