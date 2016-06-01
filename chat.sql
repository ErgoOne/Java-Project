#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Room
#------------------------------------------------------------

CREATE TABLE Room(
        Nom       Varchar (25) NOT NULL ,
        Descrptif Varchar (120) ,
        isRprive  tinyint(1),
        PRIMARY KEY (Nom )
);


#------------------------------------------------------------
# Table: Users
#------------------------------------------------------------

CREATE TABLE Users(
        Pseudo    Varchar (25) NOT NULL ,
        Nom       Varchar (25) NOT NULL ,
        Email     Varchar (25) NOT NULL ,
        Telephone Float NOT NULL ,
        statut    Enum ("on","off","abs")  NOT NULL ,
        PRIMARY KEY (Pseudo )
);


#------------------------------------------------------------
# Table: être admin
#------------------------------------------------------------

CREATE TABLE etre_admin(
        Pseudo Varchar (25) NOT NULL ,
        Nom    Varchar (25) NOT NULL ,
        PRIMARY KEY (Pseudo ,Nom )
);


#------------------------------------------------------------
# Table: acceder
#------------------------------------------------------------

CREATE TABLE acceder(
        type_droit Enum ("r","none","rw","admin")  NOT NULL  ,
        Pseudo     Varchar (25) NOT NULL ,
        Nom        Varchar (25) NOT NULL ,
        PRIMARY KEY (Pseudo ,Nom )
);


#------------------------------------------------------------
# Table: ajouter
#------------------------------------------------------------

CREATE TABLE ajouter(
        PseudoAdd Int ,
        Pseudo    Varchar (25) NOT NULL ,
        Nom       Varchar (25) NOT NULL ,
        PRIMARY KEY (Pseudo ,Nom )
);


#------------------------------------------------------------
# Table: supprimer
#------------------------------------------------------------

CREATE TABLE supprimer(
        PseudoDel Int ,
        Pseudo    Varchar (25) NOT NULL ,
        Nom       Varchar (25) NOT NULL ,
        PRIMARY KEY (Pseudo ,Nom )
);


#------------------------------------------------------------
# Table: ecrit
#------------------------------------------------------------

CREATE TABLE ecrit(
        msg         Varchar (25) NOT NULL ,
        date_cre DATETIME NOT NULL ,
        Pseudo      Varchar (25) NOT NULL ,
        Nom         Varchar (25) NOT NULL ,
        PRIMARY KEY (Pseudo ,Nom,date_cre )
);



#------------------------------------------------------------
# Table: CreerRoom
#------------------------------------------------------------

CREATE TABLE CreerRoom(
        Pseudo Varchar (25) NOT NULL ,
        Nom    Varchar (25) NOT NULL ,
        PRIMARY KEY (Pseudo ,Nom )
);

ALTER TABLE etre_admin ADD CONSTRAINT FK_etre_admin_Pseudo FOREIGN KEY (Pseudo) REFERENCES Users(Pseudo);
ALTER TABLE etre_admin ADD CONSTRAINT FK_etre_admin_Nom FOREIGN KEY (Nom) REFERENCES Room(Nom);
ALTER TABLE acceder ADD CONSTRAINT FK_acceder_Pseudo FOREIGN KEY (Pseudo) REFERENCES Users(Pseudo);
ALTER TABLE acceder ADD CONSTRAINT FK_acceder_Nom FOREIGN KEY (Nom) REFERENCES Room(Nom);
ALTER TABLE ajouter ADD CONSTRAINT FK_ajouter_Pseudo FOREIGN KEY (Pseudo) REFERENCES Users(Pseudo);
ALTER TABLE ajouter ADD CONSTRAINT FK_ajouter_Nom FOREIGN KEY (Nom) REFERENCES Room(Nom);
ALTER TABLE supprimer ADD CONSTRAINT FK_supprimer_Pseudo FOREIGN KEY (Pseudo) REFERENCES Users(Pseudo);
ALTER TABLE supprimer ADD CONSTRAINT FK_supprimer_Nom FOREIGN KEY (Nom) REFERENCES Room(Nom);
ALTER TABLE ecrit ADD CONSTRAINT FK_ecrir_Pseudo FOREIGN KEY (Pseudo) REFERENCES Users(Pseudo);
ALTER TABLE ecrit ADD CONSTRAINT FK_ecrir_Nom FOREIGN KEY (Nom) REFERENCES Room(Nom);
ALTER TABLE CreerRoom ADD CONSTRAINT FK_CreerRoom_Pseudo FOREIGN KEY (Pseudo) REFERENCES Users(Pseudo);
ALTER TABLE CreerRoom ADD CONSTRAINT FK_CreerRoom_Nom FOREIGN KEY (Nom) REFERENCES Room(Nom);
