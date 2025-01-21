package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO getProduct(int productId) throws RuntimeException;
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct,int productId);
    boolean deleteProduct(int productId);


}
