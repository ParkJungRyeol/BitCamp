package Day0725;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Order {
	private int orderNo;
	private Date orderDt;
	private HashMap products = new HashMap();

	public Order(int orderNo, Date orderDt) {
		this.orderNo = orderNo;
		this.orderDt = orderDt;
	}

	public void addProduct(int ordProdNo, Product p) {
		products.put(ordProdNo, p);

	}

	public void delProduct(int ordProdNo) {
		products.remove(ordProdNo);
	}

	public void chgProduct(int ordProdNo, Product p) {
		products.replace(ordProdNo, p);

	}

	public void printKeyBySort() {		
		TreeMap<Integer,Product> tm =  new TreeMap(products);
		Iterator<Integer> it = tm.keySet().iterator();
				while(it.hasNext()) { //hashmap 데이터를 treemap에 넣어줌
					int key =it.next();		
					System.out.println(key +"/"+ tm.get(key));		
		}
		
	}

	public void printValueBySort(Comparator c) {
		List<Product> l = new ArrayList<>();
    	l.addAll(this.products.values());
    	Collections.sort(l,c);
    	for(Product p : l) {
    		System.out.println(p);
    	}
	}
	
	public void print() {
		Set set = products.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			Product prd= (Product)e.getValue();
			System.out.println(prd.getProductNo()+"/"+prd.getProductName());
		}
	}
	
	

}

class Product {
	private int productNo;
	private String productName;

	public Product(int productNo, String productName) {
		this.productNo = productNo;
		this.productName = productName;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductNum(String productName) {
		this.productName = productName;
	}
	
	public String toString() {
		return "제품번호 : "+this.getProductNo()+"\n제품이름 : "+this.getProductName()+"\n";
	}
	


}

class Compare1 implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getProductNo()<o2.getProductNo() ? -1 : o1.getProductNo()==o2.getProductNo() ? 0 : 1;
	}
}

class Utils {

	public static int calTimeGap(Date carIndt) throws ParseException {
		Date now = new Date(); // 현재시간
		long diff = now.getTime() - carIndt.getTime();
		long hour = diff / (1000 * 60 * 60);
		return (int) hour;
	}

	public static Date getDate(int year, int month, int date, int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, date, hour, minute, second);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static String getDate(Date date) {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format1.format(date);
	}
}

public class Assignment {

	public static void main(String[] args) {
		Compare1 c = new Compare1();
		Order od = new Order(1, Utils.getDate(2019, 7, 24, 10, 00, 00));
		Product p1 = new Product(22,"몽쉘");
		Product p2 = new Product(11,"아몬드빼빼로");
		Product p3 = new Product(33,"2%부족할때");
		
		od.addProduct(1, p1);
		od.print();
		System.out.println("===================");
		od.addProduct(2, p2);
		od.print();
		System.out.println("===================");
		od.delProduct(1);
		od.print();	
		System.out.println("===================");
		od.chgProduct(2, p3);
		od.print();
		System.out.println("===================");
		od.addProduct(2, p2);
		od.addProduct(1, p1);
		od.printKeyBySort();
		System.out.println("===================");
		
		Collections.sort(list);//comparable
		Collections.sort(list, c); //comparator

		
		od.printValueBySort(c);
		
		class age implements Comparator{
			
		}

	
	}

}
