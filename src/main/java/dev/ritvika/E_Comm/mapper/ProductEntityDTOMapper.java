package dev.ritvika.E_Comm.mapper;

import dev.ritvika.E_Comm.dto.ProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setProductId(product.getId());
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setRating(product.getRating());
        return productResponseDTO;
    }
}
