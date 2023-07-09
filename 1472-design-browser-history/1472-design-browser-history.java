class BrowserHistory {
    private Node node;

    public BrowserHistory(String homepage) {
        this.node = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        node.next = newNode;
        newNode.prev = node;
        node = newNode;
    }

    public String back(int steps) {
        while (node.prev!=null){
            node = node.prev;
            steps--;
            if(steps==0){
                break;
            }
        }
        return node.url;
    }

    public String forward(int steps) {
        while (node.next!=null){
            node = node.next;
            steps--;
            if(steps==0){
                break;
            }
        }
        return node.url;
    }

    class Node{
        Node prev;
        Node next;
        String url;
        Node(String url){
            this.url = url;
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */