INSERT INTO utmn.UserEvent (event_type, event_time) VALUES ('login', NOW());
INSERT INTO utmn.UserEvent (event_type, event_time) VALUES ('login', NOW() - interval '1 hour');
INSERT INTO utmn.UserEvent (event_type, event_time) VALUES ('logout', NOW() - interval '30 minutes');
INSERT INTO utmn.UserEvent (event_type, event_time) VALUES ('click', NOW() - interval '10 minutes');
INSERT INTO utmn.UserEvent (event_type, event_time) VALUES ('click', NOW() - interval '5 minutes');
