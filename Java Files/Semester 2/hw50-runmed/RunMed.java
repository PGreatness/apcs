/**
 * RunMed
 */
public class RunMed {
    private ALHeapMin minHeap;
    private ALHeapMax maxHeap;
    private int minCount; //size of minHeap
    private int maxCount; //size of maxHeap

    public RunMed() {
        minHeap = new ALHeapMin();
        maxHeap = new ALHeapMax();
        minCount = 0;
        maxCount = 0;
    }
    /**
     * Adds value to correct heap. The heap will auto balance itself with tolerance
     * of 1.
     * @param addVal an Integer
     */
    public void add(Integer addVal) {
        if (Math.abs(maxCount - minCount) < 2) { //size doesn't vary by much
            if (minCount == 0) { //minimum heap is empty
                minCount++;
                minHeap.add(addVal);
                return;
            }
            if (maxCount == 0) { //maximum heap is empty
                maxCount++;
                maxHeap.add(addVal);
                return;
            }
            if (addVal < maxHeap.peekMax()) { //the value is less than the max in maxHeap
                maxCount++;
                maxHeap.add(addVal);
            }else{ //value is equal to or greater than max heap's root
                minCount++;
                minHeap.add(addVal);
            }
        }else{ //size varies by at least 2
            if (minCount > maxCount) { //there are more minimums
                while (Math.abs(maxCount - minCount) >= 2) { //loop until size is returned
                    maxHeap.add(minHeap.removeMin()); //add the taken away to the other
                    maxCount++;
                }
                //add addVal as normal
                if (addVal < maxHeap.peekMax()) { 
                    maxCount++;
                    maxHeap.add(addVal);
                }else{
                    minCount++;
                    minHeap.add(addVal);
                }
            }else{ //there are more maximums
                while (Math.abs(maxCount - minCount) >= 2) { //loop until size is returned
                    minHeap.add(maxHeap.removeMax()); //add the taken away to the other
                    minCount++;
                }
                //add addVal as normal
                if (addVal < maxHeap.peekMax()) {
                    maxCount++;
                    maxHeap.add(addVal);
                }else{
                    minCount++;
                    minHeap.add(addVal);
                }
            }
        }
    }//o(n)
    /**
     * Returns the median of the list
     * @return Integer that is the median
     */
    public Integer getMedian() { //return median of heaps
        if (minCount == maxCount) { //size equal, return root of any
            return minHeap.peekMin();
        }else{ //size varies by 1
            if (minCount > maxCount) { //more minimums
                return minHeap.peekMin();
            }else{ //more maximums
                return maxHeap.peekMax();
            }
        }
    }

    public static void main(String[] args) {
        
    }
}