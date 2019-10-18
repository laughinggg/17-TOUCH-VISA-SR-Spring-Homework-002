package homework.demo.service.article;

import homework.demo.model.article.Article;
import homework.demo.model.filter.ArticleFilter;
import homework.demo.repository.article.ArticleRepository;
import homework.demo.utility.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }


    @Override
    public List<Article> findAllFilter(ArticleFilter filter, Pagination pages) {
        pages.setTotalCount(articleRepository.countAllArticles(filter));
        return articleRepository.findAllFilter(filter, pages);
    }

    @Override
    public List<Article> findAllByCategoryId(int cate_id) {
        return articleRepository.findAllByCategoryId(cate_id);
    }


    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public Boolean addArticle(Article article) {
        article.setCreatedDate(new Date().toString());
        return articleRepository.addArticle(article);
    }

    @Override
    public Boolean deleteArticleById(int id) {
        return articleRepository.deleteArticleById(id);
    }

    @Override
    public Boolean updateArticle(Article article) {
        article.setCreatedDate(new Date().toString());
        return articleRepository.updateArticle(article);
    }

}
