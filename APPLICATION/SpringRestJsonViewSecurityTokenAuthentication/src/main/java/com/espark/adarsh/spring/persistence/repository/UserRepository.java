/*
 * Copyright (c) 2015 Espark And ©Adarsh Development Services @copyright All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Espark nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.espark.adarsh.spring.persistence.repository;



import com.espark.adarsh.spring.persistence.entities.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public interface UserRepository<E> {


    /**
     * saveUser() provide the specification for persisting
     * the User object in the database.
     *
     * @param user accept the instance of the User class
     *             containing data.
     * @return status of the persisting operation.
     */
    public Boolean saveUser(User user);

    /**
     * getUser() provide the specification for selection of the
     * User object from the database.
     *
     * @param user accept the instance of User containing sample
     *             for selection of User object from db.
     * @return instance of User having persisting state otherwise
     *         it return null.
     */
    public User getUser(User user);

    /**
     * getUserById() provide the specification for retrieval of the
     * User object from the database based on the Id value.
     *
     * @param user accept the instance of the User having id.
     * @return instance of User having persisting state otherwise
     *         it return null.
     */
    public User getUserById(User user);

    /**
     * getUserByName() provide the specification for retrieval of the
     * User object from the database based on the User name.
     *
     * @param user accept the instance of the User containing the
     *             User Name for selection from the database.
     * @return instance of User having persisting state otherwise
     *         it return null.
     */
    public User getUserByName(User user);


    /**
     * getAllUser() provide the specification for getting all the
     * User objects from the database.
     *
     * @return instance of the java.util.Collection containing the
     *         User object of the persisting state.
     */
    public Collection<User> getAllUser();


    public List<User> getByExample(final User example);


    public User getUser(String username,String password);
}
