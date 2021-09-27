// "select product_code,product_name,quantity + ? as total 
// from m_product where product_code=?");

create table m_product (
    product_code integer primary key,
    product_name varchar(255),
    quantity integer
);

insert into m_product (product_code, product_name, quantity) values
(1,'car', 50),
(2, 'bike', 60),
(3, 'train', 70);
