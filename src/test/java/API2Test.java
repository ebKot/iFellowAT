import Hooks.Hooks;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static Steps.API2Steps.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Углубление в API")
public class API2Test extends Hooks {

    @Test
    @Order(1)
    @DisplayName("Проверить, что получили ответ 200.")
    public void sendBodyTest() throws IOException {
        createJSONFunc();
        sendBodyFunc();
    }

    @Test
    @Order(2)
    @DisplayName("Свериться, что полученный response имеет \"name\": \"Tomato\"")
    public void assertNameTest() throws IOException {
        createJSONFunc();
        assertNameFunc();
    }

    @Test
    @Order(3)
    @DisplayName("Свериться, что полученный response имеет \"job\": \"Eat maket\"")
    public void assertJobTest() throws IOException {
        createJSONFunc();
        assertJobFunc();
    }

    @Test
    @Order(4)
    @DisplayName("Свериться, что полученный response имеет \"id\": \"325\"")
    public void assertIdTest() throws IOException {
        createJSONFunc();
        assertIdFunc();
    }

    @Test
    @Order(5)
    @DisplayName("Свериться, что полученный response имеет \"createdAt\": \"2021-08-03T10:22:44.071Z\"")
    public void assertCreatedAtTest() throws IOException {
        createJSONFunc();
        assertCreatedAtFunc();
    }
}


//    Написать тесты с использованием Json, проверить валидность данных в ответе на запрос
//        На сайте есть документация по АPI
//        https://reqres.in/
//        Создать в проекте файл с расширением .Json
//        { "name": "Potato" }
//        Создать тест запрос для создания пользователя (CREATE)
//        Body в запрос передать из ранее созданного файла, поменяв name и добавив поле Job
//        { "name": "Tomato", "job": "Eat maket" }
//        Проверить, что получили ответ 200.
//        Свериться, что полученный response имеет валидные данные по значениям key и value.
//        {
//        "name": "Tomato",
//        "job": "Eat maket",
//        "id": "325",
//        "createdAt": "2021-08-03T10:22:44.071Z"
//        }