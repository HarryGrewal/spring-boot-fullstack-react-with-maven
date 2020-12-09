insert into TASK(TASK, DESCRIPTION, TEST_INPUT, TEST_OUTPUT)
values ('Fizz Buzz',
        'Write a program that outputs the string representation of numbers from 1 to n. ' ||
        'But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. ' ||
        'For numbers which are multiples of both three and five output “FizzBuzz”. ' ||
        'For Example : ' ||
        'Input: 15 ' ||
        'Output: ["1", "2","Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"] ',
        '15',
        '["1", "2","Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]'),
       ('Palindrome Number',
        'Determine whether an integer is a palindrome. ' ||
        'An integer is a palindrome when it reads the same backward as forward. ' ||
        'For Example : ' ||
        'Input: 121 ' ||
        'Output: true ',
        '121',
        'true'),
       ('Fibonacci Number',
        'The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, ' ||
        'such that each number is the sum of the two preceding ones, starting from 0 and 1. ' ||
        'Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3. ' ||
        'For Example : ' ||
        'Input: 4 ' ||
        'Output: 3 ',
        '4',
        '3'),
       ('Reverse Integer',
        'Given a 32-bit signed integer, reverse digits of an integer. ' ||
        'For Example : ' ||
        'Input: 123 ' ||
        'Output: 321 ',
        '123 ',
        '321'),
       ('Reverse String',
        ('Write a function that reverses a string. The input string is given as an array of characters char[]. ') ||
        'For Example : ' ||
        'Input: hello ' ||
        'Output: olleh ',
        ('hello'),
        ('olleh'));


