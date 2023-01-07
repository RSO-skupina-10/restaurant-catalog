INSERT INTO operatingHours (mondayStart, mondayEnd, tuesdayStart, tuesdayEnd, wednesdayStart, wednesdayEnd, thursdayStart, thursdayEnd, fridayStart, fridayEnd, saturdayStart, saturdayEnd, sundayStart, sundayEnd) VALUES ('8:00', '16:00', '8:00', '16:00', '8:00', '16:00', '8:00', '16:00', '8:00', '16:00', '12:00', '20:00', '12:00','20:00');

INSERT INTO operatingHours (mondayStart, mondayEnd, tuesdayStart, tuesdayEnd, wednesdayStart, wednesdayEnd, thursdayStart, thursdayEnd, fridayStart, fridayEnd, saturdayStart, saturdayEnd, sundayStart, sundayEnd) VALUES ('7:00', '22:00', '6:00', '16:00', '9:00', '13:00', '5:00', '11:00', '8:00', '20:00', '12:00', '20:00', '12:00','20:00');


INSERT INTO restaurant (name, description, lat, lng, operatingHoursId) VALUES ('Pizzeria Foculus', 'We have the best pizza in town',46.047852,14.502360, 1);
INSERT INTO restaurant (name, description, lat, lng, operatingHoursId) VALUES ('Imperia Mexicana', 'If you want mexican we are the place for you',46.063591,14.547510, 2);
INSERT INTO restaurant (name, description, lat, lng, operatingHoursId) VALUES ('Slovenska hiša', 'Traditional slovenian food',46.05285272284078,14.504043159309788, 1);


INSERT INTO meal (name, price, restaurantId) VALUES ('Pizza Margherita', 10.00, 1);
INSERT INTO meal (name, price, restaurantId) VALUES ('Pizza capricciosa', 11.00, 1);
INSERT INTO meal (name, price, restaurantId) VALUES ('Hawaiian pizza', 22.00, 1);
INSERT INTO meal (name, price, restaurantId) VALUES ('Four cheeses', 12.00, 1);

INSERT INTO  ingredients VALUES (1, 'mozzarella cheese');
INSERT INTO  ingredients VALUES (1, 'tomato sauce');
INSERT INTO  ingredients VALUES (1, 'basil');

INSERT INTO  ingredients VALUES (2, 'ham');
INSERT INTO  ingredients VALUES (2, 'mushrooms');
INSERT INTO  ingredients VALUES (2, 'artichokes');

INSERT INTO  ingredients VALUES (3, 'pineapple');
INSERT INTO  ingredients VALUES (3, 'ham');

INSERT INTO  ingredients VALUES (4, 'mozzarella');
INSERT INTO  ingredients VALUES (4, 'gorgonzola');
INSERT INTO  ingredients VALUES (4, 'parmesan');
INSERT INTO  ingredients VALUES (4, 'fontina');


INSERT INTO meal (name, price, restaurantId) VALUES ('Mozzarella sticks', 8.20, 2);
INSERT INTO meal (name, price, restaurantId) VALUES ('Taquitos', 9.0, 2);
INSERT INTO meal (name, price, restaurantId) VALUES ('Beef Burrito', 10.0, 2);
INSERT INTO meal (name, price, restaurantId) VALUES ('Onion rings', 5.10, 2);

INSERT INTO  ingredients VALUES (5, 'Mozzarella');
INSERT INTO  ingredients VALUES (5, 'Salsa');

INSERT INTO  ingredients VALUES (6, 'Chicken');
INSERT INTO  ingredients VALUES (6, 'Tortillas');
INSERT INTO  ingredients VALUES (6, 'Cream');

INSERT INTO  ingredients VALUES (7, 'Beef');
INSERT INTO  ingredients VALUES (7, 'Tortillas');
INSERT INTO  ingredients VALUES (7, 'Tomato sauce');
INSERT INTO  ingredients VALUES (7, 'Beans');

INSERT INTO  ingredients VALUES (8, 'Onion');
INSERT INTO  ingredients VALUES (8, 'Red salsa');
INSERT INTO  ingredients VALUES (8, 'Fries');

INSERT INTO meal (name, price, restaurantId) VALUES ('Štruklji', 4.0, 3);
INSERT INTO meal (name, price, restaurantId) VALUES ('Žganci', 8.00, 3);
INSERT INTO meal (name, price, restaurantId) VALUES ('Potica', 5.00, 3);
INSERT INTO meal (name, price, restaurantId) VALUES ('Carniolan sausage', 10.00, 3);

INSERT INTO  ingredients VALUES (9, 'Leavened dough');
INSERT INTO  ingredients VALUES (9, 'Cottage cheese');

INSERT INTO  ingredients VALUES (10, 'Buckwheat flour');
INSERT INTO  ingredients VALUES (10, 'Crackles');

INSERT INTO  ingredients VALUES (11, 'Leavened dough');
INSERT INTO  ingredients VALUES (11, 'Poppy seeds');
INSERT INTO  ingredients VALUES (11, 'Walnuts');

INSERT INTO  ingredients VALUES (12, 'Pork mean');
INSERT INTO  ingredients VALUES (12, 'Bacon');
