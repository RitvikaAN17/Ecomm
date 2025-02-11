package dev.ritvika.E_Comm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO {
    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDTO> productResponseDTOList;

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductResponseDTO> getProductResponseDTOList() {
        return productResponseDTOList;
    }

    public void setProductResponseDTOList(List<ProductResponseDTO> productResponseDTOList) {
        this.productResponseDTOList = productResponseDTOList;
    }
}
