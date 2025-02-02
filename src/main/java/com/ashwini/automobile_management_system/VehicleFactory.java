package com.ashwini.automobile_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class VehicleFactory implements VehicleManagement{
	Scanner sc=new Scanner(System.in);
	private static int id=100;
	String name;
	String email;
	String password;
	String vehicleType;
	String vehicleBrand;
	String vehicleModel;
	String vehicleColor;
	String vehicleCost;
	String	engineType;
	String queryS;
	public void openLine(String s) {
		System.out.printf("%90s",s);
	}
	public void customerDetails() {
		System.out.println("Enter name: ");
		name=sc.nextLine();
		System.out.println("Enter Email Id:");
		email=sc.next();
		System.out.println("Enter Password(6 characters):");
		password=sc.next();
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/automobile_management_system","root","root");
			return con;
		
	}
	@Override
	public void addCustomer() {
		try {
			Connection con=getConnection();
			String query="insert into customers values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, ++id);
			ps.setString(2,name);
			ps.setString(3, email);
			ps.setString(4, password);
			if(ps.executeUpdate()>0) {
				System.out.println("Account Created SuccessFully...");
				
			}
			else {
				System.out.println("Please try again...");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void createAccount() {
		customerDetails();
		if(name.length()==0||email.length()==0||password.length()==0) {
			System.out.println("Please Enter name ,Email id and Password...");
		}
		else if(password.length()>6) {
			System.out.println("Password Should be of 6 characters.....");
		}
		else {
			addCustomer();
		}
	}
	public void getPassword() {
		System.out.println("Enter your name: ");
		name=sc.next();
		System.out.println("Enter Your mail id:");
		email=sc.next();
		try {
			Connection con=getConnection();
			String query="select password from customers where name=? and email=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ResultSet rs=ps.executeQuery();
			String psw=null;
			while(rs.next()) {
				psw=rs.getString(1);
			}
			if(psw==null) {
				System.out.println("Please try again...");
			}
			else {
				System.out.println("Your password is:"+psw);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean loginDirectly() {
		System.out.println("Enter your email:");
		email=sc.next();
		System.out.println("Enter password: ");
		password=sc.next();
		int ids=0;
		boolean status=false;
		try {
			Connection con=getConnection();
			String query="select id from customers where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ids=rs.getInt(1);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ids>=100) {
			return true;
		}
		else {
			return false;
		}
		
	}
		public int selectChoiceDesign(){
	
		System.out.println("Enter your Choice:");
		System.out.println("1.Add a vehicle");
		System.out.println("2.Delete a vehicle");
		System.out.println("3.Update a vehicle");
		System.out.println("4.Display all vehicles");
		
		return sc.nextInt();
		
	}
	@Override
	public void login() {
		boolean status=false;
		while(true) {
			System.out.println("1.Need Password or");
			System.out.println("2.Login directly");
			int log=sc.nextInt();
			if(log==1) {
				getPassword();
			}
			else {
				status=loginDirectly();
				if(status)
				{
					System.out.println("Login Successfull...");
					break;
				}
				else {
					System.out.println("Incurrect email id or password...\nPlease try again...");
				}
			}
			
		}
		if(status) {
		while(true) {
			int choice=selectChoiceDesign();
			switch(choice) {
			case 1:
				addVehicle();
				break;
			case 2:removeVehicle();
			break;
			case 3:updateVehicle();
			break;
			case 4:displayAllVehicles();
				break;
			default:
				System.out.println("Enter valid choice:");
			}
			System.err.println("Do you want to continue..y/n");
			if(sc.next().charAt(0)=='n')
				break;
		}
		}
		
	}

	@Override
	public void addVehicle() {
		Connection con;
		try {
			con = getConnection();
		
		//3.Create Statement 
		String queryS="Insert into automobiles values(?,?,?,?,?,?)";
		System.out.println("Enter vehicleType:");
		vehicleType=sc.next();
		System.out.println("Enter vehicleBrand:");
		vehicleBrand=sc.next();
		System.out.println("Enter vehicleColor:");
		vehicleColor=sc.next();
		System.out.println("Enter vehicleCost:");
		vehicleCost=sc.next();
		System.out.println("Enter vehicleModel:");
		vehicleModel=sc.next();
		System.out.println("Enter eingineType:");
		engineType=sc.next();
		
		
			PreparedStatement ps=con.prepareStatement(queryS);
			ps.setString(1, vehicleType);
			ps.setString(2,vehicleBrand);
			ps.setString(3, vehicleColor);
			ps.setString(4, vehicleCost);
			ps.setString(5, vehicleModel);
			ps.setString(6, engineType);
			//4.execute the query
			ps.executeUpdate();
			System.out.println("Vehicle added Successfully👌👌👌...");
			 con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void basedOnHelper() {
		System.out.println("Enter Vehicle type: ");
		vehicleType=sc.next();
		
		System.out.println("Enter Vehicle brand: ");
		vehicleBrand=sc.next();
		
		System.out.println("Enter Vehicle model: ");
		vehicleModel=sc.next();
		
	}
	@Override
	public void removeVehicle() {
		
		try {
			Connection con = getConnection();
		
		System.out.println("deleting the data based on vehicle type ,brand ,model");
		basedOnHelper();
		queryS="delete from automobiles where vehicleType=? and vehicleBrand=? and vehicleModel=?";
		
			PreparedStatement ps=con.prepareStatement(queryS);
			ps.setString(1, vehicleType);
			ps.setString(2, vehicleBrand);
			ps.setString(3, vehicleModel);
			if(ps.executeUpdate()>0)
				System.out.println("Deleted Successfully...😊😊");
			else
				System.out.println("Enter valid Vehicle type,brand and model...");
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int selectUpdate() {
		System.out.println("select which column do you want to update:");
		System.out.println("1.vehicleType");
		System.out.println("2.vehicleBrand");
		System.out.println("3.vehicleModel");
		System.out.println("4.vehicleColor");
		System.out.println("5.vehicleCost");
		System.out.println("6.engineType");
		return sc.nextInt();
	}
	public void updateCode() {
		System.out.println("update the date based on vehicle type ,brand ,model....");
		basedOnHelper();
	}

	@Override
	public void updateVehicle() {
		
		
		
		try {
			Connection con = getConnection();
		
		String tNew=null;
		switch(selectUpdate()) {
		case 1:
			updateCode();
			queryS="update automobiles set vehicleType=? where vehicleType=? and vehicleBrand=? and vehicleModel=?";
			System.out.println("Enter new value for vehicle type: ");
			tNew=sc.next();
			break;
		case 2:
			updateCode();
			queryS="update automobiles set vehicleBrand=? where vehicleType=? and vehicleBrand=? and vehicleModel=?";
			System.out.println("Enter new value for vehicle brand: ");
			tNew=sc.next();
			break;
		case 3:
			updateCode();
			queryS="update automobiles set vehicleModel=? where vehicleType=? and vehicleBrand=? and vehicleModel=?";
			System.out.println("Enter new value for vehicle model: ");
			tNew=sc.next();
			break;
		case 4:
			updateCode();
			queryS="update automobiles set vehicleColor=? where vehicleType=? and vehicleBrand=? and vehicleModel=?";
			System.out.println("Enter new value for vehicle color: ");
			tNew=sc.next();
			break;
		case 5:
			updateCode();
			queryS="update automobiles set vehicleCost=? where vehicleType=? and vehicleBrand=? and vehicleModel=?";
			System.out.println("Enter new value for vehicle type: ");
			tNew=sc.next();
			break;
		case 6:
			updateCode();
			queryS="update automobiles set engineType=? where vehicleType=? and vehicleBrand=? and vehicleModel=?";
			System.out.println("Enter new value for engine type: ");
			tNew=sc.next();
			break;
		default:
			System.out.println("choose currect");
			System.exit(0);
			}
			PreparedStatement ps=con.prepareStatement(queryS);
			ps.setString(1, tNew);
			ps.setString(2, vehicleType);
			ps.setString(3, vehicleBrand);
			ps.setString(4, vehicleModel);
			if(ps.executeUpdate()>0)
			{
				System.out.println("Updated Successfully👍👍👍...");
			}
			else {
				System.out.println("Enter valid Vehicle type,brand and model...");
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void displayAllVehicles() {
			
			try {
				Connection con = getConnection();
			
			Statement st=con.createStatement();
			queryS="select * from automobiles";
			ResultSet rs=st.executeQuery(queryS);
			while(rs.next()) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s",rs.getString(1),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				System.out.println();
			}
			con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
