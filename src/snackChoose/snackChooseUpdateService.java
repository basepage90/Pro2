package snackChoose;

import java.util.Vector;

import javax.swing.JOptionPane;

import product.ProductDAO;
import product.ProductDTO;
import product.SelectProduct;
import product.UpdateProduct;

public class snackChooseUpdateService {

	
	String name;
	int minusAmount;
	String price;
	
	public snackChooseUpdateService(String name,String price,int minusAmount) {
		this.name=name;
		this.minusAmount= minusAmount;
		this.price=price;
	}
	
	public boolean stockchange() {
		UpdateProduct up = new UpdateProduct();
		ProductDAO sp = new ProductDAO();
		Vector<ProductDTO> vc = sp.Product(name);
		int total = vc.get(0).getProStock();

		int newStock = total - minusAmount;
		
		if(newStock<0) {
			return false;
		}
		else {
		up.updateProduct(name, price, newStock, name);
		//chargein���̺��������ؾ���.
			return true;
		}
		
	}
}
