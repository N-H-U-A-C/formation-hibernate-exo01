
-- Client
insert into client (clientid, firstname, lastName, email) values (nextval('client_seq'), 'Paco', 'Rabanne', 'designerdudimanche@gmail.com');
insert into client (clientid, firstname, lastName, email) values (nextval('client_seq'), 'Toto', 'Tata', 'toto.tata@gmail.com');

-- ElectronicItem
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'PC portable', 'Un PC portable', 749.99, 5, '2020-06-06') returning itemid) insert into electronicitem (itemid, batterycapacity) select itemid, 3600 from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Lampe torche', 'Une lampe torche', 13.99, 10, '2020-06-06') returning itemid) insert into electronicitem (itemid, batterycapacity) select itemid, 3600 from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Pile', 'Une pile électrique', 2.99, 40, '2020-06-06') returning itemid) insert into electronicitem (itemid, batterycapacity) select itemid, 7200 from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Pile rechargeable', 'Une pile électrique rechargeable', 4.49, 40, '2020-06-06') returning itemid) insert into electronicitem (itemid, batterycapacity) select itemid, 7200 from insert1;

-- FashionItem
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Jeans bleu', 'Un jeans bleu pour homme', 59.99, 12, '2020-06-06') returning itemid) insert into fashionitem (itemid, clothingcategory, size) select itemid, 0, 'W28' from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'T-shirt gris chiné', 'Un t-shirt gris chiné pour homme', 12.49, 8, '2020-06-06') returning itemid) insert into fashionitem (itemid, clothingcategory, size) select itemid, 0, 'M' from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Robe bleue', 'Une robe bleue d''été', 49.99, 6, '2020-06-06') returning itemid) insert into fashionitem (itemid, clothingcategory, size) select itemid, 1, 'M' from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'T-shirt blanc', 'Un t-shirt blanc pour enfant', 7.49, 4, '2020-06-06') returning itemid) insert into fashionitem (itemid, clothingcategory, size) select itemid, 2, '10 ans' from insert1;

-- FoodItem
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Banane', 'Une banane', 1.25, 10, '2020-06-06') returning itemid) insert into fooditem (itemid, expirationdate) select itemid, '2024-10-11' from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Pomme', 'Une pomme', 1.5, 10, '2020-06-06') returning itemid) insert into fooditem (itemid, expirationdate) select itemid, '2025-06-30' from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Harissa', 'De la harissa', 0.75, 10, '2020-06-06') returning itemid) insert into fooditem (itemid, expirationdate) select itemid, '2025-06-30' from insert1;
with insert1 as (insert into item (itemid, label, description, price, stockquantity, restockingdate) values (nextval('item_seq'), 'Kebab surgelé', 'Un kebab surgelé', 11, 6, '2020-06-06') returning itemid) insert into fooditem (itemid, expirationdate) select itemid, '2025-10-25' from insert1;

-- Sale
insert into sale (saleid, date, status, clientid) values (nextval('sale_seq'), '2020-05-02 15:59:59-07', 0, 1);
insert into sale (saleid, date, status, clientid) values (nextval('sale_seq'), '2020-07-02 15:59:59-07', 1, 1);
insert into sale (saleid, date, status, clientid) values (nextval('sale_seq'), '2023-02-02 15:59:59-07', 2, 1);
insert into sale (saleid, date, status, clientid) values (nextval('sale_seq'), '2021-02-02 15:59:59-07', 0, 51);
insert into sale (saleid, date, status, clientid) values (nextval('sale_seq'), '2021-02-02 15:59:59-07', 0, 51);
insert into sale (saleid, date, status, clientid) values (nextval('sale_seq'), '2021-02-02 15:59:59-07', 0, 51);

-- SaleLine
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 1, 1);
insert into saleLine (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 2, 51, 1);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 4, 101, 51);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 4, 151, 51);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 201, 101);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 251, 101);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 301, 151);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 351, 151);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 401, 201);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 451, 201);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 501, 251);
insert into saleline (salelineid, quantity, itemid, saleid) values (nextval('saleline_seq'), 1, 551, 251);
