CREATE OR REPLACE PROCEDURE HANBIT.all_major(
    sp_result OUT CLOB
) AS
    sp_temp CLOB;
    sp_cnt  NUMBER := 0;
BEGIN
        
    FOR major_rec IN (SELECT m.major_seq
                            ,m.title
                      FROM   major m
                     )
    LOOP
        sp_cnt := sp_cnt + 1;
        IF sp_cnt = 1 THEN
           sp_temp := major_rec.major_seq||','||major_rec.title;
           
        ELSE
        
          sp_temp := sp_temp||CHR(10)||
                     major_rec.major_seq||','||major_rec.title;
          
        END IF;
    END LOOP;
    
    sp_result := sp_temp;
    
END all_major;

DECLARE
     sp_result CLOB;
BEGIN
    all_major(sp_result);
    DBMS_OUTPUT.PUT_LINE(sp_result);
    
END; 
-------- CURSOR TYPE -----------------------------
CREATE OR REPLACE PROCEDURE HANBIT.all_major1(
    sp_result OUT SYS_REFCURSOR
) AS
BEGIN
        
    OPEN sp_result FOR 
    SELECT *
    FROM   major
    ;
    
END all_major1;
DECLARE
    sp_result SYS_REFCURSOR;
    marjor_rec major%ROWTYPE;
BEGIN
    all_major1(sp_result);
    LOOP 
    FETCH sp_result 
    INTO marjor_rec;
        EXIT WHEN sp_result%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(marjor_rec.major_seq||','||marjor_rec.title);
    END LOOP;
END;