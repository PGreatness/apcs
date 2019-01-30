//Team EquipoNumeroUno (Roster: Ahnaf Hasan, Colin Hosking, Aidan Griffin)
//APCS2 pd08
//Lab 1
//2018-03-13

/*
Timing mechanism:
An array is initiated with length 100, which increases by 50 until 10000 with each trial.
The array is the populated and shuffled. StartTime is recorded, and Quicksort is immidiately executed.
After Qucksort terminates, the total runtime is calculated by subtracting the StartTime with the current time. 
This runtime is added to a running sum of runtimes. The array is reshuffled, and Quicksort is executed in the array of
length n 1000 times. The average runtime is then calculated, and written into a file. 
Then the array length is increased by 50, and the next trial for a different n begins.
*/

import java.io.*;

public class QuickSortTester {
    
    public static String write(String toWrite, String fileName) { //courtesy of Joan Chirinos
	File f = new File(fileName);
	f.delete();
	try {
	    FileWriter fw = new FileWriter(fileName);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(toWrite);
	    bw.close();
	}
	catch (IOException e) {
	    throw new IllegalArgumentException("\n\tCannot write to file");
	}
	return toWrite;
    }//end write
    
    
    public static String read(String fileName) { //courtesy of Joan Chirinos
	File f = new File("./" + fileName);
	if (!(f.exists()))
	    throw new IllegalArgumentException("\n\tFile does not exist");
	String ret = "";
	try {
	    FileReader fr = new FileReader(fileName);
	    BufferedReader br = new BufferedReader(fr);
	    String toAdd;
	    while ((toAdd = br.readLine()) != null)
		ret += toAdd + "\n";
	}
	catch (IOException e) {
	    throw new IllegalArgumentException("\n\tUnable to read file");
	}
	return ret;
    }//end read
    
    public static void main(String[] args) {
	QuickSort sort = new QuickSort();


	for (int num = 100; num < 10050; num += 50){
	
	int[] tester1 = sort.buildArray(num, 10000);
	
	int i = 0;
	long startTime;
	long totalTime;
	long sum = 0;
	
	while (i<1000){
	    //sort.shuffle(tester1);
	    startTime = System.nanoTime();
	    sort.qsort(tester1);
	    totalTime = System.nanoTime() - startTime;
	    sum += totalTime;
	    i++;
	    tester1 = sort.buildArray(num,10000);
	    
	}
	String ans = read("BestData") + num + "," + sum/1000 + "\n";
	write(ans,"BestData");}
    }
}
