 create table teachers(
    name VARCHAR(20) unique,
    gender VARCHAR(3) not null default '保密',
    age INT not null default 0,
    height DOUBLE not null default 0,
    weight DOUBLE not null default 0
    );
	
	--博客
create table users (
	id int primary key auto_increment,
	username VARCHAR(100) UNIQUE
);
create table  articles(
	id int primary key auto_increment,
	author_id int not null,
	title VARCHAR(100) NOT NULL,
	content TEXT NOT NULL,
	published_at DATETIME NOT NULL
);
create table  comments(
	id int primary key auto_increment,
	user_id int not null,
	articles_id int not null,
	content VARCHAR(100) NOT NULL,
	published_at DATETIME NOT NULL
);
create table user_article_like_relation(
	user_id int not null,
	articles_id int not null,
	PRIMARY KEY (user_id,articles_id)
);
