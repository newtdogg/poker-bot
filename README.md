# Big Brain

Big brain is a game where you can play heads-up (one-on-one) Texas Hold’Em Poker vs. our AI. This project was developed in two weeks by four of us as a final project for Makers Academy.

## Getting Started

THIS IS WHERE WE DESCRIBE HOW TO RUN THE PROGRAM

## Testing

We used JUnit to test, with Mockito to create mocks.

DESCRIBE HOW TO RUN THE TESTS

Using intellij’s inbuilt test coverage tool, we found out that our test coverage was very high. For example, for the most important classes, Bot.java and Evaluator.java, our test coverage is 100%.

We should of probably used Mockito from the start, and this is something all of us have taken away from the two week project. We were late to implement it, and we have only used it in a few cases, however given more time we would definitely aim to implement mocking more.

## Our approach

Visit the blog [here](https://pokerprogressioninjava.wordpress.com/) and read about the development of the project in full.

**In summary**

Our approach was to take on step at a time. It became clear within the first few days of the project that poker is a pretty complicated game, and what made it more complicated is that the only team member who actually knew all the rules was Ted.
Along with learning poker, we had to actually decide what we wanted to make. We left our meeting with Kay with ‘Make a poker bot’. There were so many ways we could have taken this idea, such as uploading it to complete against other bots on The AI Games, make a poker game that two players could play and make a bot v bot game.
After a few days of not worrying about where the project was heading, and only focusing on what we needed to do to make the bot marginally better, for example creating a single card. Creating a deck with 52 unique cards, dealing a bot class two random cards, etc. As the days progressed we united as one and all saw the where our project was heading - and we all liked it.
First we would have to get our bot to evaluate cards and spot that it had a hand worthy of playing, this was implemented by an algorithm that applied weight to all 1326 possible combinations of cards. Demonstrated by this lovely diagram.
INSERT DIAGRAM

Then we would have to re evaluate the bots hand at each stage of a poker round.
Of which there are three stages. The flop, after the first three cards are dealt, the turn and the river giving a total of 7 cards in the bots hand, five of which are communal.
At each stage the bot would have to evaluate from x cards which cards were the best five, and how valuable were the best five cards. For example a high pair of aces was not as valuable as a straight, so the bot would select the straight.
This involved a huge amount of sorting algorithms, for which we are extremely thankful of Kesha’s genius, he came up with a way of storing the cards data so that each algorithms, of which there were 10, would be infinitely easier to write.

Kesha’s sorting system is made to facilitate finding the best hand. It comprises of three separate arrangements of the cards, one by the ranks (to help find pairs, two pairs, three of a kinds etc.), ordered by suit (to help find flushes, royal flushes etc.), and lastly by rank to help find straights. These systems made finding tricks much easier as we only had to target the specific arrangement we required, rather than searching and ordering each type of hand.

One particularly hard algorithm was the unsuited Straight, and Joe ground it out to get a flawless function that would spot a straight in any selection of cards — which was the extended out to predict if a straight was going to occur on the turn and on the river.
With that we had a way of selecting the best five cards at any stage of the poker game, however it was Friday, the feature freeze was rapidly approaching, and it was already sending shivers down our spines.
We still had no game of poker, no betting system and no actual output other than passing tests. It was time to pull it all together. Ted nominated himself to deal with the user interface, in our case that meant dealing with Java’s Swing, which allows you to build a funky Graphical User Interfaces with apparent ease. With ease it was not built, but with determination to do some sort of front end work, sorry Ted no HTML & CSS here, he basically created the game, the game rules and the user interface in three days.
All that was left to do was to pull the whole project together, and get the bots output to display on the GUI, and play with the bots weighting system so that it made fewer brash decisions.

## What would we have done differently

All of us agree that given more time, we would have constructed the game and all the game logic first and then implemented the bot. Joe also found a poker hand evaluator built by [Cactus Kev](http://suffe.cool/poker/evaluator.html) that uses a very nifty bitwise operator algorithm to give each poker hand a unique value that could later be called upon. What was different about Cactus Kev’s approach was that *every* hand up to seven was given a value, where as in our program only gives winning hands a unique value.

## Built with

Java

JUnit - for testing

Swing - for GUI (graphical user interface)

Maven - for software project management

Mockito - for mocking tests

Intellij - as the IDE

## Built by

| [Kesha Kumshayev](https://github.com/ikumsh) | [Joe Pike](https://github.com/joepike) | [Tom Allpress](https://github.com/tallpress) | [Ted Newton](https://github.com/newtdogg) |
