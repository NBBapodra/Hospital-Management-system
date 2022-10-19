package com.example.TokenAuthentication.Utils;

import com.example.TokenAuthentication.models.Invoice;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class InvoiceUtil {

    public Invoice CalculateFinalAmountIncludingGST(Invoice inv) {
        var amount = inv.getMedicine().getUnitPrice();
        var gst = 0.1;
        var finalAmount = amount + (amount * gst);
        inv.setFinalAmount(finalAmount);
        return inv;
    }
}