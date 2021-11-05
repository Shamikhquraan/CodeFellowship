//package com.example.codeFellowship.Security;
//
//import com.example.codeFellowship.Repositories.HospitalRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HospitalDetailsServicelmpl implements UserDetailsService {
//
//    @Autowired
//    HospitalRepo hospitalRepo;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return hospitalRepo.findByUserName(userName);
//    }
//}