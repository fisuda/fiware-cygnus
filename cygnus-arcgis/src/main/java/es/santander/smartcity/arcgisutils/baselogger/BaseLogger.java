/**
 * 
 */
package es.santander.smartcity.arcgisutils.baselogger;

import org.apache.log4j.Logger;

/**
 * @author dmartinez
 *
 */
public class BaseLogger implements BaseLoggerInterface {
	
	static final Logger logger = Logger.getLogger(BaseLogger.class);
	
	protected BaseLoggerInterface parentLogger = null;

	/**
	 * Default constructor
	 */
	public BaseLogger() {
	}
	

	/**
	 * Constructor setting parent loger to allow bubble logs.
	 */
	public BaseLogger(BaseLoggerInterface parentLogger) {
		this.parentLogger = parentLogger;
	}
	
	/**
    * 
    * @param message
    */
	@Override
   public void logBasic(String message) {
       if (parentLogger != null){
    	   parentLogger.logBasic(getClassName() + ": " + message);
       } else {
           logger.info(getClassName() + ": " + message);
       }
   }
	
	protected String getClassName(){
		String className = "";
		if (this != null && this.getClass() != null)
			className = "" + this.getClass().getName();
		return className;
	}
   /**
    * 
    * @param message
    */
	@Override
   public void logDebug(String message) {
       if (parentLogger != null){
    	   parentLogger.logDebug(getClassName() + ": " + message);
       } else {
    	   logger.debug(getClassName() + ": " + message);
       }
   }

   /**
    * 
    * @param message
    */
	@Override
   public void logTrace(String message) {
       if (parentLogger != null){
    	   parentLogger.logTrace(getClassName() + ": " + message);
       } else {
           logger.trace(getClassName() + ": " + message);
       }
   }

   /**
    * 
    * @param message
    */
	public void logError(String message) {
       if (parentLogger != null){
    	   parentLogger.logError(getClassName() + ": " + message);
       } else {
           logger.error(getClassName() + ": " + message);
       }
   }


}
