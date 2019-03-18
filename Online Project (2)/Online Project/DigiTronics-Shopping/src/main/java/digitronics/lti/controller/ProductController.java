package digitronics.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import digitronics.lti.dto.ProductDTO;
import digitronics.lti.entity.Product;
import digitronics.lti.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public String register(ProductDTO productDTO, 	Map<String, Object> model) {
		
		//TODO : rename the file since two users can upload file of same name
		File targetDir = new File("d:/uploads/" + productDTO.getPro_images().getOriginalFilename()); 
		try {
			productDTO.getPro_images().transferTo(targetDir);
		}
		catch (IOException e) {
			e.printStackTrace(); //if copy fails, throw an exception instead
		}
		
		int id = productService.addProduct(productDTO);
		productDTO.setGeneratedId(id);
		
		model.put("productDetails", productDTO);
		return "/success.jsp";
	}
	
	@RequestMapping(path="/fetch", method=RequestMethod.GET)
	public String list(@RequestParam int id, Map<String, Object> model, HttpServletRequest request) {
		Product product = productService.getAddedProduct(id);
		
		String appRoot = request.getServletContext().getRealPath("/");
		File srcFile = new File("d:/uploads/" + product.getProfilePicFileName());
		File destFile = new File(appRoot + "/uploads/"+product.getProfilePicFileName());
		System.out.println(appRoot);
		System.out.println(srcFile.getName());
		System.out.println(destFile.getName());
		try {
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (IOException e) {
			e.printStackTrace(); //if copy fails, throw an exception instead
		}
		
		model.put("user", product);
		return "/displayProducts.jsp";
	}
	
	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String list(Map<String, Object> model, HttpServletRequest request) {
		List<Product> list = productService.getAddedProduct();
		for(Product product : list) {
			String appRoot = request.getServletContext().getRealPath("/");
			File srcFile = new File("d:/uploads/" + product.getProfilePicFileName());
			File destFile = new File(appRoot + "/uploads/"+product.getProfilePicFileName());
			try {
				FileUtils.copyFile(srcFile, destFile);
			}
			catch (IOException e) {
				e.printStackTrace(); //if copy fails, throw an exception instead
			}
			
		}
		model.put("listOfProducts", list);
		return "/displayProducts.jsp";
	}
	
	@RequestMapping(path="/listByCategory", method=RequestMethod.GET)
	public String listByCategory(Map<String, Object> model,@RequestParam("categoryname") String categoryName) {
		//ProductDTO productDTO = (ProductDTO) model.get("productDTO");
		//List<Product> list = productService.getByMobile(productDTO);
		List<Product> product = productService.getProductByName(categoryName);
		model.put("listOfProducts" , product);
		return "/displayProducts.jsp";
	}
	
	@RequestMapping(path="/listByPrice", method=RequestMethod.GET)
	public String listByPrice(Map<String, Object> model,@RequestParam("start") int toprice,@RequestParam("end") int fromprice) {
		//ProductDTO productDTO = (ProductDTO) model.get("productDTO");
		//List<Product> list = productService.getByMobile(productDTO);
		List<Product> product = productService.getProductByPrice(toprice,fromprice);
		model.put("listOfProducts" , product);
		return "/displayProducts.jsp";
	}
	
}