-- -- Square data --
-- INSERT INTO square(square_name,  start_square, square_type)
-- VALUES ('Cantiere', true, 'buildingsitesquare');
-- INSERT INTO square(square_name,  start_square, square_type,  resource_type)
-- VALUES ('Cane', false, 'resourcesquare', 'cane');
-- INSERT INTO square(square_name,  start_square, square_type)
-- VALUES ('Sorpresa', false, 'surprisesquare');
-- INSERT INTO square(square_name,  start_square, square_type, resource_type)
-- VALUES ('Prateria', false, 'resourcesquare', 'dente');
-- INSERT INTO square(square_name,  start_square, square_type, resource_type)
-- VALUES ('Foresta', false, 'resourcesquare', 'bacca');
-- INSERT INTO square(square_name,  start_square, square_type, resource_type)
-- VALUES ('Artigiano', false, 'resourcesquare', 'anfora');
-- INSERT INTO square(square_name,  start_square, square_type, resource_type)
-- VALUES ('Cava', false,'resourcesquare', 'freccia');
-- INSERT INTO square(square_name,  start_square, square_type)
-- VALUES ('Battaglia', false, 'regularsquare');
-- INSERT INTO square(square_name,  start_square, square_type, resource_type)
-- VALUES ('Fiume', false, 'resourcesquare', 'pesce');
-- INSERT INTO square(square_name,  start_square, square_type)
-- VALUES ('Mercato', false, 'regularsquare');
--
-- UPDATE square SET next_square_name='Cane' WHERE square_name='Cantiere';
-- UPDATE square SET next_square_name='Cantiere' WHERE square_name='Mercato';
-- UPDATE square SET next_square_name='Sorpresa' WHERE square_name='Cane';
-- UPDATE square SET next_square_name='Prateria' WHERE square_name='Sorpresa';
-- UPDATE square SET next_square_name='Foresta' WHERE square_name='Prateria';
-- UPDATE square SET next_square_name='Artigiano' WHERE square_name='Foresta';
-- UPDATE square SET next_square_name='Cava' WHERE square_name='Artigiano';
-- UPDATE square SET next_square_name='Battaglia' WHERE square_name='Cava';
-- UPDATE square SET next_square_name='Fiume' WHERE square_name='Battaglia';
-- UPDATE square SET next_square_name='Mercato' WHERE square_name='Fiume';

-- Square data --
INSERT INTO square(square_name,  start_square, square_type, mode)
VALUES ('Cantiere', true, 'buildingsitesquare', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, mode)
VALUES ('Cantiere', true, 'buildingsitesquare', 'verde');
INSERT INTO square(square_name,  start_square, square_type,  resource_type, mode)
VALUES ('Cane', false, 'resourcesquare', 'cane', 'rossa');
INSERT INTO square(square_name,  start_square, square_type,  resource_type, mode)
VALUES ('Cane', false, 'resourcesquare', 'cane', 'verde');
INSERT INTO square(square_name,  start_square, square_type, mode)
VALUES ('Sorpresa', false, 'surprisesquare', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Prateria', false, 'resourcesquare', 'dente', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Prateria', false, 'resourcesquare', 'dente', 'verde');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Foresta', false, 'resourcesquare', 'bacca', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Foresta', false, 'resourcesquare', 'bacca', 'verde');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Artigiano', false, 'resourcesquare', 'anfora', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Artigiano', false, 'resourcesquare', 'anfora', 'verde');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Cava', false,'resourcesquare', 'freccia', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Cava', false,'resourcesquare', 'freccia', 'verde');
INSERT INTO square(square_name,  start_square, square_type, mode)
VALUES ('Battaglia', false, 'regularsquare', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Fiume', false, 'resourcesquare', 'pesce', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, resource_type, mode)
VALUES ('Fiume', false, 'resourcesquare', 'pesce', 'verde');
INSERT INTO square(square_name,  start_square, square_type, mode)
VALUES ('Mercato', false, 'regularsquare', 'rossa');
INSERT INTO square(square_name,  start_square, square_type, mode)
VALUES ('Mercato', false, 'regularsquare', 'verde');

UPDATE square SET next_square_name='Cane', next_square_mode='rossa'  WHERE square_name='Cantiere' AND mode = 'rossa';
UPDATE square SET next_square_name='Cantiere', next_square_mode='rossa' WHERE square_name='Mercato' AND mode = 'rossa';
UPDATE square SET next_square_name='Sorpresa', next_square_mode='rossa' WHERE square_name='Cane' AND mode = 'rossa';
UPDATE square SET next_square_name='Prateria', next_square_mode='rossa' WHERE square_name='Sorpresa' AND mode = 'rossa';
UPDATE square SET next_square_name='Foresta', next_square_mode='rossa'  WHERE square_name='Prateria' AND mode = 'rossa';
UPDATE square SET next_square_name='Artigiano',next_square_mode='rossa' WHERE square_name='Foresta' AND mode = 'rossa';
UPDATE square SET next_square_name='Cava', next_square_mode='rossa' WHERE square_name='Artigiano' AND mode = 'rossa';
UPDATE square SET next_square_name='Battaglia', next_square_mode='rossa' WHERE square_name='Cava' AND mode = 'rossa';
UPDATE square SET next_square_name='Fiume', next_square_mode='rossa' WHERE square_name='Battaglia' AND mode = 'rossa';
UPDATE square SET next_square_name='Mercato', next_square_mode='rossa' WHERE square_name='Fiume' AND mode = 'rossa';

UPDATE square SET next_square_name='Cane', next_square_mode='verde' WHERE square_name='Cantiere' AND mode = 'verde';
UPDATE square SET next_square_name='Cantiere', next_square_mode='verde' WHERE square_name='Mercato' AND mode = 'verde';
UPDATE square SET next_square_name='Prateria', next_square_mode='verde' WHERE square_name='Cane' AND mode = 'verde';
UPDATE square SET next_square_name='Foresta', next_square_mode='verde' WHERE square_name='Prateria' AND mode = 'verde';
UPDATE square SET next_square_name='Artigiano', next_square_mode='verde' WHERE square_name='Foresta' AND mode = 'verde';
UPDATE square SET next_square_name='Cava', next_square_mode='verde' WHERE square_name='Artigiano' AND mode = 'verde';
UPDATE square SET next_square_name='Fiume', next_square_mode='verde' WHERE square_name='Cava' AND mode = 'verde';
UPDATE square SET next_square_name='Mercato', next_square_mode='verde' WHERE square_name='Fiume' AND mode = 'verde';


-- -- Marker data --
-- INSERT INTO marker(marker_name, square_name)
-- VALUES ('Jono', 'Cantiere');
-- INSERT INTO marker(marker_name, square_name)
-- VALUES ('Jada', 'Cantiere');
-- INSERT INTO marker(marker_name, square_name)
-- VALUES ('Martin', 'Cantiere');
-- INSERT INTO marker(marker_name, square_name)
-- VALUES ('Guff', 'Cantiere');

-- Marker data --
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (1, 'Jono', 'Cantiere', 'rossa');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (2, 'Jada', 'Cantiere', 'rossa');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (3, 'Martin', 'Cantiere', 'rossa');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (4, 'Guff', 'Cantiere', 'rossa');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (5, 'Jono', 'Cantiere', 'verde');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (6, 'Jada', 'Cantiere', 'verde');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (7, 'Martin', 'Cantiere', 'verde');
INSERT INTO marker(id, marker_name, square_name, mode)
VALUES (8, 'Guff', 'Cantiere', 'verde');


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
INSERT INTO tokenforest(id, die_value, state, type)
VALUES (1, 1, false,'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, type)
VALUES (2, 2, false, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, type)
VALUES (3, 3, false, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, type)
VALUES (4,4, false, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, type)
VALUES (5, 5, false, 'diefacetokenforest');
INSERT INTO tokenforest(id, die_value, state, type)
VALUES (6, 6, false, 'diefacetokenforest');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (7, 'Cantiere', false, 'squaretokenforest', 'rossa');
INSERT INTO tokenforest(id,square_value, state, type, mode)
VALUES (8,'Mercato', false, 'squaretokenforest','rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (9, 'Cane', false, 'squaretokenforest','rossa');
INSERT INTO tokenforest(id,square_value, state, type, mode)
VALUES (10, 'Sorpresa', false, 'squaretokenforest','rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (11, 'Battaglia', false, 'squaretokenforest', 'rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (12, 'Artigiano', false, 'squaretokenforest','rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (13, 'Cava', false, 'squaretokenforest', 'rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (14, 'Foresta', false, 'squaretokenforest', 'rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (15, 'Prateria', false, 'squaretokenforest', 'rossa');
INSERT INTO tokenforest(id, square_value, state,  type, mode)
VALUES (16, 'Fiume', false, 'squaretokenforest', 'rossa');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (17, 'Cantiere', false, 'squaretokenforest', 'verde');
INSERT INTO tokenforest(id,square_value, state, type, mode)
VALUES (18,'Mercato', false, 'squaretokenforest','verde');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (19, 'Cane', false, 'squaretokenforest','verde');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (20, 'Artigiano', false, 'squaretokenforest','verde');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (21, 'Cava', false, 'squaretokenforest', 'verde');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (22, 'Foresta', false, 'squaretokenforest', 'verde');
INSERT INTO tokenforest(id, square_value, state, type, mode)
VALUES (23, 'Prateria', false, 'squaretokenforest', 'verde');
INSERT INTO tokenforest(id, square_value, state,  type, mode)
VALUES (24, 'Fiume', false, 'squaretokenforest', 'verde');

--Hut tokens data--
INSERT INTO huttoken(id_token, state)
VALUES (1, true);
INSERT INTO huttoken(id_token, state)
VALUES (2, true);
INSERT INTO huttoken(id_token, state)
VALUES (3, true);
INSERT INTO huttoken(id_token, state)
VALUES (4, false);
INSERT INTO huttoken(id_token, state)
VALUES (5, false);
INSERT INTO huttoken(id_token, state)
VALUES (6, false);
INSERT INTO huttoken(id_token, state)
VALUES (7, false);
INSERT INTO huttoken(id_token, state)
VALUES (8, false);
INSERT INTO huttoken(id_token, state)
VALUES (9, false);
INSERT INTO huttoken(id_token, state)
VALUES (10, false);
INSERT INTO huttoken(id_token, state)
VALUES (11, false);
INSERT INTO huttoken(id_token, state)
VALUES (12, false);
INSERT INTO huttoken(id_token, state)
VALUES (13, false);
INSERT INTO huttoken(id_token, state)
VALUES (14, false);
INSERT INTO huttoken(id_token, state)
VALUES (15, false);

--Resource data--
INSERT INTO resource(resource_type)
VALUES ('pesce');
INSERT INTO resource(resource_type)
VALUES ('dente');
INSERT INTO resource(resource_type)
VALUES ('bacca');
INSERT INTO resource(resource_type)
VALUES ('anfora');
INSERT INTO resource(resource_type)
VALUES ('freccia');

-- -- huttoken_resource data--
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (1, 'dente', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (1, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (2, 'dente', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (2, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (2, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (3, 'pesce', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (3, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (3, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (4, 'dente', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (4, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (4, 'pesce', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (5, 'dente', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (5, 'freccia', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (5, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (6, 'freccia', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (6, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (7, 'freccia', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (7, 'pesce', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (8, 'freccia', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (8, 'anfora', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (9, 'dente', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (9, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (10, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (10, 'bacca', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (11, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (11, 'freccia', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (12, 'pesce', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (12, 'bacca', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (13, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (13, 'bacca', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (14, 'dente', 2);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (14, 'bacca', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (15, 'anfora', 1);
INSERT INTO huttoken_resource(id_token, resource_name, quantity)
VALUES (15, 'pesce', 2);
