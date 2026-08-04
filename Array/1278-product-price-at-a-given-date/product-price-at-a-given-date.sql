SELECT p.product_id,
       p.new_price AS price
FROM Products p
JOIN (
    SELECT product_id,
           MAX(change_date) AS latest
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) t
ON p.product_id = t.product_id
AND p.change_date = t.latest

UNION

SELECT DISTINCT product_id, 10 AS price
FROM Products
WHERE product_id NOT IN (
    SELECT product_id
    FROM Products
    WHERE change_date <= '2019-08-16'
);