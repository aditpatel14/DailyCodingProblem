
public class CarCdr {
	int start;
	int end;
	

	public CarCdr(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}


	public static int car(CarCdr c) {
		return c.start;
	}
	public static int cdr(CarCdr c) {
		return c.end;
	}
	
	public static void main(String[] args) {
		System.out.println(car(new CarCdr(2,4)));
		System.out.println(cdr(new CarCdr(2,4)));

	}

}
