insert into SEC_GROUP 
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, PARENT_ID) 
values ('f8a3ec46-1c2d-8261-b74a-762bf650502c', '2016-07-26 17:19:39', 'admin', 1, '2016-07-26 17:19:39', null, null, null, 'Finance', '0fa2b1a5-1d68-4d69-9fbd-dff348347f93');

insert into SEC_GROUP 
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, PARENT_ID) 
values ('14d040fb-9e27-8adb-c715-499cd5e95e44', '2016-07-26 17:19:52', 'admin', 1, '2016-07-26 17:19:52', null, null, null, 'Accounting', '0fa2b1a5-1d68-4d69-9fbd-dff348347f93');

insert into SEC_USER 
(ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO, ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, IP_MASK) 
values ('f65615e1-14b1-ffa9-b8bd-217df0997501', '2016-07-26 17:20:27', 'admin', 6, '2016-07-26 17:20:53', 'admin', null, null, 'doe', 'doe', '5bb286aec41a8589c6c05061e5810c9df67fa0b2', 'John Doe', 'John', 'Doe', null, null, null, 'en', null, null, true, false, '0fa2b1a5-1d68-4d69-9fbd-dff348347f93', null);
