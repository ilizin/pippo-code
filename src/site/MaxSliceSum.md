# MaxSliceSum

Find a maximum sum of a compact subsequence of array elements.

## Problem description

A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. 
The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

For example, given array A such that:

A[0] = 3  A[1] = 2  A[2] = -6 A[3] = 4  A[4] = 0

The function should return 5 because:

* (3, 4) is a slice of A that has sum 4,
* (2, 2) is a slice of A that has sum −6,
* (0, 1) is a slice of A that has sum 5,

* No other slice of A has sum greater than (0, 1).

Write a function that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

## Examples

| Input                | Output |
|----------------------|:------:|
| A = [3, 2, -6, 4, 0] |   5    |

## Input assumptions

* N is an integer within the range [1..1,000,000]
* Each element of array A is an integer within the range [−1,000,000..1,000,000]
* The result will be an integer within the range [−2,147,483,648..2,147,483,647]


