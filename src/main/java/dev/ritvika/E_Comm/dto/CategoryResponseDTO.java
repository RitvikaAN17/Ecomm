package dev.ritvika.E_Comm.dto;

import java.util.List;
import java.util.UUID;

public class CategoryResponseDTO {
    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDTO> productResponseDTOList;
}
