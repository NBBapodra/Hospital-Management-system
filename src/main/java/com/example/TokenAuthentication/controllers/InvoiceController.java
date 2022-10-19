package com.example.TokenAuthentication.controllers;


import com.example.TokenAuthentication.dto.InvoiceDto;
import com.example.TokenAuthentication.models.Invoice;
import com.example.TokenAuthentication.services.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/invoices")
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDto) {

        // convert DTO to entity
        Invoice invoiceRequest = modelMapper.map(invoiceDto, Invoice.class);
        Invoice invoice= invoiceService.createInvoice(invoiceRequest);
        // convert entity to DTO
        InvoiceDto  invoiceResponse = modelMapper.map(invoice, InvoiceDto.class);
        return new ResponseEntity<InvoiceDto>(invoiceResponse, HttpStatus.CREATED);
    }

    @GetMapping("/invoices")
    public List<InvoiceDto> getAllInvoice() {
        return invoiceService.getAllInvoices().stream().map(post -> modelMapper.map(post,InvoiceDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable(value = "id") Long id)
    {
        Invoice invoice=invoiceService.getInvoiceById(id);
        InvoiceDto invoiceResponse = modelMapper.map(invoice, InvoiceDto.class);
        if(invoice==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(invoiceResponse);
    }

    @PutMapping("/invoices/{id}")
    public ResponseEntity<InvoiceDto> updateInvoice(@PathVariable(value = "id") Long id,
                                                    @Valid @RequestBody InvoiceDto invoiceDto){
        // convert DTO to entity
        Invoice invoiceRequest = modelMapper.map(invoiceDto, Invoice.class);

        Invoice invoice= invoiceService.updateInvoice(id,invoiceRequest);
        // convert entity to DTO
        InvoiceDto invoiceResponse = modelMapper.map(invoice, InvoiceDto.class);
        return ResponseEntity.ok().body(invoiceResponse);
    }

    @DeleteMapping("/invoices/{id}")
    public ResponseEntity deletePatient(@PathVariable(value = "id") Long id)
    {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok().body("Invoice deleted successFully");
    }

}