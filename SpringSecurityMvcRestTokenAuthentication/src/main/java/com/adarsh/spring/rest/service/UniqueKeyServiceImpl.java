package com.adarsh.spring.rest.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
@Service
public class UniqueKeyServiceImpl implements UniqueKeyService {

    public String generateUniqueId() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
