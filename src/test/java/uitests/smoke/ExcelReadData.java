package uitests.smoke;

import java.util.ArrayList;
import java.util.Iterator;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReadData {

	private static final String FILE_NAME = "./dataSourcesTest.xlsx";
	
	
	public static void selectData(String tcid,String fieldName) throws FilloException{
		
		Fillo fillo=new Fillo();
	    Connection connection=fillo.getConnection(FILE_NAME);
	    String strQuery="Select * from data where BBB='"+tcid+"'";
	    Recordset recordset=connection.executeQuery(strQuery);
	    while(recordset.next()){
	        ArrayList<String> dataColl=recordset.getFieldNames();
	        //System.out.println(dataColl);
	        Iterator<String> dataIterator=dataColl.iterator();
	        //System.out.println(dataColl.size());  

	        while(dataIterator.hasNext()){
	            for (int i=0;i<=dataColl.size()-1;i++){
	                //System.out.println(i);
	                String data=dataIterator.next();
	                String dataVal=recordset.getField(data);

	                if (dataVal.equalsIgnoreCase(fieldName)){
	                    //System.out.println("passed");
	                    i=i+1;
	                    //System.out.println(i);
	                    String testData=dataColl.get(i);
	                    System.out.println(recordset.getField(testData));   

	                }

	            }

	            break;
	        }
	    }

	    recordset.close();
	    connection.close();
		
	}
	
	public static void main(String[] args) throws FilloException{
		
		selectData("BBB","Batch 1");
	}
	
}
