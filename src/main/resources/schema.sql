DROP TABLE IF EXISTS Marker;
DROP TABLE IF EXISTS NearTo;
DROP TABLE IF EXISTS Square;
DROP TABLE IF EXISTS TokenForest;

CREATE TABLE Square
(
    square_name      VARCHAR(30) NOT NULL UNIQUE,
    start_square     boolean,
    next_square_name VARCHAR(30),
    PRIMARY KEY (square_name),
    FOREIGN KEY (next_square_name) REFERENCES Square (square_name) ON UPDATE CASCADE
);

CREATE TABLE Marker
(
    marker_name VARCHAR(20) NOT NULL UNIQUE,
    square_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (marker_name),
    FOREIGN KEY (square_name) REFERENCES Square (square_name) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TokenForest
(
    token_forest_id    INT AUTO_INCREMENT NOT NULL,
    token_forest_value VARCHAR(30)        NOT NULL UNIQUE,
    token_forest_state boolean,
    PRIMARY KEY (token_forest_id)
);

--CREATE TABLE NearTo
--(
--     square_name_from VARCHAR(30) NOT NULL,
--     square_name_to   VARCHAR(30) NOT NULL,
--     PRIMARY KEY (square_name_from,square_name_to),
--     FOREIGN KEY (square_name_from) REFERENCES Square (square_name) ON UPDATE CASCADE ON DELETE CASCADE,
--     FOREIGN KEY (square_name_to) REFERENCES Square (square_name) ON UPDATE CASCADE ON DELETE CASCADE
-- );