public class ALHeapMin {
    private ALHeap minHeap;
    
    public ALHeapMin() {
        minHeap = new ALHeap();
    }

    public String toString() {
        return minHeap.toString();
    }
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
    public Integer peekMin() {
        return minHeap.peekMin();
    }
    public void add(Integer newVal) {
        minHeap.add(newVal);
    }
    public Integer removeMin() {
        return minHeap.removeMin();
    }
}