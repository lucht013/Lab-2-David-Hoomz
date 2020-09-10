# Lab-2-David-Hoomz
## TODO
* [x] Make class ```TestInteger```
    * [x] Implements ```Comparable<TestInteger>``` interface
    * [x] Has a integer field ```value``` (used by ```compareTo```)
    * [x] Has a static ```long``` field called ```counter``` to count number of object comparisons
    * [x] ```compareTo``` returns the result of comparisons
* [x] Implement ```quicksort``` from p.171 of Intro to Algorithms
    * [x] Make sure it's **in place**
    * [x] Takes an array of ```TestInteger```
    * [x] Use compareTo instead of <
* [x] Write a method ```isSorted``` that takes an array of ```TestInteger``` and returns ```true``` if sorted and ```false``` otherwise
* [x] Generate 10,000 random ```testIntegers``` from 1 to 1,000,000 and copy them into two arrays
    * [x] sort one with ```Tim Sort``` and one with ```quicksort```.
    * [x] do it 5 times while recording the time and total number of comparisons
* [x] Repeat sorting, but instead of it being random, do it using arrays of increasing order
* [x] Repeat sorting but use 10 (randomly ordered) sorted sequences of 1000 elements each
* [x] Repeat sorting but use 100 (randomly ordered) sorted sequences of 100 elements each

#The Questions
### For each kind of data, which of the two algorithms performs better?
* Tim Sort
    
    TimSort appears to work best on everything except for the first test, in which 
    quicksort worked better. TimSort especially did well on test 2. One particular
    note for test 2 was that timsort always did the bare minimum number of comparisons.
* quicksort
    
    Quicksort only did well on the first test, even though timSort actually
    had fewer comparisons. We're not sure why this is. We think the reason
    Quicksort did particularly poorly on the second test is because it needed
    to loop many more times since it was already in order.

#Raw Results
```
Test 1: Quicksort won
Comparing 10,000 random testInts from 1 to 1,000,000 5 times...
Quicksort is sorted: false with 0 comparisons
Trial 1 quicksort result: 3ms with 155570 comparisons
Quicksort validation: true
Timsort is sorted: false with 0 comparisons
Trial 1 TimSort result: 7 ms with 120423 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 2 quicksort result: 1ms with 150428 comparisons
Quicksort validation: true
Timsort is sorted: false with 0 comparisons
Trial 2 TimSort result: 3 ms with 120417 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 3 quicksort result: 1ms with 167994 comparisons
Quicksort validation: true
Timsort is sorted: false with 0 comparisons
Trial 3 TimSort result: 3 ms with 120348 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 4 quicksort result: 2ms with 147762 comparisons
Quicksort validation: true
Timsort is sorted: false with 0 comparisons
Trial 4 TimSort result: 2 ms with 120373 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 5 quicksort result: 2ms with 148124 comparisons
Quicksort validation: true
Timsort is sorted: false with 0 comparisons
Trial 5 TimSort result: 6 ms with 120416 comparisons
Timsort validation: true
```
```
Test 2: TimSort won
Comparing 10,000 ordered testInts from 1 to 1,000,000 5 times...
Quicksort is sorted: true with 0 comparisons
Trial 1 quicksort result: 136ms with 49995000 comparisons
Quicksort validation: true
Timsort is sorted: true with 0 comparisons
Timsort is sorted: true
Trial 1 TimSort result: 0 ms with 9999 comparisons



Quicksort is sorted: true with 0 comparisons
Trial 2 quicksort result: 164ms with 49995000 comparisons
Quicksort validation: true
Timsort is sorted: true with 0 comparisons
Timsort is sorted: true
Trial 2 TimSort result: 0 ms with 9999 comparisons

Quicksort is sorted: true with 0 comparisons
Trial 3 quicksort result: 122ms with 49995000 comparisons
Quicksort validation: true
Timsort is sorted: true with 0 comparisons
Timsort is sorted: true
Trial 3 TimSort result: 0 ms with 9999 comparisons

Quicksort is sorted: true with 0 comparisons
Trial 4 quicksort result: 133ms with 49995000 comparisons
Quicksort validation: true
Timsort is sorted: true with 0 comparisons
Timsort is sorted: true
Trial 4 TimSort result: 0 ms with 9999 comparisons

Quicksort is sorted: true with 0 comparisons
Trial 5 quicksort result: 140ms with 49995000 comparisons
Quicksort validation: true
Timsort is sorted: true with 0 comparisons
Timsort is sorted: true
Trial 5 TimSort result: 0 ms with 9999 comparisons
```

 ```
Test 3: TimSort won
Comparing 10 sorted sequences of 1,000 ordered elements from 1 to 1,000,000 5 times...
Quicksort is sorted: false
Timsort is sorted: false
Trial 1 quicksort result: 47ms with 19009000 comparisons
Quicksort validation: true
Trial 1 TimSort result: 0 ms with 10323 comparisons
Timsort validation: true

Quicksort is sorted: false
Timsort is sorted: false
Trial 2 quicksort result: 40ms with 10013000 comparisons
Quicksort validation: true
Trial 2 TimSort result: 1 ms with 10330 comparisons
Timsort validation: true

Quicksort is sorted: false
Timsort is sorted: false
Trial 3 quicksort result: 134ms with 19002000 comparisons
Quicksort validation: true
Trial 3 TimSort result: 0 ms with 10259 comparisons
Timsort validation: true

Quicksort is sorted: false
Timsort is sorted: false
Trial 4 quicksort result: 142ms with 28690584 comparisons
Quicksort validation: true
Trial 4 TimSort result: 53 ms with 11104 comparisons
Timsort validation: true

Quicksort is sorted: false
Timsort is sorted: false
Trial 5 quicksort result: 96ms with 18003000 comparisons
Quicksort validation: true
Trial 5 TimSort result: 0 ms with 10341 comparisons
Timsort validation: true
```
 ```
Test 4: TimSort won
Comparing 100 sorted sequences of 100 ordered elements from 1 to 1,000,000 5 times...
Quicksort is sorted: false with 0 comparisons
Trial 1 quicksort result: 12ms with 4094653 comparisons
Quicksort validation: true
Quicksort is sorted: true with 0 comparisons
Trial 1 TimSort result: 0 ms with 14709 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 2 quicksort result: 10ms with 3206900 comparisons
Quicksort validation: true
Quicksort is sorted: true with 0 comparisons
Trial 2 TimSort result: 1 ms with 14395 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 3 quicksort result: 15ms with 3823100 comparisons
Quicksort validation: true
Quicksort is sorted: true with 0 comparisons
Trial 3 TimSort result: 0 ms with 14580 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 4 quicksort result: 23ms with 4281292 comparisons
Quicksort validation: true
Quicksort is sorted: true with 0 comparisons
Trial 4 TimSort result: 1 ms with 14886 comparisons
Timsort validation: true

Quicksort is sorted: false with 0 comparisons
Trial 5 quicksort result: 28ms with 4087169 comparisons
Quicksort validation: true
Quicksort is sorted: true with 0 comparisons
Trial 5 TimSort result: 1 ms with 14406 comparisons
Timsort validation: true
```