package homework.demo.repository.article;

import homework.demo.model.article.Article;
import homework.demo.model.filter.ArticleFilter;
import homework.demo.repository.provider.ArticleProvider;
import homework.demo.utility.Pagination;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository {

    //@Select("select * from tb_article")
    @Select("SELECT a.id, a.title, a.description, a.thumbnail, a.created_date, a.author, c.category_id, c.category_name FROM tb_article AS a  " +
            "INNER JOIN tb_category AS c ON a.category_id = c.category_id ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "thumbnail", column = "thumbnail"),
            @Result(property = "author", column = "author"),
            @Result(property = "category.cate_id", column = "category_id"),
            @Result(property = "category.cate_name", column = "category_name")
    })
    List<Article> findAll();

    @Select("SELECT * from tb_article where category_id=#{cate_id}")
    List<Article> findAllByCategoryId(int cate_id);

    @Delete("delete from tb_article where id=#{id}")
    Boolean deleteArticleById(int id);

    @Select("update tb_article set title=#{title}," +
            "description = #{description}, author=#{author}," +
            "thumbnail=#{thumbnail} , created_date = #{createdDate} where id=#{id}")
    Boolean updateArticle(Article article);

    @Select("SELECT a.id, a.title, a.description, a.thumbnail, a.created_date, a.author, c.category_id, c.category_name FROM tb_article AS a  " +
            "INNER JOIN tb_category AS c ON a.category_id = c.category_id where a.id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "thumbnail", column = "thumbnail"),
            @Result(property = "author", column = "author"),
            @Result(property = "category.cate_id", column = "category_id"),
            @Result(property = "category.cate_name", column = "category_name")
    })
    Article findById(int id);

    @Insert("insert into tb_article (title,description,author,thumbnail,created_date,category_id) " +
            "values (#{title} , #{description}  , #{author} , #{thumbnail} , #{createdDate},#{category.cate_id}) ")
    Boolean addArticle(Article article);

    @SelectProvider(method = "findAllFilter", type = ArticleProvider.class)
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "thumbnail", column = "thumbnail"),
            @Result(property = "author", column = "author"),
            @Result(property = "category.cate_id", column = "category_id"),
            @Result(property = "category.cate_name", column = "category_name")
    })
    List<Article> findAllFilter(@Param("filter") ArticleFilter filter, @Param("pages") Pagination pages);

    @SelectProvider(method = "countAllArticle", type = ArticleProvider.class)
    Integer countAllArticles(ArticleFilter filter);

}
