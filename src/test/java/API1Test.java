import Hooks.Hooks;
import org.junit.jupiter.api.*;

import static Steps.API1Steps.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Погружение в API")
public class API1Test extends Hooks {
    @Test
    @Order(1)
    @DisplayName("Найти информацию по персонажу Морти Смит.")
    public void gettingCharInfoTest() {
        gettingCharInfoFunc("2");
    }

    @Test
    @Order(2)
    @DisplayName("Выбрать из ответа последний эпизод, где появлялся Морти.")
    public void gettingLastEpisodeTest() {
        gettingCharInfoFunc("2");
        gettingLastEpisodeFunc();
        System.out.println("Последний эпизод, где появлялся " + charName + ": " + charLastEpisode);
    }

    @Test
    @Order(3)
    @DisplayName("Получить из списка последнего эпизода последнего персонажа. Получить данные по местонахождению и расе этого персонажа.")
    public void gettingLastCharacterTest() {
        gettingCharInfoFunc("2");
        gettingLastEpisodeFunc();
        gettingLastCharacterFunc();
        System.out.println("Последний персонаж из последнего эпизода, где появлялся " + charName + ": " + lastCharacterName);
        System.out.println("Местонахождение этого персонажа: " + lastCharacterLoc);
        System.out.println("Разновидность этого персонажа: " + lastCharacterSpec);
    }

    @Test
    @Order(4)
    @DisplayName("Проверить, этот персонаж находится там же где и Морти?")
    public void assertLocTest() {
        gettingCharInfoFunc("2");
        gettingLastEpisodeFunc();
        gettingLastCharacterFunc();
        assertLocFunc();
    }

    @Test
    @Order(5)
    @DisplayName("Проверить, этот персонаж той же расы как и Морти?")
    public void assertSpecTest() {
        gettingCharInfoFunc("2");
        gettingLastEpisodeFunc();
        gettingLastCharacterFunc();
        assertSpecFunc();
    }

}