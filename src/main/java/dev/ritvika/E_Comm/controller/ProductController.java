package dev.ritvika.E_Comm.controller;

import dev.ritvika.E_Comm.dto.CreateProductRequestDTO;
import dev.ritvika.E_Comm.dto.ProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService; // field injection

    //get all the products
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products=productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //get products by specific id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    //creating new product
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody CreateProductRequestDTO productRequestDTO) {
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") UUID id ) {
        return ResponseEntity.ok(
                productService.deleteProduct(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID id, @RequestBody Product product) {
        Product updatedProduct=productService.updateProduct(product,id);
        return ResponseEntity.ok(updatedProduct);
    }

    //get the product by name
    @GetMapping("/name/{name}")
    public ResponseEntity getProductByName(@PathVariable("name") String name) {
        Product product= productService.findProductByName(name);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity findProductBetween(@PathVariable("min") double minPrice , @PathVariable("max") double maxPrice) {
        return ResponseEntity.ok(productService.findProductBetween(minPrice,maxPrice));
    }
    /*
    @GetMapping("/productexception")
    public ResponseEntity getProductException() {
        throw new RandomException("Exception from the product");

    }
     */
}
