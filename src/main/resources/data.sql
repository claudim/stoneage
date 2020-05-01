-- Square data --
INSERT INTO square(square_name,  start_square, square_type)
VALUES ('Cantiere', true, 'buildingsitesquare');
INSERT INTO square(square_name,  start_square, square_type)
VALUES ('Cane', false, 'buildingsitesquare');
INSERT INTO square(square_name,  start_square, square_type)
VALUES ('Sorpresa', false, 'buildingsitesquare');
INSERT INTO square(square_name,  start_square, square_type, resource_type)
VALUES ('Prateria', false, 'resourcesquare', 'dente');
INSERT INTO square(square_name,  start_square, square_type, resource_type)
VALUES ('Foresta', false, 'resourcesquare', 'bacca');
INSERT INTO square(square_name,  start_square, square_type, resource_type)
VALUES ('Artigiano', false, 'resourcesquare', 'anfora');
INSERT INTO square(square_name,  start_square, square_type, resource_type)
VALUES ('Cava', false,'resourcesquare', 'freccia');
INSERT INTO square(square_name,  start_square, square_type)
VALUES ('Battaglia', false, 'buildingsitesquare');
INSERT INTO square(square_name,  start_square, square_type, resource_type)
VALUES ('Fiume', false, 'resourcesquare', 'pesce');
INSERT INTO square(square_name,  start_square, square_type)
VALUES ('Mercato', false, 'buildingsitesquare');

UPDATE square SET next_square_name='Cane' WHERE square_name='Cantiere';
UPDATE square SET next_square_name='Cantiere' WHERE square_name='Mercato';
UPDATE square SET next_square_name='Sorpresa' WHERE square_name='Cane';
UPDATE square SET next_square_name='Prateria' WHERE square_name='Sorpresa';
UPDATE square SET next_square_name='Foresta' WHERE square_name='Prateria';
UPDATE square SET next_square_name='Artigiano' WHERE square_name='Foresta';
UPDATE square SET next_square_name='Cava' WHERE square_name='Artigiano';
UPDATE square SET next_square_name='Battaglia' WHERE square_name='Cava';
UPDATE square SET next_square_name='Fiume' WHERE square_name='Battaglia';
UPDATE square SET next_square_name='Mercato' WHERE square_name='Fiume';


-- Marker data --
INSERT INTO marker(marker_name, square_name)
VALUES ('Jono', 'Cantiere');
INSERT INTO marker(marker_name, square_name)
VALUES ('Jada', 'Cantiere');
INSERT INTO marker(marker_name, square_name)
VALUES ('Martin', 'Cantiere');
INSERT INTO marker(marker_name, square_name)
VALUES ('Guff', 'Cantiere');


-- -- NearTo data --
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Cantiere', 'Cane');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Cane', 'Sorpresa');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Sorpresa', 'Prateria');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Prateria', 'Foresta');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Foresta', 'Artigiano');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Artigiano', 'Cava');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Cava', 'Battaglia');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Battaglia', 'Fiume');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Fiume', 'Mercato');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('Mercato', 'Cantiere');


-- TokenForest data --
INSERT INTO tokenforest(id, die_value, state, position, type)
VALUES (1, 1, false, 1, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, position, type)
VALUES (2, 2, false, 2, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, position, type)
VALUES (3, 3, false, 3, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, position, type)
VALUES (4,4, false, 4, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, position, type)
VALUES (5, 5, false, 5, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, position, type)
VALUES (6, 6, false, 6, 'diefacetokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (7, 'Cantiere', false, 7, 'squaretokenforest');
INSERT INTO tokenforest(id,square_value, state, position, type)
VALUES (8,'Mercato', false, 8, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (9, 'Cane', false, 9, 'squaretokenforest');
INSERT INTO tokenforest(id,square_value, state, position, type)
VALUES (10, 'Sorpresa', false, 10, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (11, 'Battaglia', false, 11, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (12, 'Artigiano', false, 12, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (13, 'Cava', false, 13, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (14, 'Foresta', false, 14, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (15, 'Prateria', false, 15, 'squaretokenforest');
INSERT INTO tokenforest(id, square_value, state, position, type)
VALUES (16, 'Fiume', false, 16, 'squaretokenforest');

--Hut tokens data--
INSERT INTO huttoken(id, state)
VALUES (1, false);
INSERT INTO huttoken(id, state)
VALUES (2, false);
INSERT INTO huttoken(id, state)
VALUES (3, false);
INSERT INTO huttoken(id, state)
VALUES (4, false);
INSERT INTO huttoken(id, state)
VALUES (5, false);
INSERT INTO huttoken(id, state)
VALUES (6, false);
INSERT INTO huttoken(id, state)
VALUES (7, false);
INSERT INTO huttoken(id, state)
VALUES (8, false);
INSERT INTO huttoken(id, state)
VALUES (9, false);
INSERT INTO huttoken(id, state)
VALUES (10, false);
INSERT INTO huttoken(id, state)
VALUES (11, false);
INSERT INTO huttoken(id, state)
VALUES (12, false);
INSERT INTO huttoken(id, state)
VALUES (13, false);
INSERT INTO huttoken(id, state)
VALUES (14, false);
INSERT INTO huttoken(id, state)
VALUES (15, false);

--Resource data--
INSERT INTO resource(resource_type)
VALUES ('Pesce');
INSERT INTO resource(resource_type)
VALUES ('Dente');
INSERT INTO resource(resource_type)
VALUES ('Bacca');
INSERT INTO resource(resource_type)
VALUES ('Anfora');
INSERT INTO resource(resource_type)
VALUES ('Freccia');

-- -- huttoken_resource data--
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (1, 'dente', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (1, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (2, 'dente', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (2, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (2, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (3, 'pesce', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (3, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (3, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (4, 'dente', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (4, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (4, 'pesce', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (5, 'dente', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (5, 'freccia', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (5, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (6, 'freccia', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (6, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (7, 'freccia', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (7, 'pesce', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (8, 'freccia', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (8, 'anfora', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (9, 'dente', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (9, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (10, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (10, 'bacca', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (11, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (11, 'freccia', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (12, 'pesce', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (12, 'bacca', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (13, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (13, 'bacca', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (14, 'dente', 2);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (14, 'bacca', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (15, 'anfora', 1);
-- INSERT INTO huttoken_resource(id_token, resource_name, quantity)
-- VALUES (15, 'pesce', 2);
