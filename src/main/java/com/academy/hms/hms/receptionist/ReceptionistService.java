package com.academy.hms.hms.receptionist;

import java.util.List;

public interface ReceptionistService {
    void createReceptionist(Receptionist receptionist);
    void deleteReceptionist(Long id);
    void editReceptionist(Long id, String fullName, String email);
    Receptionist findOne(Long id);
    List<Receptionist> findReceptionist();

}
