package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Merchant;
import com.masai.repository.MerchantRepo;

@Service
public class MerchantUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MerchantRepo mrep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Merchant> opt= mrep.findByEmail(username);

		if(opt.isPresent()) {
			
			Merchant merchant= opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
			
			
			return new User(merchant.getEmail(), merchant.getPassword(), authorities);
			
			
			
		}else
			throw new BadCredentialsException("User Details not found with this username: "+username);
		
	}

}
