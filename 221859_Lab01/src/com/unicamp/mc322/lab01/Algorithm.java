package com.unicamp.mc322.lab01;

public class Algorithm {

	public static void main(String[] args) {
		 int quantity = 10;
	        int[] vector = new int[quantity];
	        
	        for (int i = 0; i < vector.length; i++) { //1
	            vector[i] = (int) (Math.random()*100);
	        }
	        
	        sort(vector);
	        
	        for (int i = 0; i < vector.length; i++) { //2
	            System.out.println(vector[i]);
	        }
	}

	private static void sort(int[] vector){
	      
        boolean switched = true;
        int aux;
        while (switched) {
            for (int i = 2; i < vector.length; i++) { //4
                if (vector[i] < vector[i - 1]) {
                  aux = vector[i];
                  vector[i] = vector[i - 1];
                  vector[i - 1] = aux; //3
                  if (vector[i - 1] < vector[i - 2]) {
                	  aux = vector[i - 1];
                      vector[i - 1] = vector[i - 2];
                      vector[i - 2] = aux; 
                  } else 
                	  switched = false;
                }
            } 
        }
    }
}
