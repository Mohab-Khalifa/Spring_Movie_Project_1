drop table if exists movie CASCADE;
drop table if exists review CASCADE;

create table movie (id integer not null auto_increment, genre varchar(255) not null, release_year integer not null, runtime integer not null, title varchar(255) not null, primary key (id));

create table review (id integer not null auto_increment, comment varchar(250), posted_at date not null, rating integer not null check (rating>=1 AND rating<=10), movie_id integer, primary key (id));

alter table review add constraint FK8378dhlpvq0e9tnkn9mx0r64i foreign key (movie_id) references movie (id);