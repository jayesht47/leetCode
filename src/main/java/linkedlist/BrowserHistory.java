package linkedlist;

/**
 * https://leetcode.com/problems/design-browser-history/
 */
public class BrowserHistory {
    class Page {
        String url = "";
        Page prev = null;
        Page next = null;

        Page(String url) {
            this.url = url;
        }
    }

    Page curPage = null;

    public BrowserHistory(String homepage) {
        Page page = new Page(homepage);
        curPage = page;
    }

    public void visit(String url) {
        Page newPage = new Page(url);
        if (curPage != null) curPage.next = newPage;
        newPage.prev = curPage;
        curPage = newPage;
    }

    public String back(int steps) {
        while (curPage.prev != null && steps > 0){
            curPage = curPage.prev;
            steps--;
        }
        return curPage.url;
    }

    public String forward(int steps) {
        while (curPage.next != null && steps > 0){
            curPage = curPage.next;
            steps--;
        }
        return curPage.url;
    }
}
