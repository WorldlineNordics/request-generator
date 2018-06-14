# Device Payment REST API Request Generator

This tool can be used for integration with the Worldline Device Payment REST API, for generation of the object that is passed to the API.

## Usage

Build the project with

    ./gradlew clean fatjar

Use the generated jar with the --help argument for listing options:

    # java -jar build/libs/request-generator-0.0.1-fat.jar --help
    Option (* = required)  Description
    ---------------------  -----------
    --help                 Show help
    * --keystore           Keystore file
    * --merchantkey        Alias of merchant key in keystore
    * --mid <Long>         MerchantID that will be used for
                           tokenization calls
    * --password           Keystore password
    * --url <URL>          URL to Worldline Services
    --verbose              Verbose logging
    * --worldlinekey       Alias of Worldline key in keystore
  
    
 ## Example usage
 
      java -jar build/libs/request-generator-0.0.1-fat.jar --mid=1970271867 --keystore=merchant-accept.jks --password=merchant --merchantkey=merchant --worldlinekey=drwp_cert --url=https://device-api-test.payments.worldlinenordics.com/api/v1/payments
     
  This will generate, on stdout
  
     { "version": "A", "deviceEndpoint": "http://localhost:9354/api/v1/payments", "encryptedPayload": "BgAAA-wAAAPqLtpAtgIuk-fWPUoV-d73NaIKrzMZZTYrI0fWCDB-j_mZRJsXrYru5l_WfrfI1mtgdouXpdTX4uOFuTcDKJz4jNATlwD_BVkXX5jN2d-9HskuxuLfB7-r_ZhPwfB15jtru6TIv_I-fI4jITGV7yS1cWRD
     Y2soPdGsxNJrz0Zo1rXk_gYr4X4x_57C0xcq1jHEisba63HKYx7-qBPZj4Wswjpxind9-SZyEFZqOYC20Nd0P-3NvXtj-OKQtBiWTKfQ5Bky24m5KlliFXjeyAf8IgSvsKu_ReMX-kkW_wvbelTi18mqTpWu7bZqR96BRfVr6AD_unUksC6AYe8sx4zpEZjrpz5FWfMgUOfWqHeDO0KKbGFaeZd_ptT4vUNKadf263HS7c7HWAlhxxgxx1wLXz3SREh5tN
     4EtVsb6XOhc-18pDDRAsRYup1EVSNwRAczfzwjHYbRkvT5_9Z3J2-E7ulKibcy8wUPYF1IsDe8HEQISi7ApDvQwFpFuzFyFdMbKEpVu_12jACc7AeJ01HlmkeZpgliaRioiGnUFFoSYP8EKaEuO2OHnSYosKapJdMCUjgQLVN7cfctazowt01Rgpdn4KfwTTIjjDEHWRJDZSOeG92-G_jVfVXa6im-L_m99-DCZjz6UhxUWvsEL32HkOjQgDQI0RKxaFgB
     OLbzpE8U5XQWpKGc83QurBSwedOb9kx5H0sel_zkOTyYATvNFLfYGdNLiy_K13zxb_-rNeHOWwPe_Gxt9fGHx_VUkhn6nmXrSr5d-dtJxgMQx4Hj9okp7_e2BwROaSYX_0SEh3URfUBSwsPbsIFwDJAewL70DDmxRggoPpMFUyDhHLLcm01j5cUz5DJ1amyzsbnZSBE="}
