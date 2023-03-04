package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.MerchantException;
import com.masai.exception.ProductException;
import com.masai.model.Merchant;
import com.masai.model.Product;
import com.masai.model.SignInDTO;
import com.masai.repository.MerchantRepo;
import com.masai.repository.ProductRepo;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantRepo mrep;
	@Autowired
	private ProductRepo prep;
	
	@Override
	public Merchant registerMerchant(Merchant merchant) {
		return mrep.save(merchant);
	}

	@Override
	public Merchant getMerchentByEmail(String email) throws MerchantException {
		Optional<Merchant> opt= mrep.findByEmail(email);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new MerchantException("There are no merchant by this email");
	}

	@Override
	public Merchant signIn(SignInDTO emailpass) throws MerchantException {
		Optional<Merchant> opt= mrep.findByEmail(emailpass.getEmail());
		if(opt.isPresent()) {
			Merchant saved=opt.get();
			if(saved.getPassword()==emailpass.getPassword()) {
				return saved;
			}
			else {
				throw new MerchantException("Merchant password is wrong signin failed");
			}
		}
		throw new MerchantException("There are no merchant by this email signin failed");
	}

	@Override
	public List<Merchant> getAllMerchant() throws MerchantException {
		return mrep.findAll();
	}

	@Override
	public Product addProdcut(Product product, Integer merchantId) throws MerchantException {
		Optional<Merchant> opt=mrep.findById(merchantId);
		if(opt.isPresent()) {
			product.setMerchant(opt.get());
			return prep.save(product);
		}
		throw new MerchantException("There are no merchant by this merchantid");
	}

	@Override
	public List<Product> getAllProdcutOfMerchant(Integer merchantId) throws ProductException {
		Optional<Merchant> opt= mrep.findById(merchantId);
		if(opt.isPresent()) {
			Merchant me=opt.get();
			return me.getProducts();
		}
		throw new ProductException("There are no merchant by this merchantid");
	}

}
