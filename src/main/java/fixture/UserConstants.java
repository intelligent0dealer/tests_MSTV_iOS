package fixture;

import LocaleInfo.Locale;

public class UserConstants {
    public static final String EMAIL_FOR_LIVESTREAM = "intelligent.dealer1605+0123@gmail.com";
    public static final String EMAIL_FOR_REGISTRATION = "createdbyiosautotest@gmail.com";
    public static final String EMAIL_FOR_PPV_TEST = "intelligent.dealer1605+012345@gmail.com";
    public static final String EMAIL_FOR_SIGNINS = "intelligent.dealer1605+ftv@gmail.com";
    public static final String PASS_FOR_ALL_TESTS = "1234";
    public static final String ID_OF_FUTURE_LIVESTREAM = "35823";
    public static final String DATE_OF_FUTURE_LIVE = "May 12, 18:39";
    public static String idOfLiveNowStream(Locale appLocale) {
        switch (appLocale) {
            case EN: return "35960";
            case RU: return "35962";
            case FR: return "37921";
            default: throw new IllegalArgumentException("Different Region Or Different ID of Episode");
        }
    }
    public static String dateOfFutureLive(Locale appLocale) {
        switch (appLocale) {
            case EN: return "May 12, 18:39";
            case RU: return "12 мая, 18:39";
            case FR: return "12 mai, 18:39";
            default: throw new IllegalArgumentException("Different Region Or Different ID of Episode");
        }
    }
    public static String passwordField(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Password";
            case RU: return "Пароль";
            case FR: return "Mot de passe";
            default: throw new IllegalArgumentException("OOPS I DONT KNOW WHAT IS IT");
        }
    }
    public static String confirmPasswordField(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Confirm Password";
            case RU: return "Подтвердить пароль";
            case FR: return "Confirmer le mot de passe";
            default: throw new IllegalArgumentException("Different Region Or Different ID of Episode");
        }

    }
}
