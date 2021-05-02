INSERT INTO client (courriel, date_naissance, nom, prenom, telephone) VALUES ('client1@example.com','1996-05-04','Beji','Mohammed','55444666'),
                                                                             ('client2@example.com','1992-02-08','Tounsi','Ahmed','22888999');

INSERT INTO met (nom, prix) VALUES ('Couscous',25),
                                   ('Spaghetti',15),
                                   ('Chocolat',5),
                                   ('Glace',6),
                                   ('Kaftaji',4),
                                   ('Sauce',5),
                                   ('Salade',8);


INSERT INTO plat (nom) VALUES ('Couscous'),
                              ('Spaghetti');


INSERT INTO entree (nom) VALUES ('Kaftaji'),
                                ('Sauce'),
                                ('Salade');

INSERT INTO dessert (nom) VALUES ('Chocolat'),
                                 ('Glace');

INSERT INTO desk (nb_couvert,type,supplement) VALUES (5,'Petit terrase',7),
                                                     (9,'Grand terrase',10);

INSERT INTO ticket (addition,date,nb_couvert,client_id,table_numero) VALUES (75,'2020-05-07 13:08:02',5,1,1),
                                                                            (50,'2020-05-08 13:08:02',9,2,2);