package homework.demo.repository.category;

import homework.demo.model.article.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleCategoryRepository {


    @Select("SELECT category_id, category_name FROM tb_category")
    @Results({
            @Result(property = "cate_id", column = "category_id"),
            @Result(property = "cate_name", column = "category_name")
    })
    List<Category> getAllCategories();

    @Select("SELECT category_id, category_name FROM tb_category where category_id=#{id}")
    @Results({
            @Result(property = "cate_id", column = "category_id"),
            @Result(property = "cate_name", column = "category_name")
    })
    Category getCategoryByID(int id);

    @Select("SELECT category_id, category_name FROM tb_category where category_name=#{category_name}")
    @Results({
            @Result(property = "cate_id", column = "category_id"),
            @Result(property = "cate_name", column = "category_name")
    })
    Category getCategoryByName(String category_name);

    @Insert("INSERT into tb_category(category_name) values(#{cate_name})")
    boolean addCategory(Category category);

    @Update("UPDATE tb_category set category_name=#{cate_name} where category_id=#{cate_id}")
    boolean updateCategoryByID(Category category);

    @Delete("DELETE FROM tb_category where category_id=#{cate_id}")
    boolean removeCategoryID(int id);


}
