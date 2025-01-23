package dev.ritvika.E_Comm.mapper;

import dev.ritvika.E_Comm.dto.CategoryResponseDTO;
import dev.ritvika.E_Comm.entity.Category;

public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category) {
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryId(category.getId());
        categoryResponseDTO.setCategoryName(category.getName());
    }
}
