package com.academy.hms.hms.receptionist;

import com.academy.hms.hms.extraEntity.Roles;
import com.academy.hms.hms.extraEntity.User;
import com.academy.hms.hms.extraEntity.UserType;
import com.academy.hms.hms.extraRepository.RoleRepository;
import com.academy.hms.hms.extraRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionistServiceImpl implements ReceptionistService{

    @Autowired
    private PasswordEncoder encode;

    @Autowired
    ReceptionistRepository receptionistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createReceptionist(Receptionist receptionist){

       String encodedPassword = encode.encode(receptionist.getUser().getPassword());

       Roles rRcep = new Roles();
       rRcep.setUserType(UserType.RECEPTIONIST);
       rRcep.setName("Receptionist");
       roleRepository.save(rRcep);

       User user = new User();
       user.setUserName(receptionist.getUser().getUserName());
       user.setRoles(rRcep);
       user.setPassword(encodedPassword);

       user = userRepository.save(user);
       receptionist.setUser(user);

       receptionistRepository.save(receptionist);
    }

    @Override
    public void deleteReceptionist(Long id) {
        receptionistRepository.deleteById(id);
    }

    @Override
    public void editReceptionist(Long id, String fullName, String email) {

        Receptionist receptionist = findOne(id);

        receptionist.setFullName(fullName);
        receptionist.setEmail(email);
        receptionistRepository.save(receptionist);
    }

    @Override
    public Receptionist findOne(Long id) {
        return receptionistRepository.getOne(id);
    }

    @Override
    public List<Receptionist> findReceptionist() {
        return receptionistRepository.findAll();
    }


}
