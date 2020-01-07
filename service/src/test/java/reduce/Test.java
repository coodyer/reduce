package reduce;

import java.util.HashMap;
import java.util.Map;

import org.coody.framework.Cson;
import org.coody.reduce.domain.UserInfo;

public class Test {

	public static void main(String[] args) {
		UserInfo user = new UserInfo();
		user.setId(10010);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(1, user);
		map.put(2, user);
		System.out.println(Cson.toJson(map));
	}

}
