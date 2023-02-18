insert into product (id, marking, type, is_on_discount, description, price)
VALUES (1, 'Flour, water and salt', 'BAKE', true, 'Bread', 10.5),
       (2, 'Flour, water, raisin, sugar and salt', 'BAKE', false, 'Bun', 5.5),
       (3, 'Ingredients: water, fat, proteins, lactose (milk sugar) and minerals (salts)', 'MILK', false, 'Milk',
        34.22),
       (4, 'Protein, some fat, carbohydrates, water, bifidobacteria, vitamins and minerals', 'MILK', false, 'Yogurt',
        56.26);

insert into discount_card (id, discount)
VALUES (1, 2);