package reduce;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		System.out.println(new BigDecimal("738642.144600000000000000")
				.add(new BigDecimal("93708.189800000000000000").add(new BigDecimal("38256.347500000000000000"))));
	}

}
