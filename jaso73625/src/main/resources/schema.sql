create table book_category (
  id integer primary key,
  category varchar(255)
);

create table book (
  id integer primary key,
  book_category_id integer,
  name varchar(255),
  foreign key (book_category_id) references book_category(id)
);

