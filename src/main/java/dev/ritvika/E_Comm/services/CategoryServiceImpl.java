package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.CategoryResponseDTO;
import dev.ritvika.E_Comm.dto.CreateCategoryRequestDTO;
import dev.ritvika.E_Comm.entity.Category;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.CategoryNotFoundException;
import dev.ritvika.E_Comm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryResponseDTO getCategory(UUID id) {
        return null;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {

    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO) {

    }

    @Override
    public CategoryResponseDTO updateProduct(UUID id, CreateCategoryRequestDTO categoryRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteCategory(UUID id) {
        return false;
    }

    public double getTotalPrice(UUID id) {
        Category category=categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("No category found with the given id")
        );
        //check if the category has any products or not
        if(category.getProducts().isEmpty()) {
            return 0;
        }
        else {
            double sum=0;
            for(Product p: category.getProducts()) {
                sum+=p.getPrice();
            }
            return sum;
        }
    }
}
