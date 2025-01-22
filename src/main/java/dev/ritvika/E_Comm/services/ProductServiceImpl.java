package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.ProductNotFoundException;
import dev.ritvika.E_Comm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) throws RuntimeException {

        /*
        Product savedProduct=productRepository.findById(productId).get();
        if(savedProduct==null) {
            throw new ProductNotFoundException("No products found for the given id");
        }
         */

        //or
        return productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("No products found with the given id")
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product updateProduct(Product updatedProduct, UUID productId) {
        Product savedProduct=productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("No product found for the given id")
        );
        savedProduct.setCategory(updatedProduct.getCategory());
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct=productRepository.save(savedProduct);
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }
}
