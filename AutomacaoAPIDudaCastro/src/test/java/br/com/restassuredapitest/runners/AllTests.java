package br.com.restassuredapitest.runners;
import br.com.restassuredapitest.testes.users.testes.GetListUsersTest;
import br.com.restassuredapitest.testes.users.testes.GetSingleUserTest;
import br.com.restassuredapitest.testes.users.testes.PatchUserTest;
import br.com.restassuredapitest.testes.users.testes.PostUserTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitest.suites.AllTests.class)
@Suite.SuiteClasses({
        PostUserTest.class,
        GetSingleUserTest.class,
        GetListUsersTest.class,
        PatchUserTest.class
})
public class AllTests {
}
