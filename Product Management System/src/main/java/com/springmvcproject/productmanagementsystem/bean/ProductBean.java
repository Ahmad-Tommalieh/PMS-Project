package com.springmvcproject.productmanagementsystem.bean;

import com.springmvcproject.productmanagementsystem.modle.entity.Product;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean
@ViewScoped
@Component
public class ProductBean {
    private List<Product> products;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${backend.api.base-url}")
    private String baseUrl;

    @PostConstruct
    public void init() {
        products = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {}).getBody();
    }
    }

