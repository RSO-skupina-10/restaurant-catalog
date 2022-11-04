INSERT INTO operatingHours (mondayStart, mondayEnd, tuesdayStart, tuesdayEnd, wednesdayStart, wednesdayEnd, thursdayStart, thursdayEnd, fridayStart, fridayEnd, saturdayStart, saturdayEnd, sundayStart, sundayEnd) VALUES ('8:00', '16:00', '8:00', '16:00', '8:00', '16:00', '8:00', '16:00', '8:00', '16:00', '12:00', '20:00', '12:00','20:00');

INSERT INTO operatingHours (mondayStart, mondayEnd, tuesdayStart, tuesdayEnd, wednesdayStart, wednesdayEnd, thursdayStart, thursdayEnd, fridayStart, fridayEnd, saturdayStart, saturdayEnd, sundayStart, sundayEnd) VALUES ('7:00', '22:00', '6:00', '16:00', '9:00', '13:00', '5:00', '11:00', '8:00', '20:00', '12:00', '20:00', '12:00','20:00');


INSERT INTO restaurant (name, operatingHoursId) VALUES ('First pizza restaurant', 1);

INSERT INTO meal (name, price, restaurantId) VALUES ('Pizza Margherita', 10.00, 1);
INSERT INTO meal (name, price, restaurantId) VALUES ('Pizza capricciosa', 11.00, 1);
INSERT INTO meal (name, price, restaurantId) VALUES ('Hawaiian pizza', 22.00, 1);
INSERT INTO meal (name, price, restaurantId) VALUES ('Hawaiian pizza', 12.00, 1);

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

INSERT INTO restaurant (name, operatingHoursId) VALUES ('Slovenian restaurant', 2);

INSERT INTO meal (name, price, restaurantId) VALUES ('Štruklji', 4.00, 2);
INSERT INTO meal (name, price, restaurantId) VALUES ('Žganci', 8.00, 2);
INSERT INTO meal (name, price, restaurantId) VALUES ('Potica', 5.00, 2);
INSERT INTO meal (name, price, restaurantId) VALUES ('Carniolan sausage', 10.00, 2);

INSERT INTO  ingredients VALUES (5, 'leavened dough');
INSERT INTO  ingredients VALUES (5, 'cottage cheese');

INSERT INTO  ingredients VALUES (6, 'buckwheat flour');
INSERT INTO  ingredients VALUES (6, 'crackles');

INSERT INTO  ingredients VALUES (7, 'leavened dough');
INSERT INTO  ingredients VALUES (7, 'poppy seeds');
INSERT INTO  ingredients VALUES (7, 'walnuts');

INSERT INTO  ingredients VALUES (8, 'pork meat');
INSERT INTO  ingredients VALUES (8, 'bacon');