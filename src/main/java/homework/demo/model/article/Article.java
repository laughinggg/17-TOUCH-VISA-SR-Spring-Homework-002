package homework.demo.model.article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Article {
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 12)
    private String title;

    @NotBlank
    @Size(min = 4, max = 60)
    private String description;

    @NotBlank
    @Size(min = 4, max = 12)
    private String author;

    private String createdDate;

    private String thumbnail;

    private Category category;

    public Article() {

    }

    public Article(Integer id, String title, String description, String author, String thumbnail, Category category, String createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.thumbnail = thumbnail;
        this.category = category;
        this.createdDate = createdDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", category='" + category + '\'' +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
