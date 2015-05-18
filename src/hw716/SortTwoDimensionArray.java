package hw716;

import java.util.Arrays;

public class SortTwoDimensionArray {
	public static void main(String[] args){
		int[][] test= {{5,1},{3,2},{4,7},{2,2},{3,9},{4,1},{3,0},{3,3}};
		for(int[]i :test)
			System.out.println(Arrays.toString(i));
		sort(test);
		System.out.println("After sort...");
		for(int[]i :test)
			System.out.println(Arrays.toString(i));
	}
	
	public static void sort(int[][] array){
		quickSortArray(array,0,array.length-1);
		for(int i = 0; i < array.length; ){
			int first = i;
			
			while(i < array.length && array[i][0] == array[first][0])
				i++;
				
			if(i - first  > 1){
				int[] tmp = new int[ i - first];
				for(int k = 0,j = first; j <= i-1 ; k++,j++)
					tmp[k] = array[j][1];
				quickSort(tmp,0,tmp.length-1);
				for(int k = 0,j = first; j <= i -1; k++,j++)
					array[j][1] = tmp[k];
			}
		}
	}
	
	public static void quickSort(int[] array, int left,int right){
		int i = left;
        int j = right;
        
        int pivot = array[left+(right-left)/2];
        
        while (i <= j) {
        	while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(array,i, j);
                i++;
                j--;
            }
        }
       
        if (left < j)
            quickSort(array,left, j);
        if (i < right)
            quickSort(array,i, right);
	}
	

	public static void quickSortArray(int[][]array, int left, int right){
		int i = left;
        int j = right;
        
        int pivot = array[left+(right-left)/2][0];
        
        while (i <= j) {
        	while (array[i][0] < pivot) {
                i++;
            }
            while (array[j][0] > pivot) {
                j--;
            }
            if (i <= j) {
                swapArray(array,i, j);
                i++;
                j--;
            }
        }
       
        if (left < j)
            quickSortArray(array,left, j);
        if (i < right)
            quickSortArray(array,i, right);
	}
	
	public static void swap(int[] array, int indexLeft , int indexRight){
		int temp = array[indexLeft];
		array[indexLeft] = array[indexRight];
		array[indexRight] = temp;
	}
	
	public static void swapArray(int[][] array, int indexLeft, int indexRight){
		int[] temp = array[indexLeft];
		array[indexLeft] = array[indexRight];
		array[indexRight] = temp;
	}
}
