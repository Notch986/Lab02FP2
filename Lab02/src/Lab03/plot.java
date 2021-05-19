package Lab03;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.panayotis.gnuplot.JavaPlot;

public class plot {
	
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		
		File gnu = null;
    	BufferedWriter bw = null;
    	gnu = new File ("insertion.txt");
    	gnu.createNewFile();
	    bw = new BufferedWriter(new FileWriter(gnu));
	    
	    File gnu2 = null;
    	BufferedWriter bw2 = null;
    	gnu2 = new File ("merge.txt");
    	gnu2.createNewFile();
	    bw2 = new BufferedWriter(new FileWriter(gnu2));
	    
		System.out.println("Ingrese tama�o de arreglos m�ximo:");
		int tamano = scan.nextInt();
		long Tinicio, Tfinal;
		long tiempo;
		ArrayList<int[]> a = new ArrayList<int[]>();
		ArrayList<int[]> b = new ArrayList<int[]>();

		for(int x=2; x<=tamano; x++) {
			//crear arreglos en peor caso
			a.add(crearArreglo(x));
			
			Tinicio = System.nanoTime();
			insertionSort(a.get(x-2));
			Tfinal = System.nanoTime();
			tiempo = Tfinal-Tinicio;
				
			bw.write(x+"\t"+tiempo+"\n");
			
			b.add(crearArreglo(x));
			
			Tinicio = System.nanoTime();
			sort(b.get(x-2),0,b.get(x-2).length-1);
			Tfinal = System.nanoTime();
			tiempo = Tfinal-Tinicio;
			
			bw2.write(x+"\t"+tiempo+"\n");
				
		}
		
		bw.close();
		bw2.close();
		scan.close();
		Desktop.getDesktop().open(gnu);
		Desktop.getDesktop().open(gnu2);
	 	
	 	JavaPlot p = new JavaPlot();
	 	p.addPlot("\"insertion.txt\" with lines");
	 	p.addPlot("\"merge.txt\" with lines");
	 	p.plot();
 	
	}
	public static int[] crearArreglo(int x) {
		int[] a = new int[x];
		for(int i=0; i<a.length; i++) {
			a[i] = a.length-i;
		}
		return a;
	}
	public static void insertionSort(int[] arr) {
		int joke;
		for(int k=0; k<arr.length-1;k++){
			for(int i=0; i<arr.length-1;i++){
				if(arr[i]>arr[i+1]) {
					joke = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = joke;					
				}			
			}
		}
		System.out.println();
	}
	
	public static void sort(int arr[], int left, int right){
	    if(left < right){
	      int middle = (left + right) / 2;
	      
	      sort(arr, left, middle);
	      sort(arr, middle+1, right);
	      mezclar(arr, left, middle, right);
	    }
	}
	public static void mezclar(int arr[], int left, int middle, int right) {
		  int n1 = middle - left + 1;
		  int n2 = right - middle;

		  int leftArray[] = new int [n1];
		  int rightArray[] = new int [n2];

		  for (int i=0; i < n1; i++) {
		    leftArray[i] = arr[left+i];
		  }
		  for (int j=0; j < n2; j++) {
		    rightArray[j] = arr[middle + j + 1];
		  }

		  int i = 0, j = 0;

		  int k = left;

		  while (i < n1 && j < n2) {
		    if (leftArray[i] <= rightArray[j]) {
		      arr[k] = leftArray[i];
		      i++;
		    } else {
		        arr[k] = rightArray[j];
		        j++;
		    }
		    k++;
		  }
		  while (i < n1) {
		    arr[k] = leftArray[i];
		    i++;
		    k++;
		  }
		  while (j < n2) {
		    arr[k] = rightArray[j];
		    j++;
		    k++;
		  }
		}
}