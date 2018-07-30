package com.db;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class AutoCreateTable {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SchemaExport se = new SchemaExport(config);
		se.create(true,true);
	}

}
