// "select product_code,product_name,quantity + ? as total 
// from m_product where product_code=?");

create table m_product (
    product_code integer primary key,
    product_name varchar(255),
    quantity integer
);
