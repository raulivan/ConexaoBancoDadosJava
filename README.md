# ConexaoBancoDadosJava
Exemplo conexão com Banco de dados utilizando a linguagem de programação Java 

Banco de dados usando no exemplo (código para mssql)

CREATE DATABASE AGENDA_JAVA;
GO

USE AGENDA_JAVA;
GO

CREATE TABLE CONTATO(
	Id int identity(1,1) primary key,
	Nome varchar(100),
	Telefone varchar(100)
);
