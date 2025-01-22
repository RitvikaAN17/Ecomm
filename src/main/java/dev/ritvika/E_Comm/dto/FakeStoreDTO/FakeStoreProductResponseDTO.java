package dev.ritvika.E_Comm.dto.FakeStoreDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private FakeStoreProductRatingDTO rating;
    //the attribute names are created as per API
    //means when API is returning the response it is using these names only
}
