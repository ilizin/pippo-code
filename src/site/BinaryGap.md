# BinaryGap

## Problem description

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
Write a function that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

## Examples

| Input     | Binary representation | Output |
|-----------|:---------------------:|:------:|
| N = 9     |         1001          |   2    |
| N = 529   |      1000010001       |   4    |
| N = 20    |         10100         |   1    |
| N = 15    |         1111          |   0    |
| N = 32    |        100000         |   0    |
| N = 1041  |      10000010001      |   5    |

## Input assumptions

* N is an integer within the range [1..2147483647].