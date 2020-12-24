package util;

/**
 * @author Timgreat
 * @date 2020/12/5 - 18:22
 */
public class Page {
    private int currentPage=1;
    private int totalCount=0;
    private int pageSize=0;
    private int totalPageCount=0;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage>0)
            this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount = totalCount;
            if(this.totalCount%this.pageSize==0){
                this.totalPageCount=this.totalCount/this.pageSize;
            }else if(this.totalCount%this.pageSize>0){
                this.totalPageCount=this.totalCount/this.pageSize+1;
            }else{
                this.totalPageCount=0;
            }
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize>0)
            this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
