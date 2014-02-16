package sort.Products;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static Stack<Products> st=new Stack<>();
	static int costToBePaid=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Products a[]=new Products[10];
		for (int i=0;i<a.length;i++){
			System.out.println(i);
			a[i]=new Products();
			a[i].setId(i);
			a[i].setPrice((int)(Math.random()*(400-1)+1));
		}
		System.out.println("The product id "+a[0].getId()+" has price "+a[0].getPrice());
		System.out.println("The product id "+a[1].getId()+" has price "+a[1].getPrice());
		System.out.println("The product id "+a[2].getId()+" has price "+a[2].getPrice());
		System.out.println("The product id "+a[3].getId()+" has price "+a[3].getPrice());
		System.out.println("The product id "+a[4].getId()+" has price "+a[4].getPrice());
		System.out.println("The product id "+a[5].getId()+" has price "+a[5].getPrice());
		System.out.println("The product id "+a[6].getId()+" has price "+a[6].getPrice());
		System.out.println("The product id "+a[7].getId()+" has price "+a[7].getPrice());
		System.out.println("The product id "+a[8].getId()+" has price "+a[8].getPrice());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of products, total cost");
		int numberOfProducts=Integer.parseInt(br.readLine());
		int cost=Integer.parseInt(br.readLine());
		findProductList(a,numberOfProducts,cost,0);				
	}
	private static void findProductList(Products[] a,
			int numberOfProducts,int cost,int start) {
		// TODO Auto-generated method stub
		if(costToBePaid<=cost && st.size()==numberOfProducts){
			print(st);
		}
		for(int i=start;i<a.length;i++){
			if(costToBePaid+a[i].getPrice()<=cost){
				st.push(a[i]);
				costToBePaid+=a[i].getPrice();
				findProductList(a, numberOfProducts, cost, i+1);
				costToBePaid-=(Integer)(st.pop().getPrice());
			}
		}
		
		}
	private static void print(Stack<Products> st1) {
		// TODO Auto-generated method stub
		System.out.println("In print");
		for(Products products:st){
			System.out.print("ID:"+products.getId()+" "+"Price :"+products.getPrice());
		}
		System.out.println();
	}
}
	
