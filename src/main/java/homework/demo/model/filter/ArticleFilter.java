package homework.demo.model.filter;

public class ArticleFilter {

    private String article_title;
    private Integer category_id;
    private Integer article_id;

    public Integer getArticle_id() {
        return article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public ArticleFilter(String article_title, Integer category_id, Integer article_id) {
        this.article_title = article_title;
        this.category_id = category_id;
        this.article_id = article_id;
    }

    public ArticleFilter() {
    }

    @Override
    public String toString() {
        return "ArticleFilter{" +
                "article_title='" + article_title + '\'' +
                ", category_id=" + category_id +
                ", article_id=" + article_id +
                '}';
    }
}
