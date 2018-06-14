package com.worldline.payments;

import com.digitalriver.worldpayments.api.security6.JKSKeyHandlerV6;
import com.worldline.payments.api.AuthorizationType;
import com.worldline.payments.api.PaymentHandler;
import com.worldline.payments.api.PaymentRequest;
import com.worldline.payments.api.PaymentRequestBuilder;

import java.math.BigDecimal;

public class DevicePaymentApiRequestGenerator {

    DevicePaymentApiRequestGenerator(boolean verbose, PaymentHandler handler, Long mid) {

        PaymentRequest pr = new PaymentRequestBuilder()
                                .setMid(mid)
                                .setAmount(BigDecimal.valueOf(0.0))
                                .setCurrency("EUR")
                                .setTransactionChannel("Web Online")
                                .setAutoCapture(false)
                                .setConsumerCountry("US")
                                .setConsumerLanguage("en")
                                .setAuthorizationType(AuthorizationType.UNDEFINED)
                                .setStoreFlag(PaymentRequest.StoreFlag.STORE_ONLY)
                                .createPaymentRequest();

        final String deviceAPIRequest = handler.createDeviceAPIRequest(pr);

        System.out.println(deviceAPIRequest);
    }
}