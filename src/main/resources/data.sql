INSERT INTO user VALUES (null, 'abc', 1, 'abc');

INSERT INTO home VALUES (null, null, null);

INSERT INTO cooler VALUES (null, 0, 1);

INSERT INTO heater VALUES (null, 0, 1);

UPDATE home SET cooler_id = 1, heater_id = 1 WHERE id = 1;

INSERT INTO room VALUES (null, 0, 'Living room', 23, 1);
INSERT INTO room VALUES (null, 0, 'Dining room', 23, 1);
INSERT INTO room VALUES (null, 0, 'Bathroom', 23, 1);
INSERT INTO room VALUES (null, 0, 'Kitchen', 23, 1);