package com.ftn.eObrazovanjee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ftn.eObrazovanjee.model.Korisnik;
import com.ftn.eObrazovanjee.repository.KorisnikRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	KorisnikRepository korisnikRepository;
	
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Korisnik korisnik = korisnikRepository.findBykorisnickoIme(username).orElse(null);

	    if (korisnik == null) {
	      throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	    } else {
	    	return korisnik;
	    }
	  }
}
