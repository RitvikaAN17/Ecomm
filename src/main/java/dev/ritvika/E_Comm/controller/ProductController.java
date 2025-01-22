package dev.ritvika.E_Comm.controller;

import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.RandomException;
import dev.ritvika.E_Comm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService; // field injection

    //get all the products
    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<Product> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //get products by specific id
    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id) {
        Product product= productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    //creating new product
    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product newProduct=productService.createProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteById(@PathVariable("id") UUID id ) {
        return ResponseEntity.ok(
                productService.deleteProduct(id)
        );
    }

    @PutMapping("/product/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product) {
        Product updatedProduct=productService.updateProduct(product,id);
        return ResponseEntity.ok(updatedProduct);
    }
    /*
    @GetMapping("/productexception")
    public ResponseEntity getProductException() {
        throw new RandomException("Exception from the product");

    }
     */
}
