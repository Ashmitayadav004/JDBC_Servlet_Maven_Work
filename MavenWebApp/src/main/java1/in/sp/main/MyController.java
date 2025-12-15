package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sp.beans.User;

@Controller
public class MyController {

	@GetMapping("/hellopage")
	public ModelAndView openHelloPage() {
		System.out.println("method executed");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		return mav;
	}

	@GetMapping("/aboutus")
	public String openAboutUsPage() {
		return "about-us";
	}

	@GetMapping("/myForm")
	public String openMyFormPage() {
		return "my-form";
	}

	
	//for single user data but what if we have many users ?
	
//	@PostMapping("/submitForm")
//	public String handleMyForm(
//		@RequestParam("name1") String myname,
//		@RequestParam("email1") String myemail,
//		@RequestParam("phoneno1") String myphone,
//		Model model
//	) {
//		System.out.println("Name :" + myname);
//		System.out.println("email :" + myemail);
//		System.out.println("phone :" + myphone);
//
//		model.addAttribute("model_name", myname);
//		model.addAttribute("model_email", myemail);
//		model.addAttribute("model_phone", myphone);
//
//		return "profile";
//	}
	
	
//	@PostMapping("/submitForm")
//	public String handleMyForm(
//		@RequestParam("name1") String myname,
//		@RequestParam("email1") String myemail,
//		@RequestParam("phoneno1") String myphone,
//		Model model
//	) {
//		System.out.println("Name :" + myname);
//		System.out.println("email :" + myemail);
//		System.out.println("phone :" + myphone);
//		
//		User user= new User();
//		
//		user.setName(myname);
//		user.setEmail(myemail);
//		user.setPhone(myphone);
//		
//model.addAttribute("model_user",user);
//		return "profile";
//	}
	
	
	@PostMapping("/submitForm")
	public String handleMyForm(@ModelAttribute User user)
		 {
		System.out.println("Name :" +user.getName());
		System.out.println("email :" + user.getEmail());
		System.out.println("phone :" +user.getPhone());
		
		
		return "profile";
	}
}

