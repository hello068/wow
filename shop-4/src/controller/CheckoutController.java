package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import logic.Cart;
import logic.Sale;
import logic.ShopService;
import logic.User;

@Controller
public class CheckoutController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("checkout/checkout")
	public ModelAndView checkout(HttpSession session){
		
		User loginUser = (User)session.getAttribute("USER");
		if(loginUser == null){
			throw new LoginRequiredException();
		}
		
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException();
		}
		
		ModelAndView mav = new ModelAndView();
		Long totalAmount = shopService.calculateTotalAmount(cart.getItemList());
		
		mav.addObject("itemList", cart.getItemList());
		mav.addObject("loginUser", loginUser);
		mav.addObject("totalAmount", totalAmount);
		
		return mav;
	}
	
	@RequestMapping("checkout/end")
	public ModelAndView end(HttpSession session){
		
		User loginUser = (User)session.getAttribute("USER");
		
		if(loginUser == null){
			throw new LoginRequiredException();
		}
		Cart cart = (Cart)session.getAttribute("CART");
		
		if(cart == null || cart.isEmpty()){
			throw new CartEmptyException();
		}
		// 주문 정보 저장하기
		Sale sale = shopService.checkEnd(loginUser, cart);
		
		// 총 주문 금액 계산하기
		long totalAmount = shopService.calculateTotalAmount(cart.getItemList());
		
		// 뷰 설정하기
		ModelAndView mav = new ModelAndView();
		cart.clearAll(session);
		mav.addObject("totalAmount", totalAmount);
		mav.addObject("loginUser", loginUser);
		mav.addObject("sale", sale);
		
		return mav;
	}
	

}
