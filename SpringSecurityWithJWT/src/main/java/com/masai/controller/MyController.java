package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.MerchantException;
import com.masai.exception.ProductException;
import com.masai.model.Merchant;
import com.masai.model.Product;
import com.masai.model.SignInDTO;
import com.masai.repository.MerchantRepo;
import com.masai.service.MerchantService;

@RestController
public class MyController {

	@Autowired
	private MerchantService ms;
	
	@Autowired
	private MerchantRepo mrep;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/merchant")
	public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant me){
		me.setPassword(passwordEncoder.encode(me.getPassword()));
		Merchant saved= ms.registerMerchant(me);
		return new ResponseEntity<>(saved,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/merchant/{email}")
	public ResponseEntity<Merchant> getMerchentByEmail(@PathVariable("email") String email)throws MerchantException{
		Merchant me=ms.getMerchentByEmail(email);
		return new ResponseEntity<>(me,HttpStatus.OK);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<Merchant> signIn(Authentication auth)throws MerchantException{
		Merchant merchant= mrep.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 //to get the token in body, pass HttpServletResponse inside this method parameter 
		// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
		 
		 
		 return new ResponseEntity<>(merchant, HttpStatus.ACCEPTED);
	}
	@GetMapping("/merchant/all")
	public ResponseEntity<List<Merchant>> getAllMerchant()throws MerchantException{
		 List<Merchant> mes=ms.getAllMerchant();
		 return new ResponseEntity<>(mes,HttpStatus.OK);
	}
	@PostMapping("/product")
	public ResponseEntity<Product> addProdcut(@RequestBody Product product, @RequestParam Integer merchantId)throws MerchantException{
		Product p=ms.addProdcut(product, merchantId);
		return new ResponseEntity<Product>(p,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/product/all/{merchantId}")
	public ResponseEntity<List<Product>> getAllProdcutOfMerchant(@PathVariable("merchantId") Integer merchantId)throws ProductException{
		List<Product> ps=ms.getAllProdcutOfMerchant(merchantId);
		return new ResponseEntity<List<Product>>(ps,HttpStatus.OK);
	}
}
