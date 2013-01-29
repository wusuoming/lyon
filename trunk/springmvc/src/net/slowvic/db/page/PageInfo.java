package net.slowvic.db.page;

import java.util.List;

import org.noo.pagination.annotation.Paging;
import org.noo.pagination.page.Page;

@Paging(field = "page")
public class PageInfo<T> {
    private Page page;

    private List<T> pageElement;

    public PageInfo() {

    }

    public PageInfo(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getPageElement() {
        return pageElement;
    }

    public void setPageElement(List<T> pageElement) {
        this.pageElement = pageElement;
    }
}
