DROP TABLE IF EXISTS exam_result; CREATE TABLE exam_result ( 
id INT,
 name VARCHAR(20),
 chinese DECIMAL(3,1),
 math DECIMAL(3,1),
 english DECIMAL(3,1)
 );
INSERT INTO exam_result (id,name, chinese, math, english) 
VALUES (1,'王一博', 67, 98, 56),
 (2,'肖战', 87.5, 78, 77),
 (3,'王琑', 88, 98, 90),
 (4,'百香果', 82, 84, 67),
 (5,'巴西龟', 55.5, 85, 45),
 (6,'战山为王', 70, 73, 78.5),
 (7,'博君一肖', 75, 65, 30);
SELECT * FROM exam_result;
SELECT id,name,english FROM exam_result;
SELECT id, name, english + 10 FROM exam_result;
SELECT id, name, chinese + math + english FROM exam_result;
SELECT math FROM exam_result;
SELECT DISTINCT math FROM exam_result;












