Feature: OrangeHRM validation

  Scenario Outline: User Entered the Login Page
  
    Given User should navigated the URL
    When User Get UserName and PassWord in OrangeHRM
    And Used Enter the UserName as "Admin"
    Then User Enter the Password as "admin123"
    And User Click on Login button
    Then User click Admin
    Then User Enter System Users Information UserName as <username>
    And User select the role as <role>
    And User select the state as <state>
    And User Click Search button

    Examples: 
      | username | role  | state   |
      | Admin    | Admin | Enabled |
