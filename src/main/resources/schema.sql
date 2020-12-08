DROP TABLE IF EXISTS TASK;

CREATE TABLE TASK
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    TASK        VARCHAR(250) NOT NULL,
    DESCRIPTION VARCHAR(1000) NOT NULL,
    TEST_INPUT  VARCHAR(250)  NOT NULL,
    TEST_OUTPUT VARCHAR(250)  NOT NULL
);