package homework.demo.configuration.api;

import homework.demo.model.article.Article;
import homework.demo.service.article.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class RESTController {

    private ArticleService articleService;

    public RESTController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("article")
    public ResponseEntity<Object> article() {
//        List<Article> articles = articleService.findAll();
        Map<String, Object> map = new HashMap<>();
        List<Article> articles = articleService.findAll();

        if (articles.isEmpty()){
            map.put("STATUS", false);
            map.put("MESSAGE","NO ARTICLE");
            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        } else{
            map.put("STATUS", true);
            map.put("MESSAGE","FIND ALL ARTICLE SUCCESSFULLY");
            map.put("DATA", articles);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
    }

    @PostMapping("articles")
    public Boolean insert(@RequestBody Article article){
        return articleService.addArticle(article);
    }

    @PostMapping("article")
    public Boolean update(@RequestBody Article article){
        return articleService.updateArticle(article);
    }

    @DeleteMapping("/article/{id}")
    public Boolean delete(@PathVariable Integer id){
        return articleService.deleteArticleById(id);
    }

}
