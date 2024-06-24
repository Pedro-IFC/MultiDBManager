# Java Multi Database Manager

## Descrição do Projeto

Este projeto é um framework em Java projetado para facilitar a manutenção de bancos de dados e tabelas. Ele fornece uma interface intuitiva e amigável para criar, alterar e excluir bancos de dados e suas respectivas tabelas. Utilizando este framework, desenvolvedores podem definir a estrutura de bancos de dados programaticamente, garantindo maior controle e flexibilidade na gestão de esquemas de dados.

## Objetivo

O objetivo principal deste framework é simplificar o processo de manutenção de bancos de dados em Java. Ele permite a criação de bancos de dados e tabelas, definição de atributos, chaves primárias e estrangeiras, e execução de comandos SQL de maneira automatizada e eficiente. Isso é especialmente útil para desenvolvedores que precisam gerir esquemas de banco de dados dinamicamente ou em ambientes de desenvolvimento e testes.

## Exemplo de Uso

Abaixo está um exemplo de código que demonstra como utilizar o framework para criar e gerenciar bancos de dados e tabelas.

```java
public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("========================");
        System.out.println("MySQL: ");
        MySQLQueryBuilder mysqlC = new MySQLQueryBuilder("localhost", "3306", "root", "");
        DataBaseFactory sqlS = mysqlC.initQuery();
        
        IDatabase db = sqlS.createDatabase("alunos", "latin1_swedish_ci", "latin1");
        
        ITable alunos = db.createTable("alunos");
        IAttr idAluno = alunos.createAttr(IInteger.create("IdAluno", 8));
        alunos.createAttr(Varchar.create("Nome", 60));
        alunos.createAttr(Varchar.create("Sobrenome", 60));
        alunos.createAttr(Date.create("DataDeNascimento"));
        IPrimaryKey PKAluno = alunos.createPrimaryKey(idAluno);
        
        ITable aulas = db.createTable("aulas");
        IAttr idAula = aulas.createAttr(IInteger.create("IdAula", 8));
        aulas.createAttr(Varchar.create("Nome", 60));
        aulas.createAttr(Varchar.create("Descrição", 255));
        IPrimaryKey PKAula = aulas.createPrimaryKey(idAula);
        
        ITable matriculas = db.createTable("matriculas");
        matriculas.createAttr(IInteger.create("IdMatricula", 8));
        matriculas.createForeignKey(PKAula, idAula);
        matriculas.createForeignKey(PKAluno, idAluno);
        
        mysqlC.delete();
        mysqlC.run();
        
        System.out.println(mysqlC.getString());
    }
}
```
## Explicação do Código
## Conexão com MySQL:

```java
  MySQLQueryBuilder mysqlC = new MySQLQueryBuilder("localhost", "3306", "root", "");
```
  Cria um novo construtor de consultas MySQL com as credenciais fornecidas.

## Inicialização da Query:

```java
DataBaseFactory sqlS = mysqlC.initQuery();
```
Inicializa a fábrica de banco de dados.

## Criação do Banco de Dados:

```java
IDatabase db = sqlS.createDatabase("alunos", "latin1_swedish_ci", "latin1");
```
Cria um novo banco de dados chamado "alunos" com a configuração de caracteres especificada.

## Criação da Tabela "alunos":

```java
ITable alunos = db.createTable("alunos");
IAttr idAluno = alunos.createAttr(IInteger.create("IdAluno", 8));
alunos.createAttr(Varchar.create("Nome", 60));
alunos.createAttr(Varchar.create("Sobrenome", 60));
alunos.createAttr(Date.create("DataDeNascimento"));
IPrimaryKey PKAluno = alunos.createPrimaryKey(idAluno);
```
Define a tabela "alunos" com atributos de ID, nome, sobrenome e data de nascimento, além de configurar a chave primária.

## Criação da Tabela "aulas":

```java
ITable aulas = db.createTable("aulas");
IAttr idAula = aulas.createAttr(IInteger.create("IdAula", 8));
aulas.createAttr(Varchar.create("Nome", 60));
aulas.createAttr(Varchar.create("Descrição", 255));
IPrimaryKey PKAula = aulas.createPrimaryKey(idAula);
```
Define a tabela "aulas" com atributos de ID, nome e descrição, e configura a chave primária.

## Criação da Tabela "matriculas":

```java
ITable matriculas = db.createTable("matriculas");
matriculas.createAttr(IInteger.create("IdMatricula", 8));
matriculas.createForeignKey(PKAula, idAula);
matriculas.createForeignKey(PKAluno, idAluno);
```
Define a tabela "matriculas" com um atributo de ID e chaves estrangeiras para as tabelas "alunos" e "aulas".

## Execução dos Comandos SQL:

```java
mysqlC.delete();
mysqlC.run();
System.out.println(mysqlC.getString());
```
Exclui a configuração atual, executa os comandos SQL gerados e imprime a string de consulta SQL.

