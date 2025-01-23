package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.CategoryResponseDTO;
import dev.ritvika.E_Comm.dto.CreateCategoryRequestDTO;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService{

    @Override
    public CategoryResponseDTO getCategory(UUID id) {
        return null;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return List.of();
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public CategoryResponseDTO updateProduct(UUID id, CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID id) {
        return false;
    }
}
