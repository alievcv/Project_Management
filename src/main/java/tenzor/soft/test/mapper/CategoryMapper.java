package tenzor.soft.test.mapper;

import tenzor.soft.test.dto.CategoryDto;
import tenzor.soft.test.entity.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category) {
        return new CategoryDto(category.getName());
    }

}
