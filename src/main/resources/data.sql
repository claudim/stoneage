-- Square data --
INSERT INTO square(square_name,  start_square)
VALUES ('cantiere', true);
INSERT INTO square(square_name,  start_square)
VALUES ('mercato', false);
INSERT INTO square(square_name,  start_square)
VALUES ('cane', false);
INSERT INTO square(square_name,  start_square)
VALUES ('sorpresa', false);
INSERT INTO square(square_name,  start_square)
VALUES ('campodibattaglia', false);
INSERT INTO square(square_name,  start_square)
VALUES ('artigiano', false);
INSERT INTO square(square_name,  start_square)
VALUES ('cava', false);
INSERT INTO square(square_name,  start_square)
VALUES ('foresta', false);
INSERT INTO square(square_name,  start_square)
VALUES ('prateria', false);
INSERT INTO square(square_name,  start_square)
VALUES ('fiume', false);

UPDATE square SET next_square_name='cane' WHERE square_name='cantiere';
UPDATE square SET next_square_name='cantiere' WHERE square_name='mercato';
UPDATE square SET next_square_name='sorpresa' WHERE square_name='cane';
UPDATE square SET next_square_name='prateria' WHERE square_name='sorpresa';
UPDATE square SET next_square_name='foresta' WHERE square_name='prateria';
UPDATE square SET next_square_name='artigiano' WHERE square_name='foresta';
UPDATE square SET next_square_name='cava' WHERE square_name='artigiano';
UPDATE square SET next_square_name='campodibattaglia' WHERE square_name='cava';
UPDATE square SET next_square_name='fiume' WHERE square_name='campodibattaglia';
UPDATE square SET next_square_name='mercato' WHERE square_name='fiume';


-- Marker data --
INSERT INTO marker(marker_name, square_name)
VALUES ('Jono', 'cantiere');
INSERT INTO marker(marker_name, square_name)
VALUES ('Jada', 'cantiere');
INSERT INTO marker(marker_name, square_name)
VALUES ('Martin', 'cantiere');
INSERT INTO marker(marker_name, square_name)
VALUES ('Guff', 'cantiere');


-- -- NearTo data --
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('cantiere', 'cane');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('cane', 'sorpresa');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('sorpresa', 'prateria');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('prateria', 'foresta');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('foresta', 'artigiano');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('artigiano', 'cava');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('cava', 'campodibattaglia');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('campodibattaglia', 'fiume');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('fiume', 'mercato');
-- INSERT INTO nearto(square_name_from, square_name_to)
-- VALUES ('mercato', 'cantiere');


-- TokenForest data --
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (1, '1', false, 1, 'diefacetokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (2, '2', false, 2, 'diefacetokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (3, '3', false, 3, 'diefacetokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (4,'4', false, 4, 'diefacetokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (5, '5', false, 5, 'diefacetokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (6, '6', false, 6, 'diefacetokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (7, 'cantiere', false, 7, 'squaretokenforest');
INSERT INTO tokenforest(id,value, state, position, type)
VALUES (8,'mercato', false, 8, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (9, 'cane', false, 9, 'squaretokenforest');
INSERT INTO tokenforest(id,value, state, position, type)
VALUES (10, 'sorpresa', false, 10, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (11, 'campodibattaglia', false, 11, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (12, 'artigiano', false, 12, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (13, 'cava', false, 13, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (14, 'foresta', false, 14, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (15, 'prateria', false, 15, 'squaretokenforest');
INSERT INTO tokenforest(id, value, state, position, type)
VALUES (16, 'fiume', false, 16, 'squaretokenforest');