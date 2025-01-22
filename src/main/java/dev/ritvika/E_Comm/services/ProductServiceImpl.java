package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.dto.CreateProductRequestDTO;
import dev.ritvika.E_Comm.dto.ProductResponseDTO;
import dev.ritvika.E_Comm.entity.Category;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.CategoryNotFoundException;
import dev.ritvika.E_Comm.exception.ProductNotFoundException;
import dev.ritvika.E_Comm.mapper.ProductEntityDTOMapper;
import dev.ritvika.E_Comm.repository.CategoryRepository;
import dev.ritvika.E_Comm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts=productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
        for(Product product:savedProducts) {
            productResponseDTOS.add(ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product));
        }
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProduct(UUID productId) throws RuntimeException {

        /*
        Product savedProduct=productRepository.findById(productId).get();
        if(savedProduct==null) {
            throw new ProductNotFoundException("No products found for the given id");
        }
         */

        //or
        Product product=productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("No products found with the given id")
        );
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product=ProductEntityDTOMapper.convertCreateProductRequestResponseDTOToProduct(productRequestDTO);
        Category savedCategory=categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for the given id")
        );
        product.setCategory(savedCategory);
        product=productRepository.save(product);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO updatedProduct, UUID productId) {
        Product savedProduct=productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("No product found for the given id")
        );
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageURL(updatedProduct.getImageURL());
        savedProduct=productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO findProductByName(String name) {
        Product findProduct=productRepository.findProductByTitle(name);
        return ProductEntityDTOMapper.convertProductEntityToProductResponseDTO(findProduct);
    }

    public List<ProductResponseDTO> findProductBetween(double minPrice,double maxPrice) {
        List<Product> products=productRepository.findByPriceBetween(minPrice, maxPrice);
        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();

    }
}
