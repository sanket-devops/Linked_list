class MySinglyLinkedList<T> {

    private SingleNode<T> start;
    private SingleNode<T> end;
    private int size;

    MySinglyLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    /**
     * add at the end of list.
     *
     * @param val
     */
    void add(T val) {
        SingleNode nptr = new SingleNode(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setNextlink(nptr);
            end = nptr;
        }
    }

    /**
     * remove greater than given value.
     *
     * @param value
     */
    void deleteGT(Integer value) {
        SingleNode prev = start;
        SingleNode current = start;
        SingleNode next = start;
        while (next != null) {
            prev = current;
            current = next;
            next = next.getNextLink();

            if (Integer.parseInt(current.dataItem.toString()) > value) {
                prev.nextLink = current.getNextLink();
                if (start == current) {
                    start = current.getNextLink();
                }
                if (end == current) {
                    end = current.getNextLink();
                }
                size--;
            }
        }
    }

    /**
     * remove last item of list.
     */
    public void remove() {

        if (start == end && size == 1) {
            start = null;
            end = null;
            size--;
            return;
        }

        SingleNode next = start;
        SingleNode prev = start;
        while (next != end) {
            prev = next;
            next = next.getNextLink();
        }
        end = prev;
        end.setNextlink(null);
        size--;
        return;
    }

    /**
     * print all values of list.
     */
    public void displayAll() {
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }

        if (start.getNextLink() == null) {
            System.out.println(start.getData());
            return;
        }

        SingleNode ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getNextLink();
        while (ptr.getNextLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getNextLink();
        }

        System.out.print(ptr.getData() + "\n");
    }

}

class SingleNode<T> {

    protected T dataItem;
    protected SingleNode<T> nextLink;

    public SingleNode(T d, SingleNode n) {
        this.dataItem = d;
        this.nextLink = n;
    }

    /**
     * set next link
     *
     * @param n
     */
    public void setNextlink(SingleNode<T> n) {
        this.nextLink = n;
    }

    /**
     * set data to node.
     *
     * @param data
     */
    public void setData(T data) {
        dataItem = data;
    }

    /**
     * get next link of node.
     *
     * @return
     */
    public SingleNode getNextLink() {
        return nextLink;
    }

    /**
     * get data of node.
     *
     * @return
     */
    public T getData() {
        return dataItem;
    }

}
