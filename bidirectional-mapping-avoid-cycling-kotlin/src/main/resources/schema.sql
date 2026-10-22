DROP TABLE IF EXISTS order_line;
DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id            INTEGER PRIMARY KEY,
    customer_name TEXT NOT NULL,
    order_date    TEXT NOT NULL
);

CREATE TABLE order_line
(
    id           INTEGER PRIMARY KEY,
    order_id     INTEGER NOT NULL REFERENCES orders (id),
    product_name TEXT    NOT NULL,
    quantity     INTEGER NOT NULL,
    price        REAL    NOT NULL
);
