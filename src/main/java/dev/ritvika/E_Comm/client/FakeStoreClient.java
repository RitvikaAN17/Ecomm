package dev.ritvika.E_Comm.client;

import dev.ritvika.E_Comm.dto.FakeStoreCartResponseDTO;
import dev.ritvika.E_Comm.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakestoreAPIGetCartByUser;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String fakeStoreGetAllProductURL=fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=
                restTemplate.getForEntity(fakeStoreGetAllProductURL,FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id) throws RuntimeException {
        String fakeStoreGetProductByIdURL=fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/"+id);
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> product=restTemplate.getForEntity(fakeStoreGetProductByIdURL, FakeStoreProductResponseDTO.class);
        return product.getBody();
    }

    public List<FakeStoreCartResponseDTO> getCartByUserId(int userId) {
        String fakeStoreGetCartForUser=fakeStoreAPIBaseUrl.concat(fakestoreAPIGetCartByUser).concat(String.valueOf(userId));
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartItems=restTemplate.getForEntity(fakeStoreGetCartForUser, FakeStoreCartResponseDTO[].class);
        return List.of(cartItems.getBody());
    }
}
