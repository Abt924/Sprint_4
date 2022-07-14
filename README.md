# Sprint_4
Набор автотестов для учебного сервиса 
[«Яндекс.Самокат»] (https://qa-scooter.praktikum-services.ru/)
***
- Java
- junit 4
- selenium-java
***
ru.yandex.samokat.inputs - модели полей ввода
ru.yandex.samokat.pages - модели страниц

для страниц (элементов)
- HomePage
- ForWhom
- AboutRent
- FAQAccordion

селекторы выненсены в интерфейсы (iHome и т.д.)
***
ru.yandex.samokat - тесты
- QuestionAnswerAccordionTest - тесты FAQ вопрос-ответ одельно для кахдого вопроса  
- FAQAccordionTest - тесты логики выпадающего списка FAQ
- OrderSuccessFlowTest - тесты позитивного флоу заказа
- FollowLogoTest - тесты переходов по Лого
- TrackOrderTest - тесты отслеживания трекномера заказа
- NameInputLogicTest - тесты логики поля ввода Имя
- NameInputValidationTest - тесты валидации ввода поля Имя
