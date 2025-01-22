package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.CreateProductRequestDTO;
import dev.ritvika.E_Comm.dto.ProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID productId) throws RuntimeException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct,UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO findProductByName(String name);
    List<ProductResponseDTO> findProductBetween(double minPrice,double maxPrice);


}
