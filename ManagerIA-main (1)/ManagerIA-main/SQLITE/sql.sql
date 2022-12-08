DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS TEAMS;
DROP TABLE IF EXISTS USERTEAMS;

BEGIN TRANSACTION;

CREATE TABLE "USERS" (
	"user_id" INTEGER NOT NULL UNIQUE,
	"first_name"	TEXT NOT NULL,
	"last_name"	TEXT NOT NULL,
	"dob"	INTEGER NOT NULL,
	"email"	TEXT NOT NULL,
	"role"	TEXT NOT NULL,
	"team" TEXT NOT NULL,
	PRIMARY KEY("user_id" AUTOINCREMENT)
);

CREATE TABLE "TEAMS" (
	"team_id"	INTEGER NOT NULL UNIQUE,
	"team_name"	TEXT NOT NULL UNIQUE,
	"team_task"	TEXT,
	"team_deadline"	INTEGER,
	PRIMARY KEY("team_id" AUTOINCREMENT)
);

CREATE TABLE "USERTEAMS" (
	"user_id"	INTEGER NOT NULL,
	"team_id"	INTEGER NOT NULL,
	PRIMARY KEY("user_id","team_id")
);

COMMIT;

--DATABASE.CLOSE();

INSERT INTO USERS 
VALUES (1, 'John', 'Smith', 1990, 'johnsmith@gmail.com', 'Manager');

SELECT * FROM USERS;

COMMIT;
