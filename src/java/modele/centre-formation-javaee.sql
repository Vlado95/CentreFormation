-- Changer le delimiteur d'instruction pour declarer la procedure
DELIMITER $$

DROP SCHEMA IF EXISTS produits$$
CREATE SCHEMA IF NOT EXISTS produits DEFAULT CHARACTER SET utf8$$
USE produits$$

CREATE TABLE IF NOT EXISTS produit (
  no_produit int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(30) NOT NULL,
  prix decimal(8,2) NOT NULL,
  PRIMARY KEY (no_produit),
  UNIQUE KEY UC_nom (nom)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
$$

CREATE TABLE IF NOT EXISTS personne (
  id_personne int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(30) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
$$

--
-- Rafraichissement de la base
--
DROP PROCEDURE IF EXISTS produits.refresh
$$

CREATE PROCEDURE produits.refresh() BEGIN
  -- Vider les tables
  SET FOREIGN_KEY_CHECKS = 0;
  TRUNCATE personne;
  TRUNCATE produit;
  SET FOREIGN_KEY_CHECKS = 0;
  -- Inserer les donnees (la aussi dans l'ordre ad hoc pour les contraintes)
  START TRANSACTION;
  INSERT INTO produit (no_produit, nom, prix) VALUES
  (1, 'Le sacre du printemps', '10.00'),
  (2, 'Köln concert', '12.00'),
  (3, 'Les temps modernes', '18.00'),
  (4, 'Hard times', '15.00'),
  (5, 'Bilbo le hobbit', '10.00'),
  (6, 'Princesse Mononoké', '16.50'),
  (7, 'Madagascar', '17.50'),
  (8, 'Symphonie fantastique', '12.50'),
  (9, 'Kind of blue', '14.50'),
  (10, 'solal', '6.80'),
  (11, 'Guerre et paix', '8.60');

  INSERT INTO personne(id_personne, login, password) VALUES
  (1, 'tintin', 'milou'),
  (2, 'haddock', 'mille sabords');
  COMMIT;
END
$$

CALL produits.refresh()
$$