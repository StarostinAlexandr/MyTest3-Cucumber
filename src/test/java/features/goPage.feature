Feature: Проверка курса валюты сайта Открытие
  Проверяем курс валюты этой фичей

  @otladish2
  Scenario Outline: Переход на сайте Открытие по ссылке
    Given перейти на сайт 'https://www.open.ru/'
#    Given курс <валюта><значение1><операция><значение2>
    Then курс <валюта><значение1><операция><значение2>
    Then закончить работу

    Examples:
      | валюта        | значение1     | операция | значение2    |
      | USD от 1000 $ | Банк покупает | <        | Банк продает |
      | EURот 1000 €  | Банк покупает | <        | Банк продает |

#    Then вывести курс валют если <валюта><значение1><операция><значение2>

