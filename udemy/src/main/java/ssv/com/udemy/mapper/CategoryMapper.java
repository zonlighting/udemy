package ssv.com.udemy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ssv.com.udemy.domain.Category;
import ssv.com.udemy.dto.CategoryDTO;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
