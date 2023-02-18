package com.clevertec_task.repository.dao.impl;

import com.clevertec_task.repository.dao.interfaces.DAO;
import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.repository.entity.product.Type;
import com.clevertec_task.repository.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO implements DAO<Product> {

    private final JDBCConnection jdbcConnection;
    private String table = "product";

    public ProductDAO(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @Override
    public void save(Product product) {
        String sql = " INSERT INTO " + table + " (id, marking, type, is_on_discount, description, price) values (?,?,?,?,?,?)";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getMarking());
            statement.setString(3, product.getType().toString());
            statement.setBoolean(4, product.IsOnDiscount());
            statement.setString(5, product.getDescription());
            statement.setBigDecimal(6, product.getPrice());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product selectById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        Product product = null;
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setMarking(resultSet.getString(2));
                    product.setType(Type.valueOf(resultSet.getString(3)));
                    product.setOnDiscount(resultSet.getBoolean(4));
                    product.setDescription(resultSet.getString(5));
                    product.setPrice(resultSet.getBigDecimal(6));
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE " + table + " SET marking = ?, type = ?, " +
                "is_on_discount = ? , description = ?, price = ?  WHERE id = ?";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setString(1, product.getMarking());
            statement.setString(2, product.getType().toString());
            statement.setBoolean(3, product.IsOnDiscount());
            statement.setString(4, product.getDescription());
            statement.setBigDecimal(5, product.getPrice());
            statement.setInt(6, product.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try (Connection connection = jdbcConnection.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
