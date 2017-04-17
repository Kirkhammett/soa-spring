package org.estore.finki.repository;

import org.estore.finki.model.Orders;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by filip on 16.3.17.
 */
public interface OrdersRepository extends CrudRepository<Orders, Long> {

}
