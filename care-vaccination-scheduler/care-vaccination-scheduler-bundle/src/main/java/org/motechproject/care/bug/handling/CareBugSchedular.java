package org.motechproject.care.bug.handling;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.Query;

import org.apache.log4j.Logger;
import org.motechproject.care.service.VaccinationProcessor;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.repository.MdsRepository;
import org.motechproject.mds.query.QueryExecution;
import org.motechproject.mds.query.QueryExecutor;
import org.motechproject.mds.util.InstanceSecurityRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CareBugSchedular {
	
	private static final Logger LOGGER = Logger.getLogger(CareBugSchedular.class);
    
    @Autowired
    @Qualifier("motherVaccinationProcessor") 
    VaccinationProcessor motherVaccinationProcessor; 
    
    @Autowired
    @Qualifier("childVaccinationProcessor") 
    VaccinationProcessor childVaccinationProcessor;
    
    
    @Autowired
    MdsRepository dbRepository;  
    
    
    public void enrollMissingVaccine () {
    	motherVaccinationProcessor.enrollUpdateVaccines(getMotherWithCaseId().get(0));
	
    }
    
    
    private void enrollAllMissingMotherVaccines(){
    	
    	 List<MotherCase> mothers = getMothers();
         
    	 LOGGER.info("Total Number of mothers fetched "+mothers.size());
         
    	 int motherCount = 1;
         
    	 for (MotherCase mother : mothers) {
        	 
        	 LOGGER.info("Started Processing **** Mother "+motherCount+" :" +mother.getCaseId());
        	  motherVaccinationProcessor.enrollUpdateVaccines(mother);
        	 LOGGER.info("Processed mother vaccinations.....");
        	 motherCount++;
 		}
    	
    }
    
    
    
    private void enrollAllMissingChildVaccines() {
    	 List<ChildCase> childs = getChilds();
         LOGGER.info("Total Number of childs fetched "+childs.size());
        
         int childCount = 1;
         
         for (ChildCase child : childs) {
        	 LOGGER.info("Started Processing **** Child "+childCount+" :" +child.getCaseId());
        	 childVaccinationProcessor.enrollUpdateVaccines(child);
        	 LOGGER.info("Processed child vaccinations.......");
        	 childCount++;
 		}
    }
    
    
    
    private static final String MOTHER_EDD ="10-April-2015";
    
    private static final String CHILD_DOB ="09-April-2015";
    
    private static Date getDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
    	return dateFormat.parse(date);
    }
	
    private List<MotherCase> getMothers(){
    	QueryExecution<List> query = new QueryExecution<List>() {
            
    		String add = null;

            @Override
            public List execute(Query query,
           		 InstanceSecurityRestriction restriction) {
                try {
           
					query.setFilter("edd >= eddSupplied && actualDeliveryDate == "+add);
					query.declareImports("import java.util.Date");
					query.declareParameters("Date eddSupplied");
					query.execute(getDate(MOTHER_EDD));
				} catch (ParseException e) {
					e.printStackTrace();
				}
                return (List) QueryExecutor.execute(query, restriction);
            }

      	  	};
      	  
   		return dbRepository.executeJDO(MotherCase.class, query); 
    }
    
    
    private List<ChildCase> getChilds(){
    	QueryExecution<List> query = new QueryExecution<List>() {
            
            @Override
            public List execute(Query query,
           		 InstanceSecurityRestriction restriction) {
                try {
					query.setFilter(" dob >= dobSupplied ");
					query.declareImports("import java.util.Date");
					query.declareParameters("Date dobSupplied");
					query.execute(getDate(CHILD_DOB));
				} catch (ParseException e) {
					e.printStackTrace();
				}
                return (List) QueryExecutor.execute(query, restriction);
            }

      	  	};
      	  
   		return dbRepository.executeJDO(ChildCase.class, query); 
    }
	
    
    
    private List<MotherCase> getMotherWithCaseId(){
    	QueryExecution<List> query = new QueryExecution<List>() {
            
    		String add = null;

            @Override
            public List execute(Query query,
           		 InstanceSecurityRestriction restriction) {
      
					query.setFilter(" caseId == '9244cc92-2fba-4425-9cfb-660bf443d086' ");
				
                return (List) QueryExecutor.execute(query, restriction);
            }

      	  	};
      	  
   		return dbRepository.executeJDO(MotherCase.class, query); 
    }

}
