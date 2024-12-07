-- 코드를 작성해주세요
SELECT
    ID,
    IFNULL(
        (
            SELECT
                COUNT(*)
            FROM
                ECOLI_DATA
            GROUP BY
                PARENT_ID
            HAVING
                PARENT_ID = ID
        ), 0
    ) AS CHILD_COUNT
FROM
    ECOLI_DATA
ORDER BY
    ID