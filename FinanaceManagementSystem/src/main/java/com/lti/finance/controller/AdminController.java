package com.lti.finance.controller;
	import java.io.BufferedOutputStream;
	import java.io.File;
	import java.io.FileOutputStream;

	import javax.servlet.ServletContext;
	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.commons.CommonsMultipartFile;
	import org.springframework.web.servlet.ModelAndView;

	import com.lti.finance.dto.AdminDTO;
	import com.lti.finance.service.AdminService;

	//@SessionAttributes("message")
	@Controller
	public class AdminController {
		private static final String UPLOAD_DIRECTORY = "D:/myworkspace/EmiShoppingModule/src/main/webapp/images";
		@Autowired
		private AdminService adminService;
/*
	@RequestMapping(path = "/AdminDisplay")
		public String hello(AdminDTO adminDTO) {
		adminService.addProducts(adminDTO);
			return "redirect:/showproducts.jsp";
		}*/

		// =========================================================
		@RequestMapping(path = "/upload")//Images
		public ModelAndView uploadImage(@RequestParam CommonsMultipartFile file, HttpSession session) {
			System.out.println("==========" + System.getProperty("user.dir"));
			ServletContext context = session.getServletContext();
			String path = context.getRealPath("/src/main/webapp/images");
			String filename = file.getOriginalFilename();

			System.out.println(path + "/ " + filename);

			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + "/" + filename)));
			
				stream.write(bytes);
				stream.flush();
				stream.close();
			} catch (Exception e) {
			
			}
		
			return new ModelAndView("showproducts.jsp");
		
		}

		@RequestMapping(value = "savefile" , method=RequestMethod.POST)
		public ModelAndView saveimage(@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {
			System.out.println("==========" + System.getProperty("user.dir"));
			ServletContext context = session.getServletContext();
			String path = context.getRealPath("/src/main/webapp/Images");
			String filename = file.getOriginalFilename();

			System.out.println(path + "/ " + filename);

			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(path + "/" + filename)));
		
				stream.write(bytes);
				stream.flush();
				stream.close();
			} catch (Exception e) {
	
			}

			return new ModelAndView("uploadform", "filesuccess", "File successfully saved!");
		}

		

	}

