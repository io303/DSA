SELECT today.id
FROM Weather AS today
WHERE EXISTS (
    SELECT 1
    FROM Weather AS yest
    WHERE today.temperature > yest.temperature
    AND DATEDIFF(today.recordDate, yest.recordDate) = 1
);