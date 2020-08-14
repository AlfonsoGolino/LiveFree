drop schema if exists LiveFree; 
create schema LiveFree;
use LiveFree;

Create table Utente(
Nome varchar(20) not null,
Cognome varchar(20) not null,
CodiceFiscale char(16) primary key, 
username varchar(20) not null,
pasword varchar(10) not null
);

Create table Autorita(
Nome varchar(20) not null,
Cognome varchar(20) not null, 
Matricola char(16) primary key, 
username varchar(20) not null,
pasword varchar(10) not null
);

Create table Segnalazione(
IDSegnalazione varchar(20) primary key,
Indirizzo varchar(20) not null,
Foto varchar(20)not null,
DroneInviato boolean,
matricola char(16),
codiceFiscale char(16),
foreign key(matricola)
	references Autorita(Matricola)
	on update cascade
	on delete restrict,
foreign key(codiceFiscale)
	references Utente(CodiceFiscale)
    on update cascade
	on delete restrict
);
