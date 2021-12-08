create table districts(
    id int8 not null,
    name varchar(18) not null,
    callback varchar(18) not null,
    lb_lat varchar(18) not null,
    lb_long varchar(18) not null,
    rt_lat varchar(18) not null,
    rt_long varchar(18) not null,
    primary key (id));
alter table districts add constraint districts_name unique (name);
alter table districts add constraint districts_callback unique (callback);