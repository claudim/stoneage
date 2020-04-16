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
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('1', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('2', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('3', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('4', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('5', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('6', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('cantiere', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('mercato', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('cane', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('sorpresa', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('campodibattaglia', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('artigiano', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('cava', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('foresta', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('prateria', false);
INSERT INTO tokenforest(token_forest_value, token_forest_state)
VALUES ('fiume', false);