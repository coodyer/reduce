package reduce;

import java.util.Calendar;
import java.util.Date;

import org.coody.framework.core.util.DateUtils;

public class Test {

	public static void main(String[] args) {

		Date time = DateUtils.toDate("2019-01-04 12:32:11");
		time = DateUtils.change(time, Calendar.DAY_OF_YEAR, 200);
		System.out.println(DateUtils.toString(time,"yyyy-MM-dd"));
	}

}
