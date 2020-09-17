package com.kodilla.hibernate;
import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.invoice.dao.ItemDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Test
    public void testInvoiceDaoSave(){
        //Given
        Invoice invoice = new Invoice("FV  81/08/2020");

        Item item1 = new Item(new BigDecimal(10), 6, new Product("Apple"));
        Item item2 = new Item(new BigDecimal(7), 4, new Product("Orange"));

        invoice.getListItem().add(item1);
        invoice.getListItem().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoiceDao.save(invoice);
        //When
        int invoiceId = invoice.getId();
        boolean result1 = invoiceDao.existsById(invoiceId);
        //Then
        Assert.assertTrue(result1);
        Assert.assertEquals(2,itemDao.findByInvoice(invoice).size());
        //Clean
        invoiceDao.deleteAll();
    }
}
