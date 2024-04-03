package com.Backend.HarvestMaster.Admin.Service;

import com.Backend.HarvestMaster.Admin.Model.Admin;
import com.Backend.HarvestMaster.Admin.Repository.AdminRepository;
import com.Backend.HarvestMaster.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    public AdminServiceImpl(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin getAdminByEmail(String email) {
        Optional<Admin> AdminOptional = adminRepository.findByUserEmail(email);
        return AdminOptional.orElse(null);
    }
}
