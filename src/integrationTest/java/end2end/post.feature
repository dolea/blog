Feature: Read posts

  Scenario: Posts already in the blog
    Given There are 3 posts written in the blog
    When Dani wants to see the posts in the blog
    Then Dani sees all 3 posts

  Scenario: No post in the blog
    Given There are no posts in the blog
    When Dani wants to see the posts in the blog
    Then Dani sees none