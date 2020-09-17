package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item,Integer> {

    List<Item> findByInvoice(Invoice invoice);
}
