package org.gadek.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.util.List;

import org.gadek.dao.AppUserDAO;
import org.gadek.model.AppUser;
import  org.gadek.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
	
	@Autowired
    private AppUserDAO appUserDAO;
	@Autowired
	private BCryptPasswordEncoder encoder;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "All hope abandon ye who enter here");
        return "welcomePage";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        List<AppUser> list = appUserDAO.getUsers();
        model.addAttribute("accountInfos", list);
        return "/admin/user";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "welcomePage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        List<AppUser> list = appUserDAO.getUsers();
        model.addAttribute("accountInfos", list);
        return "/user/user";
    } 
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
        return "/errors/403Page";
    }
    
    @RequestMapping(value= "/signup", method = RequestMethod.GET)
    public String signUp() {
    	return "signup";
    }
    
    //create user
    @RequestMapping(value = "/signup/create")
	public String createMovie(Model model) {
		model.addAttribute("user", new AppUser());
	    return "signup";
	}
    
    //save user
    @RequestMapping(value= "/signup/save", method = RequestMethod.GET)
    public String addUser(Model model, String name, String password) {
    		appUserDAO.addUser("Paweł", encoder.encode("123"));
    		return "loginPage";
    }
 
}