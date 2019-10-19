package homework.demo.controller;

import homework.demo.model.article.Article;
import homework.demo.model.article.Category;
import homework.demo.model.filter.ArticleFilter;
import homework.demo.service.article.ArticleService;
import homework.demo.service.category.ArticleCategoryService;
import homework.demo.utility.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController implements WebMvcConfigurer {

    private ArticleService articleService;
    private ArticleCategoryService articleCategoryService;

    @Autowired
    public void setArticleCategoryService(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String home(ModelMap m, ArticleFilter filter, Pagination pages) {
        m.addAttribute("articles", articleService.findAllFilter(filter, pages));
        m.addAttribute("filter", filter);
        m.addAttribute("pages", pages);
        m.addAttribute("cates", articleCategoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/add")
    public String add(ModelMap m) {
        List<Category> cates = articleCategoryService.getAllCategories();
        m.addAttribute("isAdd", true);
        m.addAttribute("article", new Article());
        m.addAttribute("cates", cates);
        return "add";
    }

    @PostMapping("/add")
    public String insertArticle(@Valid @ModelAttribute Article article, BindingResult bindingresult, Model m, @RequestParam("img") MultipartFile file, @RequestParam(value = "category_id", required = false) Category category){
        if (bindingresult.hasErrors()) {
            m.addAttribute("isAdd", true);
            m.addAttribute("article", article);
            m.addAttribute("cates", articleCategoryService.getAllCategories());
            return "add";
            //return "addCategory";
        }
        if (!file.isEmpty()) {
            try {
                String nameFile = UUID.randomUUID().toString() + file.getOriginalFilename();
                article.setThumbnail(nameFile);
                Files.copy(file.getInputStream(), Paths.get("/Users/laughinggg/KSHRD/JAVA/Spring/Practice/17-SR-Spring-Homework-001/src/main/resources/image/", nameFile));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            article.setThumbnail("00.jpg");
        }
        System.out.println(article.toString());
        articleService.addArticle(article);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(ModelMap model, @PathVariable Integer id) {
        articleService.deleteArticleById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(ModelMap m, @PathVariable Integer id) {
        m.addAttribute("article", articleService.findById(id));
        m.addAttribute("isAdd", false);
        m.addAttribute("cates", articleCategoryService.getAllCategories());
        return "add";
    }

    @PostMapping("/update")
    public String updateArticle(@Valid @ModelAttribute Article article, BindingResult bindingresult, Model m, @RequestParam("img") MultipartFile file) {
        if (bindingresult.hasErrors()) {
            m.addAttribute("isAdd", false);
            m.addAttribute("article", article);
            m.addAttribute("cates", articleCategoryService.getAllCategories());
            return "add" ;
        }
        if (!article.getThumbnail().isEmpty()) {
            articleService.updateArticle(article);
            return "redirect:/";
        }
        if (!file.isEmpty()) {
            try {
                String updateFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
                article.setThumbnail(updateFileName);
                Files.copy(file.getInputStream(), Paths.get("/Users/laughinggg/KSHRD/JAVA/Spring/Practice/17-SR-Spring-Homework-001/src/main/resources/image/", updateFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            article.setThumbnail("00.jpg");
        }
        articleService.updateArticle(article);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@ModelAttribute Article article, Model m, @PathVariable Integer id) {
        m.addAttribute("article", articleService.findById(id));
        return "detail";
    }

    @GetMapping("/cate")
    public String allCategory(Model m) {
        m.addAttribute("cates", articleCategoryService.getAllCategories());


        return "category";
    }

    @GetMapping("/cate/add")
    public String category(Model m) {
        m.addAttribute("cate", new Category());
        m.addAttribute("isAdd", true);
        return "addcategory";
    }

    @PostMapping("/cate/add")
    public String addCategory(@Valid @ModelAttribute("cate") Category cate, BindingResult bindingResult, Model m) {
        if (bindingResult.hasErrors()) {
            m.addAttribute("cate",cate);
            m.addAttribute("isAdd", true);
            return "addcategory";
        }
        articleCategoryService.addCategory(cate);
        return "redirect:/cate";
    }

    @GetMapping("/cate/detail/{id}")
    public String categoryDetail(ModelMap m, @PathVariable Integer id) {
        m.addAttribute("cate", articleCategoryService.getCategoryByID(id));
        m.addAttribute("isDetail", true);
        m.addAttribute("isAdd", 2);
        return "addcategory";
    }

    @GetMapping("/cate/update/{id}")
    public String categoryUpdate(Model m, @PathVariable Integer id, @ModelAttribute Category cate) {
        m.addAttribute("cate", articleCategoryService.getCategoryByID(id));


        return "addcategory";
    }

    @PostMapping("/cate/update")
    public String categoryUpdatebyId(Model m, @ModelAttribute Category cate) {
        articleCategoryService.updateCategoryByID(cate);
        return "redirect:/cate";
    }

    @GetMapping("/cate/delete/{id}")
    public String categoryDelete(@PathVariable Integer id) {
        articleCategoryService.removeCategoryByID(id);
        return "redirect:/cate";
    }


}
