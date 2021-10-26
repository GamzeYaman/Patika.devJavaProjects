
public class Employee {

	String employeeName;
	double employeeSalary;
	int workHours;
	int hireYear;
	
	public Employee(String employeeName, double employeeSalary, int workHours, int hireYear){
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.hireYear = hireYear;
		this.workHours = workHours;
	}
	
	public double tax() {
		double tax = 0;
		if(this.employeeSalary <= 1000) {
			return 0;
		}else {
			tax = (this.employeeSalary * 0.03); 	
		}
		
		return tax;
	}
	
	public double bonus() {
		double bonus = 0;
		int extraHours;
		if(this.workHours > 40) {
			extraHours = workHours - 40;
		    bonus = (extraHours * 30);
		}
		return bonus;
	}
	
	public double raiseSalary() {
		double raiseSalary = 0;
		int currentYear = 2021;
		int year = (currentYear - this.hireYear);

		if(year < 10) {
			raiseSalary = (this.employeeSalary * 0.05);
		}else if(year > 9 && year < 20) {
			raiseSalary = (this.employeeSalary * 0.10);
		}else if(year > 19) {
			raiseSalary = (this.employeeSalary * 0.15);
		}
		return raiseSalary;
	}
	
	public void lastSalary() {
		double taxedSalary = this.employeeSalary - tax();
		double totalSalary = taxedSalary + bonus() + raiseSalary();
		System.out.println("Taxed Salary : " + taxedSalary);
		System.out.println("Total Salary : " + totalSalary);
	}
	
	public void printInfo() {
		System.out.println("Employee Name: " + this.employeeName);
		System.out.println("Employee Salary : " + this.employeeSalary);
		System.out.println("Working Hours : " + this.workHours);
		System.out.println("Hiring Year : " +  this.hireYear);
		System.out.println("Tax Amount : " + tax());
		System.out.println("Bonus : " + bonus());
		System.out.println("Raising Salary : " + raiseSalary());
		lastSalary();
	}
	
	
	}

