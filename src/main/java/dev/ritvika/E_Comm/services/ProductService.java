package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(UUID productId) throws RuntimeException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct,UUID productId);
    boolean deleteProduct(UUID productId);
    Product findProductByName(String name);
    List<Product> findProductBetween(double minPrice,double maxPrice);


}
