insert into authors(firstName, lastName) values ('Jan', 'Kowalski'), ('Adam', 'Nowak');
insert into publishers(name) values ('Helion'), ('Atena'), ('PWN'), ('WKiŁ');

insert into categories(name) values ('Podróże');
insert into categories(name) values ('Programowanie');
insert into categories(name) values ('Gotowanie');

insert into books(description, pages, rating, title, category_id, publisher_id) values ('Fajna książka o programowaniu', 123, 9, 'Java - techniki programowania', 2, 1);
insert into books(description, pages, rating, title, category_id, publisher_id) values ('Fajna książka o programowaniu', 256, 2, 'Android - techniki programowania', 2, 4);
insert into books(description, pages, rating, title, category_id, publisher_id) values ('Ciekawa ksążka', 300, 6, 'W pustyni i w puszczy', 1, 1);
insert into books(description, pages, rating, title, category_id, publisher_id) values ('...', 34, 5, 'Książka kucharska', 3, 2);

insert into books_authors(books_id, authors_id) values (1, 1);
insert into books_authors(books_id, authors_id) values (1, 2);
insert into books_authors(books_id, authors_id) values (2, 1);
insert into books_authors(books_id, authors_id) values (3, 2);
insert into books_authors(books_id, authors_id) values (4, 1);