package com.example.products.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRespository;

    //saved a new user - CREATE
    @PostMapping("/product")
    public ResponseEntity<Product> createUser(@RequestBody Product product){
        try {
            Product _product = productRespository.save(new Product(product.getP_name() ,product.getP_qty(),product.getP_price()));
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        }catch(Exception ex) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //get all users - READ
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        try {
            List<Product> products = new ArrayList<Product>();
            productRespository.findAll().forEach(products::add);
            if(products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }catch(Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //	Get User By Id - READ
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
        try {
            Optional<Product> productData = productRespository.findById(id);
            if(productData.isPresent()) {
                return new ResponseEntity<>(productData.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>( HttpStatus.NOT_FOUND);
            }
        }catch(Exception ex) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update User By Id - UPDATE
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id,@RequestBody Product product){
        Optional<Product> productData = productRespository.findById(id);
        if(productData.isPresent()) {
            Product _product = productData.get();
            _product.setP_name(product.getP_name());
            _product.setP_qty(product.getP_qty());
            _product.setP_price(product.getP_price());
            return new ResponseEntity<>(productRespository.save(_product), HttpStatus.OK);
        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }


    //Delete User By Id - DELETE
    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id){
        try {
            productRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

