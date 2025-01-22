package dev.ritvika.E_Comm.services;

import dev.ritvika.E_Comm.client.FakeStoreClient;
import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import dev.ritvika.E_Comm.entity.Product;
import dev.ritvika.E_Comm.exception.NoProductsException;
import dev.ritvika.E_Comm.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts=fakeStoreClient.getAllProducts();
        if(fakeStoreProducts==null) {
            throw new NoProductsException("No products are present");
        }
        return fakeStoreProducts;
    }

    public FakeStoreProductResponseDTO getProduct(int productId) {
        FakeStoreProductResponseDTO product= fakeStoreClient.getProductById(productId);
        if(product==null) {
            throw new ProductNotFoundException("Product not found with id" + productId);
        }
        return product;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    public boolean deleteProduct(int productId) {
        return false;
    }
}
