package dev.ritvika.E_Comm.service;

import dev.ritvika.E_Comm.entity.Category;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.CategoryNotFoundException;
import dev.ritvika.E_Comm.repository.CategoryRepository;
import dev.ritvika.E_Comm.services.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {

    //mock the dependencies first
    @Mock
    private CategoryRepository categoryRepository;

    //where we have to usr this mock
    @InjectMocks
    private CategoryServiceImpl categoryService;

    //initializing all the mock objects and injecting into the method or class that we are supposed to test
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalPriceForMultipleProductsUnderCategory() {
        //arrange
        UUID categoryId=UUID.randomUUID();
        Optional<Category> categoryOptionalMockData=getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedTotalCost=300.00;
        //act
        double actualTotalCost= categoryService.getTotalPrice(categoryId);
        //assert
        Assertions.assertEquals(expectedTotalCost,actualTotalCost);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    private Optional<Category> getCategoryMockData() {
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");

        Product product1=new Product();
        product1.setCategory(category);
        product1.setPrice(100.00);

        Product product2=new Product();
        product2.setCategory(category);
        product2.setPrice(200.00);

        List<Product> products=new ArrayList<>();
        products.add(product1);
        products.add(product2);
        category.setProducts(products);
        return Optional.of(category);
    }

    @Test
    public void testZeroProductUnderCategory() {
        UUID categoryId=UUID.randomUUID();
        Optional<Category> getMockData=getCategoryMockDataWithZeroProduct();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(getMockData);
        double actualPrice= categoryService.getTotalPrice(categoryId);
        double expectedPrice=0.00;
        Assertions.assertEquals(expectedPrice,actualPrice);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testCategoryNotFoundException() {
        UUID categoryId=UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());
        Assertions.assertThrows(CategoryNotFoundException.class,
                ()-> categoryService.getTotalPrice(categoryId));
    }

    private Optional<Category> getCategoryMockDataWithZeroProduct() {
        Category category=new Category();
        category.setId(UUID.randomUUID());
        category.setName("CategoryName");
        List<Product> products=new ArrayList<>();
        category.setProducts(products);
    }
}
