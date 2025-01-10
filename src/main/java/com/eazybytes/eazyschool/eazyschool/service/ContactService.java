package com.eazybytes.eazyschool.eazyschool.service;

import com.eazybytes.eazyschool.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {

    private int counter;
    public boolean saveMessageDetails(Contact contact){
        boolean isSaved=true;

        log.info("Message Saved: "+ contact.toString());
        return isSaved;
    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(int count){
        log.info("Count:"+count);
        log.info("counter: "+counter);
        counter=count+counter;
    }
}
