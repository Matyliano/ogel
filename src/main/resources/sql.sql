create table machine2x2Time AS
Select `datetime_from`,`datetime_to` from production where machine_name = '2x2 brick mould'  AND variable_name = 'SCRAP';

create table machine3x2Time AS
Select `datetime_from`,`datetime_to` from production where machine_name = '3x2 brick mould'  AND variable_name = 'SCRAP';

create table machine4x2Time AS
Select `datetime_from`,`datetime_to` from production where machine_name = '4x2 brick mould'  AND variable_name = 'SCRAP';

# create table machine2x2Production AS SELECT machine2x2Time.datetime_from, machine2x2Time.datetime_to, production.value AS CASE WHEN variable_name = 'SCRAP' THEN 'scrap' WHEN variable_name = 'PRODUCTION' THEN 'production' WHEN variable_name = 'CORE TEMPERATURE' THEN 'core_temperature' END
#     from machine2x2Time LEFT JOIN production ON machine2x2Time.datetime_from = production.datetime_from where variable_name = 'SCRAP' AND machine_name = '2x2 brick mould';

# IMPORTANT NOTE - putting the data in new tables in proper order - if I had some more time, the queries below would be done in less steps and in much more elegant way.

create table machine2x2TS AS SELECT machine2x2Time.datetime_from, machine2x2Time.datetime_to, production.value AS 'scrap'
                                     from machine2x2Time LEFT JOIN production ON machine2x2Time.datetime_from = production.datetime_from where variable_name = 'SCRAP' AND machine_name = '2x2 brick mould' ;


create table machine2x2TSP AS SELECT machine2x2TS.datetime_from, machine2x2TS.datetime_to, machine2x2TS.scrap, production.value AS 'production'
                             from machine2x2TS LEFT JOIN production ON machine2x2TS.datetime_from = production.datetime_from where variable_name = 'PRODUCTION' AND machine_name = '2x2 brick mould' ;

create table machine2x2PROD AS SELECT machine2x2TSP.datetime_from, machine2x2TSP.datetime_to, machine2x2TSP.scrap,machine2x2TSP.production, production.value AS 'core_temperature'
                              from machine2x2TSP LEFT JOIN production ON machine2x2TSP.datetime_from = production.datetime_from where variable_name = 'CORE TEMPERATURE' AND machine_name = '2x2 brick mould' ;

create table machine3x2TS AS SELECT machine3x2Time.datetime_from, machine3x2Time.datetime_to, production.value AS 'scrap'
                             from machine3x2Time LEFT JOIN production ON machine3x2Time.datetime_from = production.datetime_from where variable_name = 'SCRAP' AND machine_name = '3x2 brick mould' ;


create table machine3x2TSP AS SELECT machine3x2TS.datetime_from, machine3x2TS.datetime_to, machine3x2TS.scrap, production.value AS 'production'
                              from machine3x2TS LEFT JOIN production ON machine3x2TS.datetime_from = production.datetime_from where variable_name = 'PRODUCTION' AND machine_name = '3x2 brick mould' ;

create table machine3x2PROD AS SELECT machine3x2TSP.datetime_from, machine3x2TSP.datetime_to, machine3x2TSP.scrap,machine3x2TSP.production, production.value AS 'core_temperature'
                               from machine3x2TSP LEFT JOIN production ON machine3x2TSP.datetime_from = production.datetime_from where variable_name = 'CORE TEMPERATURE' AND machine_name = '3x2 brick mould' ;

create table machine4x2TS AS SELECT machine4x2Time.datetime_from, machine4x2Time.datetime_to, production.value AS 'scrap'
                             from machine4x2Time LEFT JOIN production ON machine4x2Time.datetime_from = production.datetime_from where variable_name = 'SCRAP' AND machine_name = '4x2 brick mould' ;


create table machine4x2TSP AS SELECT machine4x2TS.datetime_from, machine4x2TS.datetime_to, machine4x2TS.scrap, production.value AS 'production'
                              from machine4x2TS LEFT JOIN production ON machine4x2TS.datetime_from = production.datetime_from where variable_name = 'PRODUCTION' AND machine_name = '4x2 brick mould' ;

create table machine4x2PROD AS SELECT machine4x2TSP.datetime_from, machine4x2TSP.datetime_to, machine4x2TSP.scrap,machine4x2TSP.production, production.value AS 'core_temperature'
                               from machine4x2TSP LEFT JOIN production ON machine4x2TSP.datetime_from = production.datetime_from where variable_name = 'CORE TEMPERATURE' AND machine_name = '4x2 brick mould' ;


create table machine4x2PRODRUN AS SELECT machine4x2PROD.datetime_from, machine4x2PROD.datetime_to, machine4x2PROD.scrap,machine4x2PROD.production, machine4x2PROD.core_temperature, runtime.isrunning AS 'isrunning'
                               from machine4x2PROD LEFT JOIN runtime ON machine_name = '4x2 brick mould' AND machine4x2PROD.datetime_from = runtime.datetime;




