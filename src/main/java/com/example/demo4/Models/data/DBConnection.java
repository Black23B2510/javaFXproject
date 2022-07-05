package com.example.demo4.Models.data;

import com.example.demo4.Models.Customers;
import com.example.demo4.Models.admin;
import com.example.demo4.Models.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {
    public Connection con;
    public DBConnection(){
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/dendenpharmacy","root","");
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<admin> getAdmin(){
        ArrayList<admin> Admin = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("password"));
                admin ad = new admin(
                        rs.getString("name"),
                        rs.getString("password")
                );
                Admin.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Admin;
    }
    public ArrayList<Customers> getCustomers(){
        ArrayList<Customers> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("cusName"));
                System.out.println(rs.getString("password"));
                Customers cus = new Customers(
                        rs.getInt("cusID"),
                        rs.getString("cusName"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("password")
                );
                customers.add(cus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
    public void insertCustomer(Customers cus){
        String sql = "INSERT INTO customers(cusName, email, address, password) VALUE ('"+cus.cusName+"','"+cus.email+"','"+cus.address+"','"+cus.password+"')";
        System.out.println(sql);
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("Insert successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<product> getProduct(){
        ArrayList<product> listProducts = new ArrayList<>();
        String sql  = "SELECT * FROM products";
        try {
            ResultSet result = con.prepareStatement(sql).executeQuery();
            while (result.next()){
                product product = new product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("NSX"),
                        result.getString("image"),
                        result.getFloat("price"),
                        result.getInt("quantity"),
                        result.getString("description")
                );
                listProducts.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listProducts;
    }
    public void deleteProduct(int id){
        String sql = "DELETE FROM products WHERE id = "+id+"";
        try {
            con.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertProduct(product pro){
        String sql = "INSERT INTO products(name, NSX,image, price, quantity, description) VALUE ('"+pro.name+"','"+pro.NSX+"','"+pro.image+"','"+pro.price+"','"+pro.quantity+"','"+pro.description+"')";
        System.out.println(sql);
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("Insert successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateProduct(product pro){
        String sql = "UPDATE products SET name ='"+pro.name+"', NSX ='"+pro.NSX+"', image = '"+pro.image+"', price = '"+pro.price+"', quantity = '"+pro.quantity+"', description = '"+pro.description+"' WHERE id = "+pro.id+"";
        System.out.println(sql);
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("UPDATE successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    public ArrayList<product> getProductById(int id){
//        ArrayList<product> product = new ArrayList<>();
//        String sql = "SELECT * from products where id = '"+id+"'";
//        System.out.println(sql);
//        try {
//            ResultSet rs = con.prepareStatement(sql).executeQuery();
//            while (rs.next()){
//                com.example.demo4.Models.product pro = new product(
//                        rs.getString("name"),
//                        rs.getString("NSX"),
//                        rs.getString("image"),
//                        rs.getFloat("price"),
//                        rs.getInt("quantity")
//                );
//                product.add(pro);
//            }
//            System.out.println("Select successfully");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return product;
//    }

}
