package com.clevertec_task;

import com.clevertec_task.repository.dao.impl.ProductDAO;
import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.repository.factories.CardFactory;
import com.clevertec_task.repository.factories.ProductFactory;
import com.clevertec_task.repository.utils.JDBCConnection;
import com.clevertec_task.service.impl.checks.SimpleCheck;
import com.clevertec_task.service.impl.store.StoreImpl;
import com.clevertec_task.service.interfaces.stores.Store;
import com.clevertec_task.service.utils.CheckPrinterAndWriter;

import java.nio.file.Path;
import java.sql.SQLException;

public class CheckRunner {
    public static void main(String[] args) throws SQLException {
        Path order = Path.of("src", "main", "resources", "check", "order.txt");
        Path printCheck = Path.of("src", "main", "resources", "check", "check.txt");
        String[] stringOrder = CheckPrinterAndWriter.getOrder(order);
        Store store = new StoreImpl(new ProductFactory(), new SimpleCheck(), new CardFactory(), new ProductDAO(new JDBCConnection()));
        store.createCheck(stringOrder, printCheck, true);
    }
}
