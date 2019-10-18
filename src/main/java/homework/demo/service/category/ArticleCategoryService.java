package homework.demo.service.category;

import homework.demo.model.article.Category;

import java.util.List;

public interface ArticleCategoryService {

    List<Category> getAllCategories();

    Category getCategoryByID(int id);

    Category getCategoryByName(String category_name);

    boolean addCategory(Category category);

    boolean updateCategoryByID(Category category);

    boolean removeCategoryByID(int id);

}
