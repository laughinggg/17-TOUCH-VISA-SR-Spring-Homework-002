create table if not exists tb_article(
  id serial primary key,
  title varchar(100),
  description varchar(100),
  author varchar(100),
  thumbnail varchar(100),
  created_date varchar(100),
  category_id int4,
);

create table if not exists tb_category (
	category_id serial primary key ,
	category_name varchar(100)
);