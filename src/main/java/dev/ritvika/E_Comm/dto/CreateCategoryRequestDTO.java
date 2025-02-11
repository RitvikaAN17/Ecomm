package dev.ritvika.E_Comm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequestDTO {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
