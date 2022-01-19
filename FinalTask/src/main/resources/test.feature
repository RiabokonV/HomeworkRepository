Feature: Test
  As a user i want to test searching and filtering products
  So that i can sure that site works correctly

  Scenario Outline: Check men and women half changes correctly
    Given User open '<homePage>' page
    And User check buttons visibility
    When User click menButton
    And User see men products '<menURL>'
    When User click womenButton
    Then User see women products '<womenURL>'

    Examples:
      | homePage              | menURL                    | womenURL                    |
      | https://www.asos.com/ | https://www.asos.com/men/ | https://www.asos.com/women/ |

  Scenario Outline: Check search by keyword
    Given User open '<homePage>' page
    And User check search field visibility
    And User makes search by '<keyword>'
    When User click search button
    Then User see products contains '<keyword>'

    Examples:
      | homePage                  | keyword                          |
      | https://www.asos.com/men/ | HUGO Block Runn leather trainers |

  Scenario Outline: Check search by keyword with "Enter"
    Given User open '<homePage>' page
    And User check search field visibility
    And User makes search by '<keyword>'
    When User click key"enter" in search field
    Then User see products contains '<keyword>'

    Examples:
      | homePage                  | keyword                          |
      | https://www.asos.com/men/ | HUGO Block Runn leather trainers |

  Scenario Outline: Check search by article
    Given User open '<homePage>' page
    And User check search field visibility
    And User makes search by '<article>'
    When User click search button
    Then User see product page with '<productName>'

    Examples:
      | homePage                  | article | productName                      |
      | https://www.asos.com/men/ | 1984950 | HUGO Block Runn leather trainers |

  Scenario Outline: Check correctly filter works
    Given User open '<homePage>' page
    And User click shoes view all button
    And User click on color filter black
    Then User see product contains '<keyword>'

    Examples:
      | homePage                  | keyword       |
      | https://www.asos.com/men/ | base_colour:4 |

  Scenario Outline: Check correctly add to bag
    Given User open '<homePage>' page
    And User makes search by '<keyword>'
    When User click search button
    And User chose available size of product
    And User click add to bag button
    Then User see that amount of products in bag are '<expectedAmount>'

    Examples:
      | homePage                  | keyword | expectedAmount |
      | https://www.asos.com/men/ | 1984950 | 1              |

  Scenario Outline: Check correctly add to save page
    Given User open '<homePage>' page
    And User makes search by '<keyword>'
    When User click search button
    And User chose available size of product
    And User click save for later button
    And User click save for later page
    Then User see save products contains '<expectedName>'

    Examples:
      | homePage                  | keyword | expectedName                     |
      | https://www.asos.com/men/ | 1984950 | HUGO Block Runn leather trainers |

  Scenario Outline: Check correctly add more products
    Given User open '<homePage>' page
    And User click shoes view all button
    When User click to add more button
    Then User see '<amount>' of products

    Examples:
      | homePage                  | amount |
      | https://www.asos.com/men/ | 144    |

  Scenario Outline: Check email error message
    Given User open '<homePage>' page
    And User click to signIn button
    When User give incorrect email '<word>'
    And User click sign button
    Then User see email error message

    Examples:
      | homePage                  | word   |
      | https://www.asos.com/men/ | 123321 |

  Scenario Outline: Check password error message
    Given User open '<homePage>' page
    And User click to signIn button
    When User give incorrect password
    And User click sign button
    Then User see password error message

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |