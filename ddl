;             
CREATE USER IF NOT EXISTS "1" SALT '58489dd7565d6dc6' HASH 'd441d412691100daef14adbdd8353c1105d4153ba10a661c5685d1145d04c7a3' ADMIN;          
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_C4E12574_1BBB_4589_B351_97DC9A50E83F" START WITH 25 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_210DD636_8DFE_49E8_9BD3_7EE473B1CB9C" START WITH 12 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."HIBERNATE_SEQUENCE" START WITH 1;   
CREATE MEMORY TABLE "PUBLIC"."ALBUM"(
    "ID" BIGINT NOT NULL,
    "NAME" VARCHAR(255),
    "YEAR_RELEASED" INTEGER NOT NULL,
    "BAND_ID" BIGINT
);   
ALTER TABLE "PUBLIC"."ALBUM" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");        
-- 9 +/- SELECT COUNT(*) FROM PUBLIC.ALBUM;   
INSERT INTO "PUBLIC"."ALBUM" VALUES
(1, 'Geography', 2018, 1),
(2, 'What Kinda Music', 2020, 1),
(3, 'Shes in Control', 2004, 2),
(4, 'Fancy Footwork', 2007, 2),
(5, 'Business Casual', 2010, 2),
(6, 'Whatever', 2014, 2),
(7, 'Walking on a Dream', 2008, 3),
(8, 'Ice on the Dune', 2013, 3),
(9, 'Two Vines', 2016, 3);         
CREATE MEMORY TABLE "PUBLIC"."BAND"(
    "ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_210DD636_8DFE_49E8_9BD3_7EE473B1CB9C" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_210DD636_8DFE_49E8_9BD3_7EE473B1CB9C",
    "NAME" VARCHAR(255),
    "YEAR_FORMED" INTEGER NOT NULL
);             
ALTER TABLE "PUBLIC"."BAND" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");         
-- 11 +/- SELECT COUNT(*) FROM PUBLIC.BAND;   
INSERT INTO "PUBLIC"."BAND" VALUES
(1, 'Tom Misch', 2012),
(2, 'Chromeo', 2002),
(3, 'Empire of the Sun', 2007),
(4, 'BreakBot', 1995),
(5, 'Parcels', 2014),
(6, 'Daft Punk', 1993),
(7, 'Jack Broadbent', 2015),
(8, 'Kraftwerk', 1970),
(9, 'Holy Ghost', 2011),
(10, 'Queen', 1970),
(11, '1337h4x0r', 1984);  
CREATE MEMORY TABLE "PUBLIC"."MUSICIAN"(
    "ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_C4E12574_1BBB_4589_B351_97DC9A50E83F" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_C4E12574_1BBB_4589_B351_97DC9A50E83F",
    "DATE_OF_BIRTH" DATE,
    "NAME" VARCHAR(255),
    "BAND_ID" BIGINT
);            
ALTER TABLE "PUBLIC"."MUSICIAN" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_6" PRIMARY KEY("ID");     
-- 24 +/- SELECT COUNT(*) FROM PUBLIC.MUSICIAN;               
INSERT INTO "PUBLIC"."MUSICIAN" VALUES
(1, DATE '1995-06-25', 'Tom Misch', 1),
(2, DATE '1978-06-07', 'David Macklovitch', 2),
(3, DATE '1979-07-31', 'Patrick Gemayel', 2),
(4, DATE '1979-12-13', 'Luke Steele', 3),
(5, DATE '1978-05-06', 'Nick Littlemore', 3),
(6, DATE '1981-10-05', 'Thibaut Jean-Marie Michel Berland', 4),
(7, DATE '1993-03-12', 'Louie Swain', 5),
(8, DATE '1995-06-13', 'Patrick Hetherington', 5),
(9, DATE '1998-02-12', 'Noah Hill', 5),
(10, DATE '1999-08-14', 'Anatole Serret', 5),
(11, DATE '1994-09-20', 'Jules Crommelin', 5),
(12, DATE '1974-08-02', 'Guy-Manuel de Homem-Christo', 6),
(13, DATE '1976-09-20', 'Jules Crommelin', 6),
(14, DATE '1988-06-15', 'Jack Broadbent', 7),
(15, DATE '1981-03-11', 'Florian Schneider', 8),
(16, DATE '1980-07-15', STRINGDECODE('Ralf H\u00fctter'), 8),
(17, DATE '1988-01-19', STRINGDECODE('Wolfgang Fl\u00fcr'), 8),
(18, DATE '1986-06-16', 'Fritz Hilpert', 8),
(19, DATE '1989-05-16', 'Nick Millhiser', 9),
(20, DATE '1986-01-29', 'Alex Frankel', 9),
(21, DATE '1986-01-29', 'Freddie Mercury', 10),
(22, DATE '1986-01-29', 'John Deacon', 10),
(23, DATE '1986-01-29', 'Alex Frankel', 10),
(24, DATE '1984-01-01', 'Zlatko Miletic', 11);          
CREATE MEMORY TABLE "PUBLIC"."SONG"(
    "ID" BIGINT NOT NULL,
    "GENRE" VARCHAR(255),
    "LENGTH" INTEGER NOT NULL,
    "NAME" VARCHAR(255),
    "SINGER" VARCHAR(255),
    "WRITER" VARCHAR(255),
    "YEAR_RELEASED" INTEGER NOT NULL,
    "ALBUM_ID" BIGINT
);
ALTER TABLE "PUBLIC"."SONG" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("ID");         
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.SONG;    
INSERT INTO "PUBLIC"."SONG" VALUES
(1, 'Pop', 200, 'My Song', 'Ivica', 'Marica', 2018, 3),
(2, 'Rock', 300, 'Najmilijoj', 'Singer', 'Sweet', 2019, 3),
(3, 'Funk', 200, 'Before Paris', 'Tom Misch', 'Tom Misch', 2018, 1),
(4, 'Funk', 300, 'Lost in Paris', 'Tom Misch', 'Tom Misch', 2019, 1),
(5, 'Funk', 300, 'South of the River', 'Tom Misch', 'Tom Misch', 2019, 1),
(6, 'Funk', 200, 'What Kinda Music', 'Tom Misch', 'Tom Misch', 2018, 2),
(7, 'Funk', 300, 'Festival', 'Tom Misch', 'Tom Misch', 2019, 2),
(8, 'Funk', 300, 'Night rider', 'Tom Misch', 'Tom Misch', 2019, 2);            
ALTER TABLE "PUBLIC"."SONG" ADD CONSTRAINT "PUBLIC"."FKRCJMK41YQJ3PL3IYII40NIAB0" FOREIGN KEY("ALBUM_ID") REFERENCES "PUBLIC"."ALBUM"("ID") NOCHECK;          
ALTER TABLE "PUBLIC"."MUSICIAN" ADD CONSTRAINT "PUBLIC"."FK1TAOIOM0WKMLHQPDH9R2CUN2N" FOREIGN KEY("BAND_ID") REFERENCES "PUBLIC"."BAND"("ID") NOCHECK;        
ALTER TABLE "PUBLIC"."ALBUM" ADD CONSTRAINT "PUBLIC"."FK84W6MUGH985E3OUF2QCQN9V5O" FOREIGN KEY("BAND_ID") REFERENCES "PUBLIC"."BAND"("ID") NOCHECK;           