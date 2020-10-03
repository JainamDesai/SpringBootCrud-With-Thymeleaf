package com.ProductCrud.ProductCRUD.helper;
import com.ProductCrud.ProductCRUD.model.*;

import org.springframework.data.jpa.repository.JpaRepository;


public interface HelperInter extends JpaRepository<Product, Integer> {

}
