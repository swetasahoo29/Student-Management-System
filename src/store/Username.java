package store;

public class Username {
	public static String login_name;
	public String name;
	public String password;
	public String dob;

	public static String getLogin_name() {
		return login_name;
	}

	public static void setLogin_name(String login_name) {
		Username.login_name = login_name;
	}

	public String regd_no;
	public String course;
	public String id;
	public int total_payment;
	public int total_paid;
	public int total_dues;

	public Username(String name, String password, String dob, String regd_no, String course, String id,
			int total_payment, int total_paind, int total_dues) {
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.regd_no = regd_no;
		this.course = course;
		this.id = id;
		this.total_payment = total_payment;
		this.total_paid = total_paind;
		this.total_dues = total_dues;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	public String getCourse() {// wait
		return course;
	}

	public String getDob() {
		return dob;
	}

	public String getRegd_no() {
		return regd_no;
	}

	public int getTotal_payment() {
		return total_payment;
	}

	public int getTotal_dues() {
		return total_dues;
	}

	public int getTotal_paid() {
		return total_paid;
	}

}
