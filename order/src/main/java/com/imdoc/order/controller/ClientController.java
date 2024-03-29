package com.imdoc.order.controller;

import com.imdoc.order.client.ProductClient;
import com.imdoc.order.dataobject.ProductInfo;
import com.imdoc.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Created by Jarries
 * @description:
 * @date: 2018/6/14
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg () {


        //1.直接restTemplate
//        RestTemplate restTemplate = new RestTemplate ();
//        String response = restTemplate.getForObject ("http://localhost:8080/msg",String.class);

        //2.loadBalancerClient+RestTemplate(利用LoadBalancerClient通过应用名获取URL,然后使用RestTemplate)
//        RestTemplate restTemplate = new RestTemplate ();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format ("http://%s:%s",serviceInstance.getHost (),serviceInstance.getPort ());
//        String response = restTemplate.getForObject (url,String.class);

        //3.利用@LoadBalanced可在restTemplate里直接使用应用名
//        String response = restTemplate.getForObject ("http://PRODUCT/msg", String.class);
        String response = productClient.productMsg ();
        log.info ("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList () {
        List <ProductInfo> productInfoList = productClient.listForOrder (Arrays.asList ("164103465734242707"));
        log.info ("response={}", productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock (Arrays.asList (new CartDTO ("164103465734242707",3)));
        return "ok";
    }
}
