package api;

import DbUtils.DbUtils;
import fixture.UserConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import javax.net.ssl.SSLContext;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.Matchers.equalTo;

public class TestAPI {

    RequestSpecification requestSpecForReg = new RequestSpecBuilder()
                .setBaseUri("https://user.t.motorsport.tv/")
                .setContentType(ContentType.URLENC)
                .setRelaxedHTTPSValidation("TLSv1.2")
                .build();
    RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://t.motorsport.tv/")
                .setContentType(ContentType.URLENC)
                .setRelaxedHTTPSValidation("TLSv1.2")
                .build();


    private String getBearer(String email, String pass) {
        Response authResponse =
                RestAssured.given(requestSpec)
                        .formParam("email", email)
                        .formParam("password", pass)
                        .when()
                        .post(Endpoints.AUTH);
        authResponse.then().statusCode(200);
        return authResponse.body().jsonPath().getString("data.token");
    }

    public void getSubscriptionInfo(String user) {
        RestAssured.given(requestSpec)
                .header("bearer", getBearer(user, UserConstants.PASS_FOR_ALL_TESTS))
                .get(Endpoints.SubscriptionInfo)
                .then()
                .body("data.subscription.status", Matchers.notNullValue())
                .statusCode(200);
    }

    public void postConfirmEmailForNewUser() {
        String registerToken = DbUtils.getUserConfirmationToken(UserConstants.EMAIL_FOR_REGISTRATION);
        System.out.println(registerToken + " register token from DB");

        RestAssured.given(requestSpecForReg)
                .param("token", registerToken)
                .post(Endpoints.Confirm_Email)
                .then()
             //   .log().all();
                .statusCode(200);
    }

    public void postCheckThatEmailConfirmed() {
        RestAssured.given(requestSpecForReg)
                .formParam("email", UserConstants.EMAIL_FOR_REGISTRATION)
                .formParam("password", UserConstants.PASS_FOR_ALL_TESTS)
                .when()
                .post(Endpoints.AUTH)
                .then()
                .body("data.user.is_email_confirmed", equalTo(true))
                .statusCode(200);
    }
    public String getInfoAboutLivestreamEpisode(String id) {
        Response getEpisodeInfo =
                RestAssured.given(requestSpec)
                        .pathParams("id",id)
                        .when()
                        .get(Endpoints.EpisodeInfo);
        getEpisodeInfo.then()
                .statusCode(200)
                .body("data.is_livestream", equalTo(true))
                .body("data.is_record_active", equalTo(false));
        return getEpisodeInfo
                .body()
                .jsonPath()
                .getString("data.livestream_start_datetime");
    }

    public void getCheckThatLivestreamIsLiveNow(String id) {
        RestAssured.given(requestSpec)
                .pathParams("id",id)
                .when()
                .get(Endpoints.EpisodeInfo)
                .then()
                .statusCode(200)
                .body("data.is_livestream", equalTo(true))
                .body("data.is_record_active", equalTo(true));
    }
}
