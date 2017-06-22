#!/bin/python3

import sys


w = input().strip()
# Print 'Yes' if the word is beautiful or 'No' if it is not.

s = "Yes"

#vowels = ['a', 'e', 'i', 'o', 'u', 'y']

for i in range(1, (len(w))):
    if w[i] == w[i-1]:
        s = "No"
    if (w[i] == 'a' or w[i] == 'e' or w[i] == 'i' or w[i] == 'o' or w[i] == 'u' or w[i] == 'y') and (w[i-1] == 'a' or w[i-1] == 'e' or w[i-1] == 'i' or w[i-1] == 'o' or w[i-1] == 'u' or w[i-1] == 'y'):
        s = "No"

print(s)

print('a' or 'b')