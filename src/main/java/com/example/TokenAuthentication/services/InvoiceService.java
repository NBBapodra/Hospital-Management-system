package com.example.TokenAuthentication.services;


import com.example.TokenAuthentication.models.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();

    Invoice getInvoiceById(Long id);

    Invoice updateInvoice(Long id, Invoice invoice);

    void deleteInvoice(Long id);
}