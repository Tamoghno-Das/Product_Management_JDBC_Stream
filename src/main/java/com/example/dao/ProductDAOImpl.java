package com.example.dao;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO
{

    @Override
    public void addProduct(Product product) throws ProductException
    {
        try(Connection con= DBUtil.getConnection())
        {
            String sql=
                    "insert into products values(?,?,?,?,?)";
            PreparedStatement ps=
                    con.prepareStatement(sql);
            ps.setInt(1,product.getProductId());
            ps.setString(2,product.getProductName());
            ps.setString(3,product.getCategory());
            ps.setDouble(4,product.getPrice());
            ps.setInt(5,product.getQuantity());
            ps.executeUpdate();
            System.out.println("Product Added");
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }


    }

    @Override
    public void updateProduct(Product product) throws ProductException
    {
        try(Connection con=DBUtil.getConnection())
        {
            String sql=
                    "update products set price=?,quantity=? where product_id=?";
            PreparedStatement ps=
                    con.prepareStatement(sql);
            ps.setDouble(1,product.getPrice());
            ps.setInt(2,product.getQuantity());
            ps.setInt(3,product.getProductId());
            ps.executeUpdate();
            System.out.println("Updated");
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }

    }

    @Override
    public void deleteProduct(int id) throws ProductException
    {
        try(Connection con=DBUtil.getConnection())
        {
            PreparedStatement ps=
                    con.prepareStatement(
                            "delete from products where product_id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Deleted");
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }


    }

    @Override
    public Product getProductById(int id) throws ProductException
    {

        Product p=null;
        try(Connection con=DBUtil.getConnection())
        {
            PreparedStatement ps=
                    con.prepareStatement(
                            "select * from products where product_id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                p=new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5));
            }
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }
        return p;
    }

    @Override
    public List<Product> getAllProducts() throws ProductException
    {
        List<Product> list=new ArrayList<>();
        try(Connection con=DBUtil.getConnection())
        {
            Statement st=con.createStatement();
            ResultSet rs=
                    st.executeQuery(
                            "select * from products");
            while(rs.next())
            {
                list.add(
                        new Product(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDouble(4),
                                rs.getInt(5)
                        ));
            }
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Product> searchByCategory(String category) throws ProductException
    {

        List<Product> list=new ArrayList<>();
        try(Connection con=DBUtil.getConnection())
        {
            PreparedStatement ps=
                    con.prepareStatement(
                            "select * from products where category=?");
            ps.setString(1,category);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(
                        new Product(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDouble(4),
                                rs.getInt(5)
                        ));
            }
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Product> searchByPriceRange(double min, double max) throws ProductException
    {
        List<Product> list=new ArrayList<>();
        try(Connection con=DBUtil.getConnection())
        {
            PreparedStatement ps=
                    con.prepareStatement(
                            "select * from products where price between ? and ?");
                            ps.setDouble(1,min);
            ps.setDouble(2,max);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                list.add(
                        new Product(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getDouble(4),
                                rs.getInt(5)
                        ));
            }
        }
        catch(Exception e)
        {
            throw new ProductException(e.getMessage());
        }
        return list;
    }
    }

