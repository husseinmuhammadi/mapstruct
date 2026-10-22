INSERT INTO orders (id, customer_name, order_date) VALUES (1, 'Alice', '2026-10-01');
INSERT INTO orders (id, customer_name, order_date) VALUES (2, 'Bob', '2026-10-15');

INSERT INTO order_line (id, order_id, product_name, quantity, price) VALUES (1, 1, 'Keyboard', 1, 49.90);
INSERT INTO order_line (id, order_id, product_name, quantity, price) VALUES (2, 1, 'Mouse', 2, 19.95);
INSERT INTO order_line (id, order_id, product_name, quantity, price) VALUES (3, 2, 'Monitor', 1, 229.00);
