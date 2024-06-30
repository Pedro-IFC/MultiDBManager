package Endpoint;

import java.sql.SQLException;

import MySQL.MySQLQueryBuilder;
import interfaces.DataBaseFactory;
import interfaces.IAttr;
import interfaces.IDatabase;
import interfaces.IPrimaryKey;
import interfaces.ITable;

public class Main {
	public static void main(String[] args) throws SQLException {
		System.out.println("========================");
		System.out.println("MySQL: ");
		MySQLQueryBuilder mysqlC = new MySQLQueryBuilder("localhost", "3306", "root", "");
		DataBaseFactory sqlS = mysqlC.initQuery();
		
		IDatabase db = sqlS.createDatabase("alunos", "latin1_swedish_ci", "latin1");
		
		ITable alunos = db.createTable("alunos");
		IAttr idAluno = alunos.createAttr("IdAluno").integer(8).autoincrement();
		alunos.createAttr("Nome").varchar(60);
		alunos.createAttr("Sobrenome").varchar(60);
		alunos.createAttr("DataDeNascimento").date();
		IPrimaryKey PKAluno = alunos.createPrimaryKey(idAluno);
		
		ITable aulas = db.createTable("aulas");
		IAttr idAula = aulas.createAttr("IdAula").integer(8).autoincrement();
		aulas.createAttr("Nome").varchar(60);
		aulas.createAttr("Descrição").varchar(60);
		IPrimaryKey PKAula = aulas.createPrimaryKey(idAula);
		
		ITable matriculas = db.createTable("matriculas");
		matriculas.createAttr("IdMatricula").integer(8).autoincrement();
		matriculas.createForeignKey(PKAula, idAula);
		matriculas.createForeignKey(PKAluno, idAluno);
		
		mysqlC.delete();
		mysqlC.run();
		
		System.out.println(mysqlC.getString());
		
	}

}
