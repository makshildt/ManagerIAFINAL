DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS TEAMS;
DROP TABLE IF EXISTS USERTEAMS;

BEGIN TRANSACTION;

CREATE TABLE "USERS" (
    "user_id"    INTEGER NOT NULL,
    "first_name"    TEXT NOT NULL,
    "last_name"    TEXT NOT NULL,
    "dob"    TEXT NOT NULL,
    "email"    TEXT NOT NULL,
    "role"    TEXT NOT NULL,
    "team"    TEXT NOT NULL,
    PRIMARY KEY("ID" AUTOINCREMENT)
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

--DATABASE.CLOSE();

INSERT VALUES INTO USERS (user_id, first_name, last_name, dob, email, role, team) VALUES (1, 'John', 'Smith', '1990', 'JS@GMAIL.COM', 'ADMIN', 'TEAM1');

INSERT VALUES INTO TEAMS (team_id, team_name, team_task, team_deadline) VALUES (1, 'Marketing', 'Create a marketing plan', '2020-01-01');

