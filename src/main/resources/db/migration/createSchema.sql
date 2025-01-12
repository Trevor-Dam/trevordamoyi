
CREATE TABLE Community (
                           CommunityID SERIAL UNIQUE NOT NULL,
                           Area VARCHAR(100) NOT NULL,
                           CommunityScore INT NOT NULL,
                           AverageInfractions FLOAT(53) NOT NULL DEFAULT(0),
                           PRIMARY KEY(CommunityID)
);

CREATE TABLE Scores (
                        ScoreID SERIAL UNIQUE NOT NULL,
                        UserID INT NOT NULL,
                        ScoreDate DATE NOT NULL,
                        Score INT NOT NULL,
                        NoOfInfractions INT NOT NULL DEFAULT(0),
                        FOREIGN KEY(UserID) REFERENCES "users",
                        PRIMARY KEY(ScoreID)
);

ALTER TABLE "users"
ALTER COLUMN "userid" SERIAL;


ALTER TABLE "users"
DROP COLUMN "area";

ALTER TABLE "users"
ADD "CommunityID" INT NOT NULL;

ALTER TABLE "users"
ADD FOREIGN KEY ("CommunityID") REFERENCES Community;