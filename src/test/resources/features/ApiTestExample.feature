Feature: Technical Test


  Scenario Outline: Test Api assessment postive
    Given I get a request  "<EndPoint>" "<City>" "<ApiId>"
    Then I Assert the response "<StatusCode>" "<Results>"

    Examples:
      | EndPoint                                   | City       | ApiId                            | StatusCode | Results    |
      | api.openweathermap.org/data/2.5/weather?q= | Newtonhill | c58d16a110dd4e338a559e0bde400c66 | 200        | Newtonhill |

  Scenario Outline: Test Api assessment negative
    Given I get a request  "<EndPoint>" "<City>" "<ApiId>"
    Then I Assert the response Negative "<StatusCode>" "<Results>"

    Examples:
      | EndPoint                                   | City    | ApiId                            | StatusCode | Results    |
      | api.openweathermap.org/data/2.5/weather?q= | testing | c58d16a110dd4e338a559e0bde400c66 | 404        | city not found |


#post examples
  @testing1
  Scenario Outline: Add a new pet with an auto generated name and status available - Confirm the new pet has been added

    Given  I get a request "<endpoint>"  "<name>"
    Then  I add a new pet and status available "<result>"

    Examples:
      | endpoint                           | name    | result  |
      | https://petstore.swagger.io/v2/pet | new pet | new pet |