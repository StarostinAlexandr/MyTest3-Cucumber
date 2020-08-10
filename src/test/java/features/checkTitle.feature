Feature: Проверка возможностей
  Проверяем тайтл этой фичей

  @otladish
  Scenario: Тайтл верен
    Given перейти на сайт 'https://www.open.ru/'
    Then тайтл верен 'Открытие'
    Then закончить работу