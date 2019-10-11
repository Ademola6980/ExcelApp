/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repositories;

import org.springframework.data.repository.CrudRepository;
import com.entities.Customer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Femi
 */
@Repository("CustomerRepositories")
public interface  CustomerRepositories extends CrudRepository<Customer, String>
{
    
}
