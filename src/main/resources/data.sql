-- Square data --
INSERT INTO square(squarename, startsquare)
VALUES ('cantiere', true);
INSERT INTO square(squarename, startsquare)
VALUES ('mercato', false);
INSERT INTO square(squarename, startsquare)
VALUES ('cane', false);
INSERT INTO square(squarename, startsquare)
VALUES ('sorpresa', false);
INSERT INTO square(squarename, startsquare)
VALUES ('campodibattaglia', false);
INSERT INTO square(squarename, startsquare)
VALUES ('artigiano', false);
INSERT INTO square(squarename, startsquare)
VALUES ('cava', false);
INSERT INTO square(squarename, startsquare)
VALUES ('foresta', false);
INSERT INTO square(squarename, startsquare)
VALUES ('prateria', false);
INSERT INTO square(squarename, startsquare)
VALUES ('fiume', false);


-- Marker data --
INSERT INTO marker(markername, squarename)
VALUES ('Jono', 'cantiere');
INSERT INTO marker(markername, squarename)
VALUES ('Jada', 'cantiere');
INSERT INTO marker(markername, squarename)
VALUES ('Martin', 'cantiere');
INSERT INTO marker(markername, squarename)
VALUES ('Guff', 'cantiere');


-- NearTo data --
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('cantiere', 'cane');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('cane', 'sorpresa');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('sorpresa', 'prateria');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('prateria', 'foresta');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('foresta', 'artigiano');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('artigiano', 'cava');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('cava', 'campodibattaglia');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('campodibattaglia', 'fiume');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('fiume', 'mercato');
INSERT INTO nearto(namesquarefrom, namesquareto)
VALUES ('mercato', 'cantiere');


-- TokenForest data --
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('1', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('2', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('3', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('4', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('5', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('6', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('cantiere', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('mercato', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('cane', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('sorpresa', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('campodibattaglia', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('artigiano', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('cava', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('foresta', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('prateria', false);
INSERT INTO tokenforest(tokenforestvalue, tokenforeststate)
VALUES ('fiume', false);