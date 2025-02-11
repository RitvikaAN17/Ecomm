package dev.ritvika.E_Comm.service;

import dev.ritvika.E_Comm.controller.CategoryController;
import dev.ritvika.E_Comm.dto.CategoryResponseDTO;
import dev.ritvika.E_Comm.dto.CreateCategoryRequestDTO;
import dev.ritvika.E_Comm.entity.Category;
import dev.ritvika.E_Comm.services.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.UUID;

public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateCategorySuccess() {
        UUID randomId=UUID.randomUUID();
        CreateCategoryRequestDTO categoryRequestDTO=new CreateCategoryRequestDTO();
        categoryRequestDTO.setCategoryName("Category");
        CategoryResponseDTO categoryResponseDTO=new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName("Category");
        categoryResponseDTO.setCategoryId(randomId);

        Mockito.when(categoryService.updateProduct(randomId,categoryRequestDTO)).thenReturn(categoryResponseDTO);
        ResponseEntity<CategoryResponseDTO> categoryResponseDTOResponseEntity=categoryController.updateCategory(randomId,categoryRequestDTO);
        Assertions.assertEquals(categoryResponseDTOResponseEntity.getBody(),categoryResponseDTO);
    }
}
