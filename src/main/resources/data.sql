-- Square data --
INSERT INTO square(square_name,  start_square)
VALUES ('Cantiere', true);
INSERT INTO square(square_name,  start_square)
VALUES ('Cane', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Sorpresa', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Prateria', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Foresta', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Artigiano', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Cava', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Battaglia', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Fiume', false);
INSERT INTO square(square_name,  start_square)
VALUES ('Mercato', false);

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