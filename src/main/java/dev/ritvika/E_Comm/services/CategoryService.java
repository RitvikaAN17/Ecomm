package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.CategoryResponseDTO;
import dev.ritvika.E_Comm.dto.CreateCategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID id);
    List<CategoryResponseDTO> getAllCategories();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateProduct(UUID id,CreateCategoryRequestDTO categoryRequestDTO);
    boolean deleteCategory(UUID id);
}
