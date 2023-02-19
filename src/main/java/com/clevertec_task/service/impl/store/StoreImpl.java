package com.clevertec_task.service.impl.store;

import com.clevertec_task.repository.entity.cards.Card;
import com.clevertec_task.repository.entity.product.Product;
import com.clevertec_task.service.exception.NullInput;
import com.clevertec_task.service.interfaces.checks.Check;
import com.clevertec_task.service.impl.checks.CheckWithDiscount;
import com.clevertec_task.repository.dao.impl.ProductDAO;
import com.clevertec_task.repository.utils.JDBCConnection;
import com.clevertec_task.service.interfaces.stores.Store;
import com.clevertec_task.service.utils.CheckUtil;
import com.clevertec_task.repository.factories.CardFactory;
import com.clevertec_task.repository.factories.ProductFactory;
import com.clevertec_task.service.utils.CheckPrinterAndWriter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class StoreImpl implements Store {
    private String title;
    private ProductFactory factory;
    private Check check;
    private CardFactory cardFactory;

    public StoreImpl(String title, ProductFactory factory, Check check, CardFactory cardFactory) {
        this.title = title;
        this.factory = factory;
        this.check = check;
        this.cardFactory = cardFactory;
    }

    @Override
    public void createCheck(String[] d, Path path, boolean UseDatabase) {
        if (d.length != 0) {
            if (UseDatabase) {
                Map<Product, Integer> shoppingСart = putProductsInCartFromDatabase(d);
                saveInTxt(d, shoppingСart, path);
                printInConsole(d, shoppingСart);
            } else {
                Map<Product, Integer> shoppingСart = putProductsInCartByDirector(d);
                saveInTxt(d, shoppingСart, path);
                printInConsole(d, shoppingСart);
            }
        } else throw new NullInput();
    }

    @Override
    public void saveInTxt(String[] d, Map<Product, Integer> shoppingСart, Path path) {
        if (!shoppingСart.isEmpty()) {
            StringBuilder builder = getCompletedCheck(d, shoppingСart);
            CheckPrinterAndWriter.printCheck(builder, path);
        }
    }

    @Override
    public void printInConsole(String[] d, Map<Product, Integer> shoppingСart) {
        System.out.println(getCompletedCheck(d, shoppingСart));
    }

    @Override
    public Map<Product, Integer> putProductsInCartByDirector(String[] d) {
        int[] idArray = CheckUtil.getIdArray(d);
        int[] numArray = CheckUtil.getNumArray(d);
        Map<Product, Integer> shoppingСart = check.getShoppingСart();
        for (int i = 0; i < idArray.length; i++) {
            Product product = factory.getProduct(idArray[i]);
            if (product != null) {
                shoppingСart.put(product, numArray[i]);
            }
        }
        return shoppingСart;
    }

    @Override
    public Map<Product, Integer> putProductsInCartFromDatabase(String[] d) {
        int[] idArray = CheckUtil.getIdArray(d);
        int[] numArray = CheckUtil.getNumArray(d);
        Map<Product, Integer> shoppingСart = check.getShoppingСart();
        for (int i = 0; i < idArray.length; i++) {
            ProductDAO productDAO = new ProductDAO(new JDBCConnection());
            Product product = productDAO.selectById(idArray[i]);
            if (product != null) {
                shoppingСart.put(product, numArray[i]);
            }
        }
        return shoppingСart;
    }

    private StringBuilder getCompletedCheck(String[] d, Map<Product, Integer> shoppingСart) {
        StringBuilder builder = new StringBuilder();
        StringBuilder append = builder.append("                 CASH RECEIPT")
                .append("\n")
                .append("                 " + title)
                .append("\n")
                .append("                 +203920392039023")
                .append("\n")
                .append("Date                              " + LocalDate.now())
                .append("\n")
                .append("Time                              " + LocalTime.now())
                .append("\n")
                .append("_____________________________________________________")
                .append("\n")
                .append("№   Description           Price     Total")
                .append("\n");
        for (Product product : shoppingСart.keySet()) {
            Integer value = shoppingСart.get(product);
            if (product.IsOnDiscount() && shoppingСart.get(product) >= 5) {
                BigDecimal nominationCost = new CheckWithDiscount(check).nominationCost(product, value).setScale(2, RoundingMode.CEILING);
                builder.append(value + "   " + product.getDescription() + "             "
                                + product.getPrice() + "          " + nominationCost)
                        .append("\n")
                        .append("             promotional item discount " + check.nominationCost(product, value).subtract(nominationCost).setScale(2, RoundingMode.CEILING))
                        .append("\n");
            } else builder.append(value + "   " + product.getDescription() + "             "
                            + product.getPrice() + "          " + check.nominationCost(product, value).setScale(2, RoundingMode.CEILING))
                    .append("\n");
        }
        builder.append("______________________________________________________")
                .append("\n")
                .append("Total cost                                   " + check.generalСost().setScale(2, RoundingMode.CEILING))
                .append("\n");
        if (CheckUtil.IsCardPresent(d)) {
            Card card = cardFactory.getCard(CheckUtil.getDiscountCard(d));
            builder.append("Discount amount                            " + check.discountAmount(card, check.generalСost()).setScale(2, RoundingMode.CEILING))
                    .append("\n")
                    .append("Discount price                             " + check.costWithDiscount(card, check.generalСost()).setScale(2, RoundingMode.FLOOR));
        }
        return builder;
    }
}
