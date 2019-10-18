package homework.demo.model.article;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Category {

    private int cate_id;

    @NotBlank
    @Size(min = 4, max = 12)
    private String cate_name;

    public Category() {

    }

    public int getCate_id() {
        return cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cate_id=" + cate_id +
                ", cate_name='" + cate_name + '\'' +
                '}';
    }
}

