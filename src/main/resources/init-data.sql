CREATE TABLE user_account (
  userid VARCHAR(100) NOT NULL PRIMARY KEY,
  email VARCHAR(100) NOT NULL ,
  username VARCHAR(20) NOT NULL,
  dob DATE,
  phone INTEGER,
  signup_date DATE,
  account_status VARCHAR(20)
);

CREATE TABLE user_credentials (
  userid VARCHAR(100) NOT NULL REFERENCES user_account(userid) ON DELETE RESTRICT,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(255) NOT NULL,
  username VARCHAR(20) NOT NULL
);

CREATE TABLE user_follow (
  userid VARCHAR(100) NOT NULL REFERENCES user_account(userid) ON DELETE RESTRICT,
  email VARCHAR(100) NOT NULL,
  followers jsonb,
  following jsonb
);
