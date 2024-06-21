package Endpoint;

import java.sql.SQLException;

import MySQL.MySQLQueryBuilder;
import interfaces.DataBaseFactory;
import interfaces.Date;
import interfaces.IAttr;
import interfaces.IDatabase;
import interfaces.IInteger;
import interfaces.IPrimaryKey;
import interfaces.ITable;
import interfaces.Varchar;

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
