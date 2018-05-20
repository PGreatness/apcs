import java.util.ArrayList;

public class ALHeapMax {
    private ArrayList<Integer> maxHeap;

    public ALHeapMax() {
        maxHeap = new ArrayList<Integer>();
    }

    public String toString() {
    //simple version:
	//return maxHeap.toString(); 

	//prettier version:
	String lvlOrdTrav = "heap size " + maxHeap.size() + "\n";

	if ( maxHeap.size() == 0 ) return lvlOrdTrav;

	int h = 1; //init height to 1
	for( int i = 0; i < maxHeap.size(); i++ ) {
	    lvlOrdTrav += i + ":" + maxHeap.get(i) + " ";
	    if ( i >= Math.pow(2,h) - 2 ) {
		lvlOrdTrav += "\n";
		h++;
	    }
	}
	return lvlOrdTrav;
    }//O(n)
    public boolean isEmpty() {
        return maxHeap.size() == 0;
    }
    public Integer peekMax() {
        if (maxHeap.size() < 1) {
            return null;
        }else{
            return maxHeap.get(0);
        }
    }
    public void add(Integer addVal) {
        maxHeap.add(addVal);
        int addValPos = maxHeap.size() - 1;
        int parentPos;
        while (addValPos > 0) {
            parentPos = (addValPos - 1) / 2;
            if (addVal.compareTo(maxHeap.get(parentPos)) > 0) {
                swap(addValPos, parentPos);
                addValPos = parentPos;
            }else{
                break;
            }
        }
    }
    public Integer removeMax() {
        if (maxHeap.size() == 0) {
            return null;
        }
        Integer retVal = peekMax();
        Integer tmp = maxHeap.get(maxHeap.size() - 1);
        swap(0, maxHeap.size() - 1);
        int pos = 0;
        int maxChildPos;
        while (pos < maxHeap.size()) {
            maxChildPos = maxChildPos(pos);
            if (maxChildPos == -1) {
                break;
            }else{
                if (tmp.compareTo(maxHeap.get(maxChildPos)) >= 0) {
                    break;
                }else{
                    swap(pos, maxChildPos);
                    pos = maxChildPos;
                }
            }
        }
        return retVal;
    }
    public int maxChildPos(int pos) {
    int retVal;
	int lc = 2*pos + 1; //index of left child
	int rc = 2*pos + 2; //index of right child

	//pos is not in the heap or pos is a leaf position
	if ( pos < 0 || pos >= maxHeap.size() || lc >= maxHeap.size() )
	    retVal = -1;
	//if no right child, then left child is only option for Max
	else if ( rc >= maxHeap.size() )
	    retVal = lc;
	//have 2 children, so compare to find least 
	else if ( maxHeap.get(lc).compareTo(maxHeap.get(rc)) > 0 )
	    retVal = lc;
	else
	    retVal = rc;
	return retVal;
    }//O(1)
    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) {
    maxHeap.set( pos1, maxHeap.set( pos2, maxHeap.get(pos1) ) );	
    }
    public static void main(String[] args) {
        ALHeapMax trial = new ALHeapMax();
        trial.add(2);
        System.out.println(trial);
        trial.add(4);
        System.out.println(trial);
        trial.add(6);
        System.out.println(trial);
        trial.add(8);
        System.out.println(trial);
        trial.add(10);
        System.out.println(trial);
        trial.add(1);
        System.out.println(trial);
        trial.add(3);
        System.out.println(trial);
        trial.add(5);
        System.out.println(trial);
        trial.add(7);
        System.out.println(trial);
        trial.add(9);
        System.out.println(trial);

        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
        System.out.println("removing " + trial.removeMax() + "...");
        System.out.println(trial);
    }
}