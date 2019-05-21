package com.academy.hms.hms.admin;

import com.academy.hms.hms.extraEntity.Roles;
import com.academy.hms.hms.extraEntity.User;
import com.academy.hms.hms.extraEntity.UserType;
import com.academy.hms.hms.extraRepository.RoleRepository;
import com.academy.hms.hms.extraRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private PasswordEncoder encode;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createAdmin(Admin admin) {

        String encodedPassword = encode.encode(admin.getUser().getPassword());

        Roles rAdmin = new Roles();
        rAdmin.setName("admin");
        rAdmin.setUserType(UserType.ADMIN);
        roleRepository.save(rAdmin);

        User user = new User();
        user.setUserName(admin.getUser().getUserName());
        user.setPassword(encodedPassword);

        user.setRoles(rAdmin);
        user = userRepository.save(user);
        admin.setUser(user);

        adminRepository.save(admin);

    }
}
