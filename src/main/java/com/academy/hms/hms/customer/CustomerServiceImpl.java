package com.academy.hms.hms.customer;

import com.academy.hms.hms.extraEntity.Roles;
import com.academy.hms.hms.extraEntity.User;
import com.academy.hms.hms.extraEntity.UserType;
import com.academy.hms.hms.extraRepository.RoleRepository;
import com.academy.hms.hms.extraRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private PasswordEncoder encode;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createPersonnel(Customer customer) {

      String encodedPassword = encode.encode(customer.getUser().getPassword());

        User user = new User();
        user.setUserName(customer.getUser().getUserName());
        user.setPassword(encodedPassword);

        Roles r = new Roles();
        r.setName("Customer");
        r.setUserType(UserType.CUSTOMER);
        roleRepository.save(r);

        user.setRoles(r);
        user = userRepository.save(user);
        customer.setUser(user);

        customerRepository.save(customer);
    }
}
