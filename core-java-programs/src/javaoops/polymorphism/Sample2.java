package javaoops.polymorphism;

class InvoiceAmount{
	
	void totalAmt(int inv_amount , int charges) {
		int invoiceAmount ;
		invoiceAmount = inv_amount + charges;
		System.out.println("Total Invoice Amount is: " + invoiceAmount);
	}
	
	void totalAmt(double inv_amount,double charges) {
		double invoiceAmount;
		invoiceAmount = inv_amount + charges;
		System.out.println("Total Invoice Amount is: " + invoiceAmount);
		
	}
}
public class Sample2 {
	public static void main(String[] args) {
		InvoiceAmount iaObj = new InvoiceAmount();
		iaObj.totalAmt(2000.67, 5000.66);
		iaObj.totalAmt(2000, 200);
	}
}
