package com.clevertec_task.repository;

import com.clevertec_task.cards.Card;
import com.clevertec_task.cards.CardImpl;
import com.clevertec_task.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO implements DAO<Card> {

    private final JDBCConnection jdbcConnection;
    private String table = "discount_card";

    public CardDAO(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @Override
    public void save(Card card) {
        String sql = " INSERT INTO " + table + " (id, discount) values (?,?)";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            statement.setInt(1, card.getId());
            statement.setBigDecimal(2, card.getDiscount());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Card selectById(int id) {
        String sql = "SELECT * FROM discount_card WHERE id = ?";
        Card card = null;
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    card = new CardImpl();
                    card.setId(resultSet.getInt(1));
                    card.setDiscount(resultSet.getBigDecimal(2));
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void update(Card card) {
        String sql = "UPDATE " + table + " SET discount = ?  WHERE id = ?";
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setBigDecimal(1, card.getDiscount());
            statement.setInt(2, card.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Card card) {
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try (Connection connection = jdbcConnection.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, card.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
