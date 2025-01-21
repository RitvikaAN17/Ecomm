package dev.ritvika.E_Comm.controller;

import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.RandomException;
import dev.ritvika.E_Comm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService; // field injection

    //get all the products
    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //get products by specific id
    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id")int id) {
        FakeStoreProductResponseDTO product= productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/productexception")
    public ResponseEntity getProductException() {
        throw new RandomException("Exception from the product");

    }
}
