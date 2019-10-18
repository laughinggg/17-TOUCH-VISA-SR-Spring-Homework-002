package homework.demo.repository.provider;

import homework.demo.model.filter.ArticleFilter;
import homework.demo.utility.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String findAllFilter(@Param("filter") ArticleFilter filter, @Param("pages") Pagination pages) {
        return new SQL() {{
            SELECT("a.id, a.title, a.description, a.thumbnail, a.created_date, a.author");
            SELECT("c.category_id, c.category_name");
            FROM("tb_article a");
            INNER_JOIN("tb_category c ON a.category_id = c.category_id");

            if (filter.getArticle_title() != null)
                WHERE("A.title ILIKE '%' || #{filter.article_title} || '%' ");

            if (filter.getCategory_id() != null)
                WHERE("c.category_id= #{filter.category_id}");

            if (filter.getArticle_id() != null)
                WHERE("a.id = #{filter.article_id}");

            ORDER_BY("a.id ASC LIMIT #{pages.limit} OFFSET #{pages.offset}  ");

        }}.toString();
    }


    public String countAllArticle(ArticleFilter filter) {
        return new SQL() {{
            SELECT("COUNT(id)");
            FROM("tb_article");

            if (filter.getArticle_title() != null)
                WHERE("title ILIKE '%' || #{article_title} || '%' ");

            if (filter.getCategory_id() != null)
                WHERE("category_id= #{category_id}");

        }}.toString();
    }


}

