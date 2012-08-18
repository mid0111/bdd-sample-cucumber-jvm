package sample.test.Models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sample.models.Users;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class doUserModels {

	Users users = new Users();
	private String username;
	private JSONObject projects = new JSONObject();

	@When("^ユーザを登録する$")
	public void ユーザを登録する() {
		this.users.add(this.username, this.projects);
	}

	@Then("^ユーザ名のみのオブジェクトが登録されること$")
	public void ユーザ名のみのオブジェクトが登録されること(String arg1) {
		JSONObject expects = JSONObject.fromObject(arg1);

		assertThat(this.users.getName(), is(expects.getString("name")));

		checkProjects(expects);
	}

	@Given("^お気に入りプロジェクト名 'elasticsearch' URL 'https://github.com/elasticsearch/elasticsearch'$")
	public void お気に入りプロジェクト名_elasticsearch_URL_https_github_com_elasticsearch_elasticsearch() {
		this.projects.put("elasticsearch", "https://github.com/elasticsearch/elasticsearch");
	}

	@Then("^ユーザ名とプロジェクト名を保持してオブジェクトが登録されること$")
	public void ユーザ名とプロジェクト名を保持してオブジェクトが登録されること(String arg1) {
		// Express the Regexp above with the code you wish you had

	}

	private void checkProjects(JSONObject expects) {
		JSONArray expectProjects = expects.getJSONArray("projects");

		assertThat(expectProjects.size(), is(this.users.getProjects().size()));
		for (int i = 0; i < expectProjects.size(); i++) {
			JSONObject expectProject = expectProjects.getJSONObject(i);
			String url = this.users.getProject(expectProject.getString("name")).get("url");
			assertThat(url, is(expectProject.getString("url")));
		}
	}

}
