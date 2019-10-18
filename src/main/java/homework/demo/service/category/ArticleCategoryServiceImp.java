package homework.demo.service.category;

import homework.demo.model.article.Category;
import homework.demo.repository.category.ArticleCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCategoryServiceImp implements ArticleCategoryService {

    private ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    public void setArticleCategoryRepository(ArticleCategoryRepository articleCategoryRepository) {
        this.articleCategoryRepository = articleCategoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return articleCategoryRepository.getAllCategories();
    }

    @Override
    public Category getCategoryByID(int id) {
        return articleCategoryRepository.getCategoryByID(id);
    }

    @Override
    public Category getCategoryByName(String category_name) {
        return articleCategoryRepository.getCategoryByName(category_name);
    }

    @Override
    public boolean addCategory(Category category) {
        return articleCategoryRepository.addCategory(category);
    }

    @Override
    public boolean updateCategoryByID(Category category) {
        return articleCategoryRepository.updateCategoryByID(category);
    }

    @Override
    public boolean removeCategoryByID(int id) {
        return articleCategoryRepository.removeCategoryID(id);
    }
}
