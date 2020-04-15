DROP TABLE IF EXISTS Marker;
DROP TABLE IF EXISTS NearTo;
DROP TABLE IF EXISTS Square;
DROP TABLE IF EXISTS TokenForest;

CREATE TABLE Square
(
    SquareName  VARCHAR(30) NOT NULL UNIQUE,
    StartSquare boolean,
    PRIMARY KEY (SquareName)
);

CREATE TABLE Marker
(
    MarkerName VARCHAR(20) NOT NULL UNIQUE,
    SquareName VARCHAR(30) NOT NULL,
    PRIMARY KEY (MarkerName),
    FOREIGN KEY (SquareName) REFERENCES Square (squarename) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TokenForest
(
    TokenForestId    INT AUTO_INCREMENT NOT NULL,
    TokenForestValue VARCHAR(30)        NOT NULL UNIQUE,
    TokenForestState boolean,
    PRIMARY KEY (TokenForestId)
);

CREATE TABLE NearTo
(
    NameSquareFrom VARCHAR(30) NOT NULL,
    NameSquareTo   VARCHAR(30) NOT NULL,
    PRIMARY KEY (NameSquareFrom, NameSquareTo),
    FOREIGN KEY (NameSquareFrom) REFERENCES Square (squarename) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (NameSquareTo) REFERENCES Square (squarename) ON UPDATE CASCADE ON DELETE CASCADE
);