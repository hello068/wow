package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import logic.Cart;
import logic.Item;
import logic.ItemService;
import logic.ItemSet;
import logic.ShopService;

@Controller
public class CartController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("cart/cartAdd")
	public ModelAndView add(Integer id, Integer quantity, HttpSession session){
		
		
		Item selectedItem = itemService.getItemList(id);
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart == null){
			cart = new Cart();
			session.setAttribute("CART", cart);
		}
		
		cart.push(new ItemSet(selectedItem, quantity));
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message", selectedItem.getName()+"을(를)"+quantity+"개 카트에 추가");
		mav.addObject("cart", cart);
		return mav;
	}
	
	@RequestMapping("cart/cartDelete")
	public ModelAndView delete(int index, HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("CART");
		String name = cart.remove(index);
		ModelAndView mav = new ModelAndView("cart/cart");
		
		mav.addObject("message", name+"을(를) 카트에서 제거했습니다.");
		mav.addObject("cart", cart);
		
		return mav;
	}
	
	@RequestMapping("cart/cartView")
	public ModelAndView cartView(HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException();
		}
		ModelAndView mav = new ModelAndView("cart/cart");
		
		mav.addObject("message", "현재 장바구니의 상품목록입니다.");
		mav.addObject("cart", cart);
		
		
		
		return mav;
	}
	
	

}
