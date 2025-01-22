package dev.ritvika.E_Comm.dto.FakeStoreDTO;

import dev.ritvika.E_Comm.dto.ProductQuantityDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FakeStoreCartResponseDTO {
    private int id;
    private int userId;
    private String date;
    private List<ProductQuantityDTO> products;
    private int __v;

}
