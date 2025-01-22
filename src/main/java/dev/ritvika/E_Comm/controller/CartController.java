package dev.ritvika.E_Comm.controller;

import dev.ritvika.E_Comm.client.FakeStoreClient;
import dev.ritvika.E_Comm.dto.FakeStoreDTO.FakeStoreCartResponseDTO;
import dev.ritvika.E_Comm.exception.CartNotFoundException;
import dev.ritvika.E_Comm.exception.RandomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController 
public class CartController {

    private FakeStoreClient fakeStoreClient;
    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId) {
        List<FakeStoreCartResponseDTO> cartResponse=fakeStoreClient.getCartByUserId(userId);
        if(cartResponse==null) {
            throw new CartNotFoundException(" Cart not found for the given userId");
        }
        return ResponseEntity.ok(cartResponse);
    }

    @GetMapping("/carexception")
    public ResponseEntity getCartException() {
        throw new RandomException("Exception from the cart");
    }
}
