package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.Utils.InvoiceUtil;
import com.example.TokenAuthentication.exception.InvoiceNotFoundException;
import com.example.TokenAuthentication.models.Invoice;
import com.example.TokenAuthentication.repository.InvoiceRepository;
import com.example.TokenAuthentication.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceUtil invoiceUtil;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoiceUtil.CalculateFinalAmountIncludingGST(invoice);
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        List<Invoice> list=invoiceRepository.findAll();
        return list;
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> invoice=invoiceRepository.findById(id);
        if(invoice.isPresent())
        {
            return invoice.get();
        }
        else {
            try {
                throw new InvoiceNotFoundException("Invoice not found");
            } catch (InvoiceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Invoice updateInvoice(Long id,Invoice invoice) {

        Invoice invoice1 ;
        try {
            invoiceUtil.CalculateFinalAmountIncludingGST(invoice);
            invoice1 = invoiceRepository.findById(id)
                    .orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
        } catch (InvoiceNotFoundException e) {
            throw new RuntimeException(e);
        }

        invoice1.setId(invoice.getId());
        invoice1.setInvoiceDate(invoice.getInvoiceDate());
        invoice1.setInvoiceNo(invoice.getInvoiceNo());
        invoice1.setPatientName(invoice.getPatientName());
        invoice1.setAge(invoice.getAge());
        invoice1.setMedicine(invoice.getMedicine());
        invoice1.setFinalAmount(invoice.getFinalAmount());
        invoice1.setCreatedAt(invoice.getCreatedAt());
        invoice1.setUpdatedAt(invoice.getUpdatedAt());

        return  invoiceRepository.save(invoice1);
    }

    @Override
    public void deleteInvoice(Long id) {

        try {
            Invoice invoice = invoiceRepository.findById(id)
                    .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not found"));
        } catch (InvoiceNotFoundException e) {
            throw new RuntimeException(e);
        }
        invoiceRepository.deleteById(id);
    }
}
