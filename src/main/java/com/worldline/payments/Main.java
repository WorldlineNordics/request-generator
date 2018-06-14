package com.worldline.payments;

import com.digitalriver.worldpayments.api.security6.JKSKeyHandlerV6;
import com.worldline.payments.api.PaymentHandler;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import java.net.URL;

public class Main {

    private static OptionSet options;

    public static void main(String[] args) {

        OptionParser parser = new OptionParser();
        parser.accepts("help", "Show help").forHelp();
        OptionSpec<Long> mid = parser.accepts("mid", "MerchantID that will be used for tokenization calls")
                .withRequiredArg().ofType(Long.class).required();
        OptionSpec<String> keystore = parser.accepts("keystore", "Keystore file")
                .withRequiredArg().ofType(String.class).required();
        OptionSpec<String> keystorePwd = parser.accepts("password", "Keystore password")
                .withRequiredArg().ofType(String.class).required();
        OptionSpec<String> merchantKeyAlias = parser.accepts("merchantkey", "Alias of merchant key in keystore")
                .withRequiredArg().ofType(String.class).required();
        OptionSpec<String> worldlineKeyAlias = parser.accepts("worldlinekey", "Alias of Worldline key in keystore")
                .withRequiredArg().ofType(String.class).required();
        OptionSpec<URL> url = parser.accepts("url", "URL to Worldline Services")
                .withRequiredArg().ofType(URL.class).required();

        parser.accepts("verbose", "Verbose logging");

        try {
            options = parser.parse(args);
            if (options.has("help")) {
                parser.printHelpOn(System.out);
                System.exit(0);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        if (options.has("verbose")) {

            System.out.println("url = " + options.valueOf(url));
            System.out.println("worldlineKeyAlias = " + options.valueOf(worldlineKeyAlias));
            System.out.println("merchantKeyAlias = " + options.valueOf(merchantKeyAlias));
            System.out.println("keystorePwd = " + options.valueOf(keystorePwd));
            System.out.println("keystore = " + options.valueOf(keystore));
            System.out.println("mid = " + options.valueOf(mid));
        }

        PaymentHandler handler = new PaymentHandler(
                new JKSKeyHandlerV6(options.valueOf(keystore),
                        options.valueOf(keystorePwd),
                        options.valueOf(merchantKeyAlias),
                        options.valueOf(worldlineKeyAlias)),
                options.valueOf(url).toString());

        DevicePaymentApiRequestGenerator gen = new DevicePaymentApiRequestGenerator(options.has("verbose"), handler, options.valueOf(mid));


    }
}
