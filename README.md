# Lab-2-David-Hoomz
## TODO
* [x] Make class ```TestInteger```
    * [x] Implements ```Comparable<TestInteger>``` interface
    * [x] Has a integer field ```value``` (used by ```compareTo```)
    * [x] Has a static ```long``` field called ```counter``` to count number of object comparisons
    * [x] ```compareTo``` returns the result of comparisons
* [ ] Implement ```quicksort``` from p.171 of Intro to Algorithms
    * [ ] Make sure it's **in place**
    * [ ] Takes an array of ```TestInteger```
    * [ ] Use compareTo instead of <
* [x] Write a method ```isSorted``` that takes an array of ```TestInteger``` and returns ```true``` if sorted and ```false``` otherwise
* [ ] Generate 10,000 random ```testIntegers``` from 1 to 1,000,000 and copy them into two arrays
    * [ ] sort one with ```Tim Sort``` and one with ```quicksort```.
    * [ ] do it 5 times while recording the time and total number of comparisons
* [ ] Repeat sorting, but instead of it being random, do it using arrays of increasing order
* [ ] Repeat sorting but use 10 (randomly ordered) sorted sequences of 1000 elements each
* [ ] Repeat sorting but use 100 (randomly ordered) sorted sequences of 100 elements each

#The Questions
### For each kind of data, which of the two algorithms performs better?
* Tim Sort

* quicksort
