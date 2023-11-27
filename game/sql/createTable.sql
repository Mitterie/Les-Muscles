--Pour \i sur windows : mettre 2 // entre les repertoires et mettre le chemin absolu--
--\i C://Users//pipod//REVIEW_MUSCLES//game//sql//createTable.Sql--

DROP TABLE IF EXISTS QUESTIONS_MUSCLES;
DROP TABLE IF EXISTS SCORE_PLAYER_MUSCLES;

CREATE TABLE QUESTIONS_MUSCLES(
    label text,
    choix text ,
    reponse text
);

CREATE TABLE SCORE_PLAYER_MUSCLES(
    nom text,
    score int
);

INSERT INTO QUESTIONS_MUSCLES VALUES
('Comment se nomme la bricoleuse ? (EP 1 : La bricoleuse)','Marina;Francoise;Luigi;Ginette','2'),
('Dans quoi minet se coince le doigt ? (EP 1 : La bricoleuse)','Une porte;Une tapette a souris;Une prise electrique;Un robinet','4'),
('Ou partent les muscles quand Rene reste seul a la maison pendant un weekend ? (EP 2 : Le gourou)','A la plage;A la montagne;A la campagne;Dans la cave a Minet','3'),
('Quel est le nouveau nom de Rene en tant que sage ? (EP 2 : Le gourou)','Woulala;Wouchichi;Wouaiaitoi;Wouicava','1'),
('Quels cadeaux ont ete offert aux muscles par la voleuse ? (EP 3 : La voleuse)','Une montre;Un saxophone;Un M16;Un costume de luxe','1;2');

