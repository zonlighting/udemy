package ssv.com.udemy.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryListDTO {
    List<CategoryDTO> categories;
}
