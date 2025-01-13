package com.eazybytes.eazyschool.eazyschool.service;

import com.eazybytes.eazyschool.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.eazyschool.model.Person;
import com.eazybytes.eazyschool.eazyschool.model.Roles;
import com.eazybytes.eazyschool.eazyschool.repository.PersonRepository;
import com.eazybytes.eazyschool.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
