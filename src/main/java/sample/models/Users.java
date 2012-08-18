package sample.models;

import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

public class Users {

	Map<String, Object> projects;
	private String name;

	public void add(String username, JSONObject projects) {
		// TODO DBへ登録
		this.name = username;

		Iterator<?> iter = projects.keys();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			this.projects.put(key, projects.getString(key));
		}
	}

	public String getName() {
		return "tajima";
	}

	public Map<String, Object> getProjects() {

		return this.projects;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getProject(String name) {
		return (Map<String, String>) this.projects.get(name);
	}

}
