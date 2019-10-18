package homework.demo.utility;

public class Pagination {

    private int page;
    private int limit;

    private int nextPage;
    private int previousPage;

    private int totalCount;
    private int totalPages;

    private int pagesToShow;
    private int startPage;
    private int endPage;

    private int offset;

    public Pagination() {
        this(1, 10, 0, 0, 5);
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public int getNextPage() {
        return (int) (page >= getTotalPages() ? getTotalPages() : page + 1);
    }

    public int getPreviousPage() {
        return (page <= 1) ? 1 : page - 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.totalCount / limit);
    }

    public int getPagesToShow() {
        return pagesToShow;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getOffset() {
        return (this.page - 1) * this.limit;
    }

    public void setPage(int currentPage) {
        this.page = (currentPage <= 1) ? 1 : currentPage;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.setStartPageEndPage(getTotalPages());
    }

    public void setTotalPage(int totalPage) {
        this.totalPages = totalPage;
    }

    public void setPagesToShow(int pagesToShow) {
        this.pagesToShow = pagesToShow;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Pagination(int page, int limit, int totalCount, int totalPage, int pagesToShow) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPages = totalPage;
        this.pagesToShow = pagesToShow;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", nextPage=" + nextPage +
                ", previousPage=" + previousPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPages +
                ", pagesToShow=" + pagesToShow +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", offset=" + offset +
                '}';
    }

    private void setStartPageEndPage(int totalPages) {
        int halfPagesToShow = pagesToShow / 2;

        if (totalPages <= pagesToShow) {
            startPage = 1;
            endPage = totalPages;

        } else if (page - halfPagesToShow <= 0) {
            startPage = 1;
            endPage = pagesToShow;

        } else if (page + halfPagesToShow == totalPages) {
            startPage = page - halfPagesToShow;
            endPage = totalPages;

        } else if (page + halfPagesToShow > totalPages) {
            startPage = totalPages - pagesToShow + 1;
            endPage = totalPages;

        } else {
            startPage = page - halfPagesToShow;
            endPage = page + halfPagesToShow;
        }
    }
}
