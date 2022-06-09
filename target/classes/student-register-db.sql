create schema student_db;


SET search_path TO student_db;

create table majors (
    id int generated always as identity primary key,
    major_name varchar not null unique
);

create table classrooms (
  id int generated always as identity primary key,
  class_name varchar not null,
  dec_major int,
  
  constraint majors_fk
foreign key (dec_major)
references majors (id)
);


create table students (
    id int generated always as IDENTITY primary key,
    FirstName varchar NOT NULL,
    LastName varchar NOT NULL,
    username varchar unique NOT NULL,
    password varchar not null,
    classroom_id int not null,
    
constraint classrooms_fk
foreign key (classroom_id)
references classrooms (id) 
);



-- establish some majors 
insert into majors (major_name) values ('General Studies'), ('History'), ('Chemistry'), ('Mathematics'), ('Education'), ('Sociology'), ('PoliSci'), ('English'), ('Psychology'), ('CompSci');


-- establishing classrooms
insert into classrooms (dec_major, class_name) values (1, 'Speech I: Intro to Public Presentation'),
(2, 'American History: Afro-American History'),
(3, 'Organic Chemistry I'),
(4, 'Trigonometry'),
(5, 'Primary Learning: Kindergarten to Third'),
(6, 'Disabilities & Culture'),
(7, 'American Government & Politics'),
(8, 'Transcendentilism'),
(9, 'Abnormal Psychology'),
(10, 'Software Quality Assurance' );


-- establish users (students)
insert into students (classroom_id, FirstName, LastName, username, password) values (1, 'Leeroy', 'Jenkins', 'palsfourlyfe', 'chicken'),
(2, 'Peter', 'Parker', 'OReilly', 'Webhead'),
(3, 'Maya', 'Moore', 'Javamente', 'blankspace'),
(4, 'Daniel', 'Dooley', 'Ottomaton', 'lemonlemurlinux'),
(5, 'Crystal', 'Cartman', 'Quarty', 'rocksrcool'),
(6, 'Franz', 'Fernindad', 'Archduke', 'TakeMeOut'),
(7, 'Samantha', 'Stover', 'SScapegoat', 'DonJulia'),
(8, 'Ellie', 'Eldrige', 'EqualsESquare', 'Einstein'),
(9, 'Stephen', 'Sharp', 'KnightofVengeance', 'Granted'),
(10, 'Gretchen', 'Gabriels', 'GivenGrace', 'rollfordmg');

