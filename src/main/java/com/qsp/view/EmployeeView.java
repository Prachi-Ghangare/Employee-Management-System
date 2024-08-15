package com.qsp.view;

import java.util.List;
import java.util.Scanner;

import com.qsp.controller.EmployeeController;
import com.qsp.model.Employee;

public class EmployeeView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("****** Welcome ******");
			System.out.println("1.Insert Data");
			System.out.println("2.Retrieve Data");
			System.out.println("3.Update Data");
			System.out.println("4.Delete Data");
			System.out.println("5.Exit");
			System.out.print("Enter an option: ");
			int opt = sc.nextInt();
			switch (opt) {
			case 1:{
				Employee e = new Employee();
				System.out.print("Enter id: ");
				e.setId(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter name: ");
				e.setName(sc.nextLine());
				System.out.print("Enter Salary: ");
				e.setSal(sc.nextDouble());
				EmployeeController.insert(e);
				System.out.println("Data Inserted Successfully !");
				break;
			}
			case 2:{
				System.out.println("1.Retrieve using Id");
				System.out.println("2.Retrieve all");
				System.out.print("Choose an option: ");
				int option = sc.nextInt();
				switch (option) {
				case 1:{
					System.out.print("Enter the id: ");
					Employee e =EmployeeController.fetchById(sc.nextInt());
					System.out.println("Id\tName\tSalary");
					System.out.println("--------------------");
					System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getSal());
					break;
				}
				case 2:{
					List<Employee> li = EmployeeController.fetchAll();
					for (Employee emp : li) {
						System.out.println(emp);
					}
					break;
				}
				default:
					System.out.println("Please enter correct option");
					break;
				}
				break;
			}
			case 3:{
				System.out.println("1.Update Name");
				System.out.println("2.Update Salary");
				System.out.print("Enter an option: ");
				int a = sc.nextInt();
				switch (a) {
				case 1:{
					System.out.print("Enter id: ");
					int Id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter new Name: ");
					String nname = sc.nextLine();
					boolean b = EmployeeController.updateNameById(Id,nname);
					if(b) {
						System.out.println("Name updated");
					}else	System.out.println("id is not present");
					break;
				}
				case 2:{
					System.out.print("Enter id: ");
					int Id = sc.nextInt();
					System.out.print("Enter salary: ");
					double sal = sc.nextDouble();
					EmployeeController.updateSalaryById(Id, sal);
					break;
				}
				default:
					System.out.println("Wrong option");
					break;
				}
				break;
			}
			case 4:{
				System.out.println("Enter id: ");
				boolean b = EmployeeController.deleteById(sc.nextInt());
				if(b) {
					System.out.println("Deleted successfully");
				}else System.out.println("id is not present");
				break;
			}
			case 5:{
				EmployeeController.closeConnection();
				System.exit(0);
				break;
			}
			default:
				System.out.println("Enter correct input");
				break;
			}
			System.out.println("Enter Y to continue");
		}while("Y".equalsIgnoreCase(sc.next()));
	}
}
