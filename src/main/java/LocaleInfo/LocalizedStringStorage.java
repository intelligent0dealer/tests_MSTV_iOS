package LocaleInfo;

import pages.HomePage;

public class LocalizedStringStorage {

    public String subscriptionView(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Subscription";
            case RU: return  "Подписка";
            case FR: return "Abonnement";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String signInButton(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Sign In";
            case RU: return "Войти";
            case FR: return "Connexion";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String myFeedButton(Locale appLocale) {
        switch (appLocale) {
            case EN: return "My Feed";
            case RU: return "Избранное";
            case FR: return "Ma sélection";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String addToMyFeedButton(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Add to My Feed";
            case RU: return "Подписаться";
            case FR: return "Ajouter à ma sélection";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String seeAllButton(Locale appLocale) {
        switch (appLocale) {
            case EN: return "See all";
            case RU: return "Все";
            case FR: return "Voir tout";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String signUpButton(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Sign Up";
            case RU: return "Зарегистрироваться";
            case FR: return "S'inscrire";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String signInFromSignUp(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Already have account? Sign In";
            case RU: return "Уже есть учётная запись? Войти";
            case FR: return "Déjà abonné ? Connexion";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String livestreamTab(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Livestreams";
            case RU: return "Трансляции";
            case FR: return "En direct";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String liveNowStatus(Locale appLocale) {
        switch (appLocale) {
            case EN: return "Live Now";
            case RU: return "Сейчас в эфире";
            case FR: return "Actuellement en direct";
            default: throw new IllegalStateException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String dateOfTestLive(Locale appLocale) {
        switch (appLocale){
            case EN: return "Live: May 12, 2029, 18:39";
            case RU: return "В эфире 12 мая 2029, 18:39";
            case FR: return "En direct: 12 mai 2029, 18:39";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String continueButton(Locale appLocale) {
        switch (appLocale){
            case EN: return "Continue";
            case RU: return "Продолжить";
            case FR: return "Continuer";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String openMailAppAndConfirmButton(Locale appLocale) {
        switch (appLocale){
            case EN: return "Open email app";
            case RU: return "Открыть почтовое приложение";
            case FR: return "Ouvrir l'application mail";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String skipConfirmButton(Locale appLocale) {
        switch (appLocale){
            case EN: return "Sign Out, I’ll confirm later";
            case RU: return "Выйти и подтвердить позже";
            case FR: return "Se déconnecter et confirmer plus tard";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String freePlan(Locale appLocale) {
        switch (appLocale){
            case EN: return "Free";
            case RU: return "Бесплатный";
            case FR: return "Libre";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String monthlyPlan(Locale appLocale) {
        switch (appLocale){
            case EN: return "Monthly";
            case RU: return "Месячный";
            case FR: return "Mensuel";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String annualPlan(Locale appLocale) {
        switch (appLocale){
            case EN: return "Annual";
            case RU: return "Годовой";
            case FR: return "Annuel";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String noFeed(Locale appLocale){
        switch (appLocale){
            case EN: return "No active Feeds yet!";
            case RU: return "У Вас ещё нет избранного контента";
            case FR: return "Vous n'avez pas encore de sélection personnalisée.";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String checkBoxText(Locale appLocale){
        switch (appLocale){
            case EN: return "Please send me Motorsport.tv newsletters, and occasional communication from Motorsport Network featuring your favorite content, exclusive offers and other information.";
            case RU: return "Я согласен/согласна получать рассылку от Моторспорт.тв и периодические сообщения от Motorsport Network об избранном контенте, эксклюзивных предложениях и др.";
            case FR: return "Je voudrais recevoir les newsletters Motorsport.tv et les communications occasionnelles de Motorsport Network avec votre contenu préféré, les offres exclusives et d'autres informations.";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String doneButtonAtTop(Locale appLocale){
        switch (appLocale){
            case EN: return "Done";
            case RU: return "Готово";
            case FR: return "Terminé";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }
    public String region(Locale appLocale) {
        switch (appLocale){
            case EN: return "Region";
            case RU: return "Регион";
            case FR: return "Région";
            default: throw new IllegalArgumentException("OOPS, I DONT KNOW WHAT IS IT");
        }
    }


}
