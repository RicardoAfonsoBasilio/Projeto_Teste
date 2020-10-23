
CREATE TABLE Cargo
(
    Cargo_Id integer PRIMARY KEY,
    Cargo_Nome varchar(50)
    
);
 
INSERT INTO Cargo (Cargo_Id, Cargo_Nome) VALUES (1, 'Gerente TI');
INSERT INTO Cargo (Cargo_Id, Cargo_Nome) VALUES (2, 'Desenvolvedor');
------------------------------------------

CREATE TABLE Funcionario
(
    Func_Id integer PRIMARY KEY AUTOINCREMENT,
    Func_Nome varchar(50),
	Cargo_Id integer,
	CONSTRAINT fk_CargoFunc FOREIGN KEY (Cargo_Id) REFERENCES Cargo (Cargo_Id)
);

	
     
INSERT INTO Funcionario (Func_Id, Func_Nome) VALUES (1, 'Ricardo');
INSERT INTO Funcionario (Func_Id, Func_Nome) VALUES (2, 'Rodrigo');

-----------------------------------------------

CREATE TABLE Departamento
(
    Depart_Id integer PRIMARY KEY,
    Depart_Nome varchar(50)
    
);
 
INSERT INTO Departamento (Depart_Id, Depart_Nome) VALUES (1, 'TI');
INSERT INTO Departamento (Depart_Id, Depart_Nome) VALUES (2, 'Financeiro');


-----------------------------------------------------
CREATE TABLE Historico_Depart
(
    Depart_Id integer ,
    Func_Id integer,
	Data_Ini Date,
	Data_Fim Date
    
);
INSERT INTO Historico_Depart (Depart_Id, Func_Id, Data_Ini, Data_Fim ) VALUES (2, 1, '01/10/2019', '01/05/2019');
INSERT INTO Historico_Depart (Depart_Id, Func_Id, Data_Ini, Data_Fim) VALUES (1, 1, '02/05/2019', '22/10/2020');
INSERT INTO Historico_Depart (Depart_Id, Func_Id, Data_Ini, Data_Fim) VALUES (1, 2, '02/05/2019', '22/10/2020');

----------------------------------

CREATE TABLE Func_Depart
(
    Depart_Id integer ,
    Func_Id integer,
    CONSTRAINT fk_DepartFunc FOREIGN KEY (Depart_Id) REFERENCES Departamento (Depart_Id),
	CONSTRAINT fk_FuncDepart FOREIGN KEY (Func_Id) REFERENCES Funcioanrio (Func_Id)
);

INSERT INTO Func_Depart (Depart_Id, Func_Id) VALUES (1, 1);
INSERT INTO Func_Depart (Depart_Id, Func_Id) VALUES (1, 2);
------------------------------------- 

•	Consulta de funcionários de um departamento
SELECT F.Func_Nome, D.Depart_Nome 
 FROM Departamento D, Funcionario F, Func_Depart FD 
 WHERE D.Depart_Id = 1
 AND F.Func_Id = FD.Func_Id 
 AND D.Depart_Id = FD.Depart_Id
 
--------------------------------------
•	Manter histórico dos departamentos que o usuário trabalhou

SELECT F.Func_Nome, D.Depart_Nome, HD.Data_Ini, HD.Data_Fim
FROM  Departamento D, Funcionario F, Historico_Depart HD
WHERE F.Func_Id = 1
 AND F.Func_Id = HD.Func_Id
 AND D.Depart_Id = HD.Depart_Id
 ORDER BY HD.Data_Ini ASC

 
 -----------------------------------------
 •	Definir Chefe do departamento
SELECT F.Func_Nome, D.Depart_Nome, C.Cargo_Nome
FROM  Departamento D, Funcionario F, Func_Depart FD, Cargo C
WHERE F.Func_Id = 2
 AND F.Func_Id = FD.Func_Id 
 AND D.Depart_Id = FD.depart_id
 AND C.Cargo_Id = F.Cargo_Id
 
 

 

 