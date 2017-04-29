CREATE TABLE `gems` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `carat` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `semiprecious` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `carat` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO gems(id, name, carat) values(1,  'DIAMOND', 12);
INSERT INTO gems(id, name, carat) values(2,  'RUBY', 17);
INSERT INTO gems(id, name, carat) values(3,  'AQUAMARINE', 33);
INSERT INTO gems(id,  name, carat) values(4, 'SAPPHIRE', 11);
INSERT INTO gems(id,  name, carat) values(5,  'DIAMOND', 33);
INSERT INTO gems(id,  name, carat) values(6, 'OPAL', 36);
INSERT INTO semiprecious(id,  name, carat) values(1,  'QUARTZ', 15);
INSERT INTO semiprecious(id,  name, carat) values(2, 'QUARTZ', 21);
INSERT INTO semiprecious(id,  name, carat) values(3, 'LAPISLAZULI', 40);
INSERT INTO semiprecious(id,  name, carat) values(4, 'ONYX', 10);
INSERT INTO semstonesiprecious(id,  name, carat) values(5,  'AGATE', 5);
INSERT INTO semiprecious(id,  name, carat) values(6, 'AGATE', 9);
INSERT INTO semiprecious(id,  name, carat) values(7,  'AGATE', 8);
INSERT INTO semiprecious(id,  name, carat) values(8,  'AMBER', 2);
INSERT INTO semiprecious(id,  name, carat) values(9, 'JASPER', 1);