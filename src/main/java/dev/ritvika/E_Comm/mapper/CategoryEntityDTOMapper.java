package dev.ritvika.E_Comm.mapper;

import dev.ritvika.E_Comm.dto.CategoryResponseDTO;
import dev.ritvika.E_Comm.dto.CreateCategoryRequestDTO;
import dev.ritvika.E_Comm.dto.ProductResponseDTO;
import dev.ritvika.E_Comm.entity.Category;
import dev.ritvika.E_Comm.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDTO> productResponseDTOList=new ArrayList<>();
        if(!(category.getProducts().isEmpty())) {
            for(Product p: category.getProducts()) {
                productResponseDTOList.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(p));
            }
        }
        categoryResponseDTO.setProductResponseDTOList(productResponseDTOList);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryRequestDTOToCategory(CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category=new Category();
        category.setName(createCategoryRequestDTO.getCategoryName());
        return category;
    }
}
