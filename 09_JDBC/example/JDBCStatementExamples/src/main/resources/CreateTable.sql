CREATE TABLE "Student" (
  id        SERIAL                NOT NULL PRIMARY KEY,
  firstName CHARACTER VARYING(20) NOT NULL UNIQUE,
  lastName  CHARACTER VARYING(20) NOT NULL
)