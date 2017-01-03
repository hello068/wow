package controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.AdminRequiredException;
import exception.LoginRequiredException;
import exception.MailEmptyException;
import logic.Item;
import logic.ItemService;
import logic.Sale;
import logic.SaleItem;
import logic.ShopService;
import logic.User;

@Controller
public class UserController {
	
	private final String naverid="";
	private final String naverpw="";
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("user/loginForm")
	public ModelAndView loginForm(){
		
		ModelAndView mav = new ModelAndView("user/login");
		mav.addObject(new User());
		
		return mav;
	}
	
	@RequestMapping("user/login")
	public ModelAndView login(@Valid User user, BindingResult bindingResult, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()){
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		
		
		User loginUser = shopService.getUserByIdPw(user);
		if(loginUser == null){
			bindingResult.reject("error.login.id");
			mav.getModel().putAll(bindingResult.getModel());
			return mav;
		}
		session.setAttribute("USER", loginUser);
		List<Sale> salelist = shopService.saleList(user.getUserId());
		for(Sale sale : salelist){
			List<SaleItem> saleItemList = shopService.saleItemList(sale.getSaleId());
			for(SaleItem sitem : saleItemList){
				Item item = itemService.getItem(sitem.getItemId());
				sitem.setItem(item);
			}
			sale.setSaleItemList(saleItemList);
		}
		mav.setViewName("user/mypage");
		mav.addObject("user", loginUser);
		mav.addObject("salelist", salelist);
		return mav;
	}
	
	@RequestMapping("user/logout")
	public ModelAndView logout(HttpSession session){		
		
		session.invalidate();
		
		return loginForm();
	}
	
	@RequestMapping("user/userEntryForm")
	public ModelAndView userEntryForm(){
		
		ModelAndView mav = new ModelAndView("user/userEntry");
		User user = new User();
		DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			user.setBirthDay(sf.parse("1980-01-01"));
		}catch(ParseException e){}
		
		mav.addObject(user);
		
		return mav;
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping("user/userEntry")
	public ModelAndView userEntry(@Valid User user, BindingResult bindingResult){
		
		ModelAndView mav = new ModelAndView();
		
		if(bindingResult.hasErrors()){
			bindingResult.reject("error.input.user");
			mav.getModel().putAll(bindingResult.getModel());
			
			return mav;
		}
		try{
			shopService.createUser(user);
		}catch(DuplicateKeyException e){
			bindingResult.reject("error.duplicate.user");
			return mav;
		}
		
		mav.setViewName("user/login");
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping("user/mypage")
	public ModelAndView mypage(String id){
		
		ModelAndView mav = new ModelAndView();
		User user = shopService.getUserById(id);
		
		List<Sale> salelist = shopService.saleList(id);
		
		for(Sale sale : salelist){
			List<SaleItem> saleItemList = shopService.saleItemList(sale.getSaleId());
			for(SaleItem sitem : saleItemList){
				Item item = itemService.getItemList(sitem.getItemId());
				sitem.setItem(item);
			}
			sale.setSaleItemList(saleItemList);
		}
		
		mav.addObject("salelist", salelist);
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping("user/admin")
	public ModelAndView admin(HttpSession session){
		
		User loginUser = (User)session.getAttribute("USER");
		
		if(loginUser == null){
			throw new LoginRequiredException();
		}
		if(!loginUser.getUserId().equals("admin")){
			throw new AdminRequiredException();
		}
		
		ModelAndView mav = new ModelAndView();
		List<User> userList = shopService.getUser();
		mav.addObject("userList", userList);
		
		return mav;
	}
	
	@RequestMapping("user/mailForm")
	public ModelAndView mailForm(String[] idchks){
		ModelAndView mav = new ModelAndView();
		if(idchks == null || idchks.length == 0){
			throw new MailEmptyException();
		}
		List<User> userList = shopService.getUser(idchks);
		
		mav.addObject("userList", userList);
		return mav;
	}
	

}
