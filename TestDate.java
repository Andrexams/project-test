import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {	
	
	public static void main(String[] args) throws Exception {		
		//testTimezone();
		/*Date d = null;
		serialize(new Date());		
		d = deserialize();*/
		
	}

	private static void testTimezone() {
		Calendar someDate = Calendar.getInstance();		
		someDate.add(Calendar.HOUR_OF_DAY,-4);        
        System.out.println(someDate.getTime());        
        System.out.println(someDate.getTimeInMillis());
        
        System.out.println("---------------------------------------");
        
        Calendar utcDate = Calendar.getInstance();        
        utcDate.setTimeInMillis(someDate.getTimeInMillis());
                
        TimeZone z = someDate.getTimeZone();
        int offset = z.getRawOffset();       
        int offsetHrs = offset / 1000 / 60 / 60;
        int offsetMins = offset / 1000 / 60 % 60;        
        
        utcDate.add(Calendar.HOUR_OF_DAY, (-offsetHrs));
        utcDate.add(Calendar.MINUTE, (-offsetMins));
                
        System.out.println("------------changed to UTC------------");
        System.out.println(utcDate.getTime());
        System.out.println(utcDate.getTimeInMillis());
	}	
	
	public static void serialize(Date date) throws Exception {
		 FileOutputStream file = new FileOutputStream("d:\\teste\\date.ser");
         ObjectOutputStream out = new ObjectOutputStream(file);       
         out.writeObject(date);          
         out.close();
         file.close();
         System.out.println(date + " serializaded.");
	}
	
	public static Date deserialize() throws Exception {
		FileInputStream file = new FileInputStream("d:\\teste\\date.ser");
        ObjectInputStream out = new ObjectInputStream(file);         
        Date d = (Date) out.readObject();          
        out.close();
        file.close();
        System.out.println(d + " deserialized.");
        return d;
	}
	
}
