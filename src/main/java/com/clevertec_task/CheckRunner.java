package com.clevertec_task;

import com.clevertec_task.checks.SimpleCheck;
import com.clevertec_task.factories.CardFactory;
import com.clevertec_task.factories.ProductFactory;
import com.clevertec_task.store.Store;
import com.clevertec_task.store.StoreImpl;
import com.clevertec_task.util.CheckPrinterAndWriter;

import java.nio.file.Path;

public class CheckRunner {
    public static void main(String[] args) {
        Path order = Path.of("src", "main", "resources", "order.txt");
        Path printCheck = Path.of("src", "main", "resources", "check.txt");
        String[] stringOrder = CheckPrinterAndWriter.getOrder(order);
        Store store = new StoreImpl("kdsk", new ProductFactory(), new SimpleCheck(), new CardFactory());
        store.createCheck(args, printCheck, true);
    }
}
