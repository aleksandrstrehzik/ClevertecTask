package com.clevertec_task.store;

import com.clevertec_task.checks.Check;
import com.clevertec_task.checks.SimpleCheck;
import com.clevertec_task.factories.CardFactory;
import com.clevertec_task.factories.ProductFactory;
import com.clevertec_task.util.CheckPrinterAndWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StoreImplTest {

    private String[] d = {"1-8", "2-5", "3-9", "44-4", "Card-1234"};
    private String[] a = {"wed"};
    private Store store;
    private Check check;
    private Path path = Path.of("src", "test", "resources", "orderTest.txt");

    @BeforeEach
    void init() throws IOException {
        path.toFile().createNewFile();
        check = new SimpleCheck();
        store = new StoreImpl("IGu", new ProductFactory(), check, new CardFactory());
    }

    @Test
    void successSaveInTxt() {
        store.createCheck(d, path, false);
        String[] order = CheckPrinterAndWriter.getOrder(path);
        assertTrue(order.length != 0);
    }

    @Test
    void unSuccessSaveInTxt() {
        store.createCheck(a, path, false);
        String[] order = CheckPrinterAndWriter.getOrder(path);
        assertArrayEquals(order, new String[0]);
    }

    @Test
    void cartIsNotEmpty() {
        store.putProductsInCartByDirector(d);
        assertFalse(check.getShoppingСart().isEmpty());
    }

    @Test
    void cartIsEmpty() {
        store.putProductsInCartByDirector(a);
        assertTrue(check.getShoppingСart().isEmpty());
    }

    @AfterEach
    void end() {
        path.toFile().delete();
    }

}