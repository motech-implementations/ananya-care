package org.motechproject.care.reporting.migration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommcareSyncValidator {
	
	
	 private static final Logger logger = LoggerFactory.getLogger(CommcareSyncValidator.class);
	
	public static void main(String[] args) {
		
		
		
		
	}
	
	
	  private static void execute(final String[] args) {
	        final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationCareMigration.xml");

	        final MigratorArguments migratorArguments = new MigratorArguments(args);

	        final Migrator migrator = applicationContext.getBean(Migrator.class);
	        migrator.migrate(migratorArguments);
	        applicationContext.destroy();
	    }

}
