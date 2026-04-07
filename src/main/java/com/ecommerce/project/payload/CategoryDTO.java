package com.ecommerce.project.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @Schema(description = "Category ID", example = "101")
    private Long categoryId;
    @Schema(description = "Category name for the category you wish to create", example = "Calçados")
    private String categoryName;
}
