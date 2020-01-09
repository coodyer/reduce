package reduce;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.coody.framework.Cson;
import org.coody.framework.adapter.TypeAdapter;
import org.coody.framework.core.util.random.RandomUtil;
import org.coody.reduce.domain.UserInfo;

public class Test {

	public static void main(String[] args) {

		Map<String, List<UserInfo>> map = new HashMap<String, List<UserInfo>>();
		map.put("user1", getUsers());
		map.put("user2", getUsers());
		String json = Cson.toJson(map);
		System.out.println(json);
		System.out.println(Cson.toJson(Cson.toObject(json, new TypeAdapter<Map<String, List<UserInfo>>>() {
		})));
	}

	private static List<UserInfo> getUsers() {
		List<UserInfo> users = new ArrayList<UserInfo>();
		users.add(getUserInfo());
		users.add(getUserInfo());
		return users;
	}

	private static UserInfo getUserInfo() {
		UserInfo userInfo = new UserInfo();

		userInfo.setId(RandomUtil.random(1, 999999));
		userInfo.setCreateTime(new Date());
		userInfo.setEmail("644556636_" + userInfo.getId());
		userInfo.setPassword("password_" + userInfo.getId());
		return userInfo;
	}
}
