package ssv.com.udemy.services;

import java.util.List;

import ssv.com.udemy.dto.CategoryDTO;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
