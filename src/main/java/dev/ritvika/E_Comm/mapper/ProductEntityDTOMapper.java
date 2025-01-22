package dev.ritvika.E_Comm.mapper;

import dev.ritvika.E_Comm.dto.CreateProductRequestDTO;
import dev.ritvika.E_Comm.dto.ProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setCategory(product.getCategory().getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageURL(product.getImageURL());
        productResponseDTO.setRating(product.getRating());
        return productResponseDTO;
    }

    public static Product convertCreateProductRequestResponseDTOToProduct(CreateProductRequestDTO createProductRequestDTO) {
        Product product=new Product();
        product.setTitle(createProductRequestDTO.getTitle());
        product.setPrice(createProductRequestDTO.getPrice());
        product.setDescription(createProductRequestDTO.getDescription());
        product.setRating(0);
        product.setImageURL(createProductRequestDTO.getImageURL());
        return product;
    }

}
