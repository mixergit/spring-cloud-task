/* If migrating from 1.1.0.M1 to 1.1.0.M2 you do not need to add
the ERROR_MESSAGE column. */
alter table task_execution add ERROR_MESSAGE varchar2(2500);
alter table task_execution add EXTERNAL_EXECUTION_ID varchar2(255);

