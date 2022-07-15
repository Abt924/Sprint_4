# Sprint_4
Набор автотестов для учебного сервиса 
[«Яндекс.Самокат»] (https://qa-scooter.praktikum-services.ru/)
***
- Java
- junit 4
- selenium-java
***
ru.yandex.samokat.inputs - модели полей ввода
ru.yandex.samokat.inputs.Order - модлель данных заказа и флоу верхней/нижней кнопки
ru.yandex.samokat.pages - модели страниц
***
ru.yandex.samokat - тесты
- QuestionAnswerAccordionTest - тесты FAQ вопрос-ответ одельно для кахдого вопроса  
- FAQAccordionTest - тесты логики выпадающего списка FAQ
- OrderSuccessFlowTest - тесты позитивного флоу заказа
- FollowLogoTest - тесты переходов по Лого
- TrackOrderTest - тесты отслеживания трекномера заказа
- NameInputLogicTest - тесты логики поля ввода Имя
- NameInputValidationTest - тесты валидации ввода поля Имя
***
Добавлен тест с параметризацией потока исполнения
(нажатия верхней/нижней кнопки) 
- OrderSuccessParameterizedFlowTest

Селекторы перенесены в классы POM
URL главной страницы в HomePageSamokat.URL

