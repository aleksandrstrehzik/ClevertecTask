package com.clevertec_task;

import com.clevertec_task.service.impl.checks.SimpleCheck;
import com.clevertec_task.repository.factories.CardFactory;
import com.clevertec_task.repository.factories.ProductFactory;
import com.clevertec_task.service.interfaces.stores.Store;
import com.clevertec_task.service.impl.store.StoreImpl;
import com.clevertec_task.service.utils.CheckPrinterAndWriter;

import java.nio.file.Path;

public class CheckRunner {
    public static void main(String[] args) {
        Path order = Path.of("src", "main", "resources", "check", "order.txt");
        Path printCheck = Path.of("src", "main", "resources", "check", "check.txt");
        String[] stringOrder = CheckPrinterAndWriter.getOrder(order);
        Store store = new StoreImpl("kdsk", new ProductFactory(), new SimpleCheck(), new CardFactory());
        store.createCheck(stringOrder, printCheck, true);
    }
}
