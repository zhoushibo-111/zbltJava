package entity;

import lombok.Data;

import java.util.List;
@Data
public class PageResult<T>  {

    private Long total;

    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {

        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }





}
