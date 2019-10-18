package homework.demo.service.article;

import homework.demo.model.article.Article;
import homework.demo.model.filter.ArticleFilter;
import homework.demo.utility.Pagination;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    List<Article> findAllFilter(ArticleFilter articleFilter, Pagination pages);

    List<Article> findAllByCategoryId(int cate_id);

    Article findById(int id);

    Boolean addArticle(Article article);

    Boolean deleteArticleById(int id);

    Boolean updateArticle(Article article);
}
